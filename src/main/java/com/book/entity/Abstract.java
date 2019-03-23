package com.book.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.book.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * 摘要
 *
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Alias("Abstract")
@TableName("abstract")
public class Abstract extends BaseEntity<Long> {

    private String content;

}
