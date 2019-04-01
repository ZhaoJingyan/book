package com.book.entity.type;

import com.book.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhao Jinyan
 * @date 2019/4/1 14:10
 */
public class SubjectPathTest extends BaseTest {

    @Test
    public void testToString() {
        SubjectPath path = new SubjectPath("/测试/测试科目");
        assertEquals(path.toString(), "/测试/测试科目");
    }

}