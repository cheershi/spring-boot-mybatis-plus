package com.tnar.springbootmybatisplus.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.AccountException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AccountException.class)
    public JSONObject handleShiroException(Exception ex){
        JSONObject object = new JSONObject();
        object.put("fail",ex.getMessage());
        return  object;
    }
}
