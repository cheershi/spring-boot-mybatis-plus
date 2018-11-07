package com.tnar.springbootmybatisplus.web;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tnar.springbootmybatisplus.entity.Discuss;
import com.tnar.springbootmybatisplus.entity.User;
import com.tnar.springbootmybatisplus.entity.Weibo;
import com.tnar.springbootmybatisplus.service.impl.DiscussServiceImpl;
import com.tnar.springbootmybatisplus.service.impl.UserServiceImpl;
import com.tnar.springbootmybatisplus.service.impl.WeiboServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cf
 * @since 2018-10-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DiscussServiceImpl discussService;
    @Autowired
    private WeiboServiceImpl weiboService;

    @GetMapping("/message")
    public JSONObject getMessage(){
        JSONObject object = new JSONObject();
        object.put("message","您拥有用户权限,您获得了权限");
        return object;
    }

    @GetMapping("/list")
    public JSONObject getList(){
        JSONObject object = new JSONObject();
        Page<User> page = new Page<>(1,3);
        Page<User> page1 = userService.selectPage(page);
        object.put("message",page1);
        return object;
    }

    @GetMapping("/discuss")
    public JSONObject getDiscussList(){
        JSONObject object = new JSONObject();
        Page<Discuss> page = new Page<>(1,3);
        Page<Discuss> discussPage = discussService.selectDiscussPage(page);
        object.put("message",discussPage);
        return object;
    }

    @GetMapping("/get")
    public JSONObject getDiscuss(){
        JSONObject object = new JSONObject();
        List<Discuss> discuss = discussService.getDiscuss(1);
        object.put("message",discuss);
        return object;
    }

    @PostMapping("/dynamic")
    public JSONObject getDynamicDiscuss(Discuss discuss){
        JSONObject object = new JSONObject();
        List<Discuss> list = discussService.selectDynamicDiscuss(discuss);
        object.put("message",list);
        return object;
    }


    @GetMapping("/weibo")
    public JSONObject getWeiboList(){
        JSONObject object = new JSONObject();
        Page<Weibo> page = new Page<>(1,15);
        Page<Weibo> weiboPage = weiboService.selectPageWeiBo(page);
        object.put("message",weiboPage);
        return object;
    }

    @PutMapping("/update")
    public JSONObject updateUser(Integer id){
        JSONObject object = new JSONObject();
        User user = new User();
        user.setPwd("233");
        user.setAge(33);
        boolean id1 = userService.update(user, new EntityWrapper<User>().eq("id", id));
        object.put("message",id1);
        return object;
    }

    @DeleteMapping("/delete")
    public JSONObject deleteUser(Integer id){
        JSONObject object = new JSONObject();
        boolean id1 = userService.delete(new EntityWrapper<User>().eq("id", id));
        object.put("message",id1);
        return object;
    }

    @PostMapping("/insert")
    public JSONObject insertUser(User user){
        JSONObject object = new JSONObject();
        boolean insert = userService.insert(user);
        object.put("message",insert);
        return  object;
    }




}
