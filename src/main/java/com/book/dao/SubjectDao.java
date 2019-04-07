package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.Subject;
import com.book.entity.type.SubjectNumber;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Subject Dao
 *
 * @author Zhao Jinyan
 * @date 2019/3/31 21:51
 */
public interface SubjectDao extends BaseMapper<Subject> {

    /**
     * 根据科目号和账本查询科目
     * @param subjectNumber 科目号
     * @param bookId 账本id
     * @return 科目
     */
    @Select("select * from subject where subject_number=#{subjectNumber} and book_id = #{book_id}")
    Subject selectBySubjectNumberAndBookId(
        @Param("subjectNumber") SubjectNumber subjectNumber, @Param("bookId") long bookId);

}
