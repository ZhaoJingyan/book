package com.book.service.impl;

import java.util.Optional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.book.common.BookException;
import com.book.common.Extend;
import com.book.common.OptionalUtils;
import com.book.dao.SubjectDao;
import com.book.entity.Subject;
import com.book.entity.type.SubjectNumber;
import com.book.entity.type.SubjectPath;
import com.book.service.AbstractService;
import com.book.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author Zhao Jinyan
 * @date 2019/4/6 15:23
 */
@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDao subjectDao;

    private final AbstractService abstractService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public SubjectServiceImpl(SubjectDao subjectDao, AbstractService abstractService) {
        this.subjectDao = subjectDao;
        this.abstractService = abstractService;
    }

    /**
     * 保存一个subject
     *
     * @param subject 科目
     * @return 科目
     */
    @Override
    public Subject save(Subject subject) throws BookException {

        try {
            if (exists(subject)) {
                throw new BookException("科目已存在,科目号:{},账本id:{}", subject.getSubjectNumber(), subject.getBookId());
            }
            if (!existsParentSubject(subject)) {
                throw new BookException("父科目不存在,pid={},subjectNumber={},bookId={}", subject.getPid(),
                    subject.getSubjectNumber(), subject.getBookId());
            }
            updateParentSubject(subject);
            if (subject.getId() == null) {
                Extend.is(OptionalUtils.isNotBlank(subject.getAbstractContent()),
                    () -> subject.setAbstractId(abstractService.save(subject.getAbstractContent().trim())));
                subjectDao.insert(subject);
            } else {
                Extend.is(OptionalUtils.isNotBlank(subject.getAbstractContent()),
                    () -> subject.setAbstractId(abstractService.save(subject.getAbstractId(), subject.getAbstractContent())));
                subjectDao.updateById(subject);
            }
            return subjectDao.selectById(subject.getId());
        } catch (Exception e) {
            throw new BookException(e, "保存客户发生错误{}:{}", subject, e.getMessage());
        }

    }

    /**
     * 检查科目是否存在
     *
     * @param subject 科目
     * @return true - 存在
     * @throws BookException there's something wrong.
     */
    private boolean exists(Subject subject) throws BookException {
        try {
            return subjectDao.selectBySubjectNumberAndBookId(subject.getSubjectNumber(), subject.getBookId()) != null;
        } catch (Exception e) {
            throw new BookException(e, "查询科目({})时出现错误:{}", subject, e.getMessage());
        }
    }

    /**
     * 判断科目是否有父科目
     *
     * @param subject 科目
     * @return true - 存在
     */
    private boolean existsParentSubject(Subject subject) throws BookException {
        if (SubjectNumber.EMPTY_SUBJECT_NUMBER.equals(subject.getPid())) {
            return true;
        }
        try {
            return subjectDao.selectBySubjectNumberAndBookId(subject.getSubjectNumber(), subject.getBookId()) != null;
        } catch (Exception e) {
            throw new BookException(e, "查询科目({})的父级科目时发生错误:{}", e);
        }
    }

    private void updateParentSubject(Subject subject) throws BookException {
        if (SubjectNumber.EMPTY_SUBJECT_NUMBER.equals(subject.getSubjectNumber())) {
            subject.setPath(SubjectPath.ROOT);
            return;
        }
        try {
            Subject parentSubject = subjectDao.selectBySubjectNumberAndBookId(subject.getPid(), subject.getBookId());
            parentSubject.setDirectory(true);
            subject.setPath(new SubjectPath(parentSubject.getPath().getDirectoryPath() + subject.getName()));
            subjectDao.updateById(parentSubject);
        } catch (Exception e) {
            throw new BookException(e, "更新父级科目时出现错误:{}", e.getMessage());
        }
    }

    /**
     * 获取科目
     *
     * @param id ID
     * @return 科目
     */
    @Override
    public Subject get(long id) {
        return null;
    }

    /**
     * 获取科目
     *
     * @param bookId        账本id
     * @param subjectNumber 科目号
     * @return 科目
     */
    @Override
    public Subject get(long bookId, SubjectNumber subjectNumber) throws BookException {
        try {
            return Optional.of(subjectDao.selectBySubjectNumberAndBookId(subjectNumber, bookId)).get();
        } catch (DataAccessException e) {
            throw new BookException(e, "查询科目(bookId={}, subjectNumber={})时发生数据库错误:{}", bookId, subjectNumber,
                e.getMessage());
        } catch (NullPointerException e) {
            throw new BookException(e, "未找到科目号为{}，账本id为{}的科目:{}", subjectNumber, bookId, e.getMessage());
        }
    }

    /**
     * 获取科目
     *
     * @param parentSubject 父科目
     * @param pageNum       页码
     * @param pageSize      页尺寸
     * @return 科目
     */
    @Override
    public IPage<Subject> get(Subject parentSubject, int pageNum, int pageSize) {
        return null;
    }
}
