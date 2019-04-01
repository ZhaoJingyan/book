package com.book.dao;

import com.book.BaseTest;
import com.book.entity.Subject;
import com.book.entity.type.SubjectNumber;
import com.book.entity.type.SubjectPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

/**
 * @author Zhao Jinyan
 * @date 2019/4/1 13:27
 */
@Slf4j
public class SubjectDaoTest extends BaseTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SubjectDao dao;

    @Test
    public void testInsert() {
        Subject subject =
            new Subject().setSubjectNumber(SubjectNumber.of("0000")).setName("测试科目").setPath(new SubjectPath("/测试科目"));
        dao.insert(subject);
        subject = dao.selectById(subject.getId());
        log.info("科目:{}", subject);
        assertEquals(subject.getPid(), 0);
        assertFalse(subject.isDirectory());
        assertEquals(subject.getPath().toString(), "/测试科目");

        try {
            dao.insert(new Subject().setSubjectNumber(SubjectNumber.of("0000")).setName("测试科目2").setPath(new SubjectPath(
                "/测试科目")));
            fail("此处必须抛出数据库异常");
        } catch (DataAccessException e) {
            log.info(e.getMessage());
        }
    }

}