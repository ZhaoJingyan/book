package com.book.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类的父类
 *
 * @param <I> 主键类型
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
@Data
public abstract class BaseEntity<I> implements Serializable {

    /**
     * id,主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private I id = null;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

}
