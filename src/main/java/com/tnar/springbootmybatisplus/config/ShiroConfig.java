package com.tnar.springbootmybatisplus.config;

import com.tnar.springbootmybatisplus.shiro.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/notlogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/notrole");

        Map<String, String> map = new LinkedHashMap<>();
        map.put("/guest/**", "anon");
        map.put("/user/**", "roles[user]");
        map.put("/admin/**", "roles[admin]");
        map.put("/login", "anon");
        map.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return  shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean
    public Realm myRealm(){
        return new MyRealm();
    }
}
