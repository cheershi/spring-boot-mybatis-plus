package com.tnar.springbootmybatisplus.mapper;



import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.tnar.springbootmybatisplus.entity.Discuss;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cf
 * @since 2018-11-05
 */
public interface DiscussMapper extends BaseMapper<Discuss> {

    List<Discuss> selectDiscussPage(Pagination page );

    List<Discuss> getDisById(Integer id);

    List<Discuss> selectDynamicDiscuss(Discuss discuss);
}
