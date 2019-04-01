package com.book.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.book.common.BaseEntity;
import com.book.entity.type.SubjectNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 * @author Zhao Jinyan
 * @date 2019/4/1 19:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Alias("Water")
@TableName(value = "water")
public class Water extends BaseEntity<Integer> {

    /**
     * 账本id
     */
    @TableField("book_id")
    private int bookId;

    /**
     * 科目号
     */
    @TableField("subject_number")
    private SubjectNumber subjectNumber;

    /**
     * 日志号
     */
    @TableField("log_id")
    private int logId;

    /**
     * 金额
     */
    @TableField("money")
    private BigDecimal money;

}
