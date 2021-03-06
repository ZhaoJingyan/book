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

    /**
     * 根据transDate查询流水
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return water list
     */
    List<Water> selectByTransDate(@Param("beginDate") AccountDate beginDate, @Param("endDate") AccountDate endDate);

}
