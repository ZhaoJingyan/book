package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.Abstract;
import org.apache.ibatis.annotations.Select;

public interface AbstractDao extends BaseMapper<Abstract> {

    @Select("select content from abstract where id=#{id}")
    String selectContentById(long id);

}
