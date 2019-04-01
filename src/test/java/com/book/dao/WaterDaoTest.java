package com.book.dao;

import com.book.BaseTest;
import com.book.entity.Water;
import com.book.entity.type.SubjectNumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Zhao Jinyan
 * @date 2019/4/1 19:54
 */
@Slf4j
public class WaterDaoTest extends BaseTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private WaterDao dao;

    @Test
    public void testInsert() {
        Water water = new Water().setBookId(1).setLogId(1).setMoney(new BigDecimal(1000.11))
            .setSubjectNumber(SubjectNumber.of("1001"));
        dao.insert(water);
        water = dao.selectById(water.getId());
        log.info("测试流水:{}", water);
        assertEquals(water.getSubjectNumber(), SubjectNumber.of("1001"));
        assertEquals(water.getBookId(), 1L);
        assertEquals(water.getLogId(), 1L);
    }

}