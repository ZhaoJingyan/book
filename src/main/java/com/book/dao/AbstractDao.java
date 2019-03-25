package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.Abstract;
import org.apache.ibatis.annotations.Select;

/**
 * Abstract Dao
 *
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
public interface AbstractDao extends BaseMapper<Abstract> {

    /**
     * 查询content字段的内容
     *
     * @param id abstract id
     * @return content string
     */
    @Select("select content from abstract where id=#{id}")
    String selectContentById(long id);

}
