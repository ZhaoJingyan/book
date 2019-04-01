package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.Water;
import com.book.entity.type.AccountDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Water Dao
 *
 * @author Zhao Jinyan
 * @date 2019/4/1 19:51
 */
public interface WaterDao extends BaseMapper<Water> {

    List<Water> selectByTransDate(@Param("beginDate") AccountDate beginDate, @Param("endDate") AccountDate endDate);

}
