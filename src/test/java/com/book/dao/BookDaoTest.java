package com.book.dao;

import com.book.Application;
import com.book.entity.Book;
import com.book.entity.type.AccountDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Unit test for BookDao
 *
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Slf4j
public class BookDaoTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BookDao bookDao;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TestDao testDao;

    @Test
    public void insert() {
        try {
            Book newBook = new Book().setName("test-book").setAccountDate(new AccountDate("20190101"))
                .setClosingAccountDate(new AccountDate("20191231"));
            assertEquals((long) bookDao.insert(newBook), 1L);
            Book oldBook = bookDao.selectById(newBook.getId());
            assertNotNull("插入失败", oldBook);
            assertEquals(newBook.getName(), oldBook.getName());
            assertEquals(newBook.getAccountDate(), oldBook.getAccountDate());
            assertEquals(newBook.getClosingAccountDate(), oldBook.getClosingAccountDate());
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            fail("数据错误!");
        }
    }

    @After
    public void resetAutoIncrement() {
        testDao.resetAutoIncrement("book");
    }

}
