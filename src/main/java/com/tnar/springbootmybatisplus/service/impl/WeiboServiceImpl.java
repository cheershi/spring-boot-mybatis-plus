package com.tnar.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.tnar.springbootmybatisplus.entity.Weibo;
import com.tnar.springbootmybatisplus.mapper.WeiboMapper;
import com.tnar.springbootmybatisplus.service.IWeiboService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class WeiboServiceImpl extends ServiceImpl<WeiboMapper, Weibo> implements IWeiboService {

    public Page<Weibo> selectPageWeiBo(Page<Weibo> page){
        return page.setRecords(this.baseMapper.selectPageWeiBo(page));
    }
}
