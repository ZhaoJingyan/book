package com.book.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.book.common.BaseEntity;
import com.book.entity.type.AccountDate;
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

    /**
     * 账本名称
     */
    private String name;

    /**
     * 账本开始日期
     */
    @TableField("account_date")
    private AccountDate accountDate;

    /**
     * 封帐日期
     */
    @TableField("closing_account_date")
    private AccountDate closingAccountDate;

    /**
     * 会计摘要id
     */
    @TableField("abstract_id")
    private long abstractId;

    /**
     * 摘要内容
     */
    @TableField(exist = false)
    private String abstractContent;

}
