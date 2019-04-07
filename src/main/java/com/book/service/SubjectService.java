package com.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.book.common.BookException;
import com.book.entity.Subject;
import com.book.entity.type.SubjectNumber;

import java.util.List;

/**
 * 科目
 *
 * @author Zhao Jinyan
 * @date 2019/4/3 21:30
 */
public interface SubjectService {

    /**
     * 保存一个subject
     *
     * @param subject 科目
     * @return 科目
     */
    Subject save(Subject subject) throws BookException;

    /**
     * 获取科目
     *
     * @param id ID
     * @return 科目
     */
    Subject get(long id);

    /**
     * 获取科目
     *
     * @param bookId 账本id
     * @param subjectNumber 科目号
     * @return 科目
     */
    Subject get(long bookId, SubjectNumber subjectNumber) throws BookException;

    /**
     * 获取科目
     * @param parentSubject 父科目
     * @param pageNum 页码
     * @param pageSize 页尺寸
     * @return 科目
     */
    IPage<Subject> get(Subject parentSubject, int pageNum, int pageSize);

}
