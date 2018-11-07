package com.tnar.springbootmybatisplus.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/message")
    public JSONObject getMessage(){
        JSONObject object = new JSONObject();
        object.put("message","您拥有管理员权限,您获得了权限");
        return object;
    }
}
