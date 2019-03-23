package com.book.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.book.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * Book, 代表一个账本
 *
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Alias("Book")
@TableName(value = "book", resultMap = "bookResultMap")
public class Book extends BaseEntity<Long> {

    private String name;

    @TableField("account_date")
    private String accountDate;

    @TableField("closing_account_date")
    private String closingAccountDate;

    @TableField("abstract_id")
    private long abstractId;

    @TableField(exist = false)
    private String abstractContent;

}
