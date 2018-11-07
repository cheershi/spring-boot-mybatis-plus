package com.tnar.springbootmybatisplus.web;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tnar.springbootmybatisplus.entity.User;
import com.tnar.springbootmybatisplus.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/notlogin")
    public JSONObject notLogin(){
        JSONObject object = new JSONObject();
        object.put("fail","您没有登录");
        return  object;
    }

    @GetMapping("/notrole")
    public JSONObject notRole(){
        JSONObject object = new JSONObject();
        object.put("fail","您没有权限");
        return  object;
    }

    @GetMapping("/logout")
    public JSONObject logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        JSONObject object = new JSONObject();
        object.put("success","成功注销");
        return  object;
    }

    @PostMapping("/login")
    public JSONObject login(String username,String password){
        JSONObject object = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
        List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("name", username));
        if (users.size()==0){
            object.put("fail",".....");
            return object;
        }
        String role = users.get(0).getRole();
        if(role.equals("user")){
            object.put("success","欢迎登录");
            return object;
        }
        if(role.equals("admin")){
            object.put("success","欢迎来的管理员页面");
            return object;
        }
        object.put("fail","无权限");
        return object;
    }

}
