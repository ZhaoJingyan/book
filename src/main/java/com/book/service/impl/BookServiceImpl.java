package com.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.common.BookException;
import com.book.common.OptionalUtils;
import com.book.dao.BookDao;
import com.book.entity.Book;
import com.book.service.AbstractService;
import com.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhao Jinyan
 * @date 2019/4/3 19:36
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookDao dao;

    private final AbstractService abstractService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public BookServiceImpl(BookDao dao, AbstractService abstractService) {
        this.dao = dao;
        this.abstractService = abstractService;
    }

    /**
     * 保存实体
     *
     * @param book 账本
     * @return 账本
     * @throws BookException there's something wrong
     */
    @Transactional(rollbackFor = BookException.class)
    @Override
    public Book save(Book book) throws BookException {
        try {
            if (book.getId() == null) {
                if (OptionalUtils.isNotBlank(book.getAbstractContent())) {
                    book.setAbstractId(abstractService.save(book.getAbstractContent().trim()));
                }
                dao.insert(book);
            } else {
                if (OptionalUtils.isNotBlank(book.getAbstractContent())) {
                    book.setAbstractId(abstractService.save(book.getAbstractId(), book.getAbstractContent()));
                }
                dao.updateById(book);
            }
            return dao.selectById(book.getId());
        } catch (Exception e) {
            throw new BookException(e, "保存账本时发生错误：{}", e.getMessage());
        }
    }

    /**
     * 主键查询
     *
     * @param id 主键
     * @return 账本
     * @throws BookException there's something wrong.
     */
    @Override
    public Book get(int id) throws BookException {
        try {
            Book book = dao.selectById(id);
            if (book == null) {
                throw new BookException("未找到id为{}的实体.");
            }
            return book;
        } catch (DataAccessException e) {
            throw new BookException(e, "查询id为{}的实体时发生数据库错误:{}", id, e.getMessage());
        }
    }

    /**
     * 组合查询
     *
     * @param name     名称
     * @param pageNum  页码
     * @param pageSize 页尺寸
     * @return 分页
     * @throws BookException there's something wrong
     */
    @Override
    public IPage<Book> get(String name, int pageNum, int pageSize) throws BookException {
        try {
            Page<Book> page = new Page<>(pageNum, pageSize);
            Wrapper<Book> wrapper = new QueryWrapper<Book>().lambda()
                .apply(OptionalUtils.isNotBlank(name), "name like {0}", name);
            return dao.selectPage(page, wrapper);
        } catch (Exception e) {
            throw new BookException(e, "查询账本失败:{}", e.getMessage());
        }
    }
}
