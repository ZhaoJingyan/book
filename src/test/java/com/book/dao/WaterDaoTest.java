package com.book.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.book.BaseTest;
import com.book.common.DateUtils;
import com.book.entity.Water;
import com.book.entity.type.AccountDate;
import com.book.entity.type.SubjectNumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
            .setSubjectNumber(SubjectNumber.of("1001")).setTransDate(AccountDate.of("00000000"));
        dao.insert(water);
        water = dao.selectById(water.getId());
        log.info("测试流水:{}", water);
        assertEquals(water.getSubjectNumber(), SubjectNumber.of("1001"));
        assertEquals(water.getBookId(), 1L);
        assertEquals(water.getLogId(), 1L);
    }

    @Test
    public void testSelectByTransDate() throws ParseException {
        Date testDate = DateUtils.SIMPLE_DATE_FORMAT.parse("20181231");
        for(int i = 0,j = 15; i < j; i++){
            testDate = DateUtils.getYesterday(testDate);
            Water water = new Water().setBookId(1).setLogId(i * 2).setMoney(new BigDecimal(1000 * i - 8 * i))
                .setSubjectNumber(SubjectNumber.of("1001")).setTransDate(AccountDate.of(testDate));
            dao.insert(water);
        }
        List<Water> waters = dao.selectByTransDate(AccountDate.of("20190101"),
            AccountDate.of("20190110"));
        log.info("取得的waters:{}", waters);
        assertEquals(waters.size(), 10L);
        waters.stream().limit(1).forEach(water -> assertEquals(Long.parseLong(water.getTransDate().getDay()), 1));
    }

}