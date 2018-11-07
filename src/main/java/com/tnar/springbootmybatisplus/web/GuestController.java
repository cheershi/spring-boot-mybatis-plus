package com.tnar.springbootmybatisplus.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @GetMapping("/enter")
    public JSONObject login() {
        JSONObject object = new JSONObject();
        object.put("succrss", "欢迎进入，您的身份是游客");
        return object;
    }

    @GetMapping("/message")
    public JSONObject getMessage() {
        JSONObject object = new JSONObject();
        object.put("message", "您拥有获得该接口的权限");

        return object;
    }


}
