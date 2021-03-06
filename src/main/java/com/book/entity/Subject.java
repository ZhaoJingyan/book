package com.book.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.book.common.BaseEntity;
import com.book.entity.type.SubjectNumber;
import com.book.entity.type.SubjectPath;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * 科目
 *
 * @author Zhao Jinyan
 * @date 2019/3/26 12:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Alias("Subject")
@TableName(value = "subject", resultMap = "subjectResultMap")
public class Subject extends BaseEntity<Long> {

    @TableField("subject_number")
    private SubjectNumber subjectNumber;

    /**
     * 账本id
     */
    @TableField("book_id")
    private int bookId;

    /**
     * 路径
     */
    @TableField("path")
    private SubjectPath path;

    /**
     * 科目名称
     */
    @TableField("name")
    private String name;

    /**
     * 上级科目
     */
    @TableField("pid")
    private SubjectNumber pid;

    /**
     * 是否有下级科目
     */
    @TableField("is_directory")
    private boolean directory;

    /**
     * 摘要
     */
    @TableField("abstract_id")
    private long abstractId;

    /**
     * 摘要内容
     */
    @TableField(exist = false)
    private String abstractContent;

}
