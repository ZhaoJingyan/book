package com.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.book.common.BookException;
import com.book.entity.Book;

/**
 * @author Zhao Jinyan
 * @date 2019/4/3 19:19
 */
public interface BookService {

    /**
     * 保存实体
     *
     * @param book 账本
     * @return 账本
     * @throws BookException there's something wrong
     */
    Book save(Book book) throws BookException;

    /**
     * 主键查询
     *
     * @param id 主键
     * @return 账本
     * @throws BookException there's something wrong.
     */
    Book get(int id) throws BookException;

    /**
     * 组合查询
     * @param name 名称
     * @param pageNum 页码
     * @param pageSize 页尺寸
     * @return 分页
     * @throws BookException there's something wrong;
     */
    IPage<Book> get(String name,int pageNum, int pageSize) throws BookException;

}
