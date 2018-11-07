package com.tnar.springbootmybatisplus.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tnar.springbootmybatisplus.entity.*;
import com.tnar.springbootmybatisplus.mapper.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("name", username));
        String role = users.get(0).getRole();
        Set<String> set = new HashSet<>();
        set.add(role);
        authorizationInfo.addRoles(set);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        List<User> username = userMapper.selectList(new EntityWrapper<User>().eq("name", token.getUsername()));
        if (0==username.size()){
            throw new AccountException("用户不存在");
        }
        else if(!username.get(0).getPwd().equals(new String((char[]) token.getCredentials()))){
            throw new AccountException("密码不正确");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(),username.get(0).getPwd(),getName());
        return authenticationInfo;
    }
}
