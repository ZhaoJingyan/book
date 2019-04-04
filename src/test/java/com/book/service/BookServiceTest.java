package com.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.book.BaseTest;
import com.book.common.BookException;
import com.book.common.DateUtils;
import com.book.entity.Book;
import com.book.entity.type.AccountDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Zhao Jinyan
 * @date 2019/4/3 19:59
 */
@Slf4j
public class BookServiceTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testSave() {
        Book book = new Book().setName("test");
    }

    @Test
    public void testGet() throws ParseException, BookException {
        Date date = DateUtils.SIMPLE_DATE_FORMAT.parse("20190101");
        for (int i = 0, j = 100; i < j; i++) {
            Book book = new Book().setName("Test" + i).setAccountDate(AccountDate.of(date))
                .setClosingAccountDate(AccountDate.of(new Date())).setAbstractContent("test-content-" + i);
            bookService.save(book);
            date = DateUtils.getYesterday(date);
        }
        IPage<Book> books = bookService.get("Test%", 1, 15);
        books.getRecords().forEach(book -> log.info("boo:{}", book));
    }

}