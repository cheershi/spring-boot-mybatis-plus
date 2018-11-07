package com.tnar.springbootmybatisplus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.tnar.springbootmybatisplus.entity.Discuss;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cf
 * @since 2018-11-05
 */
public interface IDiscussService extends IService<Discuss> {

    Page<Discuss> selectDiscussPage(Page<Discuss> page);
}
