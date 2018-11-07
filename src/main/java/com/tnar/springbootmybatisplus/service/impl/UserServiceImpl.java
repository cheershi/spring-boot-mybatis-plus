package com.tnar.springbootmybatisplus.service.impl;

import com.tnar.springbootmybatisplus.entity.User;
import com.tnar.springbootmybatisplus.mapper.UserMapper;
import com.tnar.springbootmybatisplus.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cf
 * @since 2018-10-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

           

}
