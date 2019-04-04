package com.book.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.book.common.BaseEntity;
import com.book.entity.type.AccountDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 记账
 *
 * @author Zhao Jinyan
 * @date 2019/4/3 15:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "accounting_entry")
public class AccountingEntry extends BaseEntity<Long> {

    /**
     * 账本ID
     */
    @TableField("book_id")
    private int bookId;

    /**
     * 交易日期
     */
    @TableField("trans_date")
    private AccountDate transDate;

    /**
     * 摘要
     */
    @TableField("abstract_id")
    private int abstractId;

    /**
     * 摘要内容
     */
    @TableField(exist = false)
    private int abstractContent;

}
