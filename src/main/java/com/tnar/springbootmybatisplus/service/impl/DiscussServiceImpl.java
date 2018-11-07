package com.tnar.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.tnar.springbootmybatisplus.entity.Discuss;
import com.tnar.springbootmybatisplus.mapper.DiscussMapper;
import com.tnar.springbootmybatisplus.service.IDiscussService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cf
 * @since 2018-11-05
 */
@Service
public class DiscussServiceImpl extends ServiceImpl<DiscussMapper, Discuss> implements IDiscussService {

    public Page<Discuss> selectDiscussPage(Page<Discuss> page) {
        return page.setRecords(baseMapper.selectDiscussPage(page));
    }

    public List<Discuss> getDiscuss(Integer id){
        return this.baseMapper.getDisById(id);
    }

    public List<Discuss> selectDynamicDiscuss(Discuss discuss){
        return this.baseMapper.selectDynamicDiscuss(discuss);
    }
}
