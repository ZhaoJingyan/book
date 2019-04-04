package com.book.dao;

import com.book.BaseTest;
import com.book.entity.AccountingEntry;
import com.book.entity.type.AccountDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Zhao Jinyan
 * @date 2019/4/3 15:26
 */
@Slf4j
public class AccountingEntryDaoTest extends BaseTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private AccountingEntryDao dao;

    @Test
    public void testInsert() {
        AccountingEntry entry =
            new AccountingEntry().setBookId(1).setTransDate(AccountDate.of("20190301")).setAbstractId(1);
        dao.insert(entry);
        entry = dao.selectById(entry.getId());
        log.info("记账数据:{}", entry);
    }

}