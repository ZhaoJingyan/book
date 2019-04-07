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

    @Test
    public void testGetDirectoryPath(){
        SubjectPath path = new SubjectPath("/测试/测试2/测试科目");
        assertEquals(path.getDirectoryPath(),"/测试/测试2/");
        assertEquals(SubjectPath.ROOT.getDirectoryPath(), SubjectPath.ROOT_PATH);
    }

    @Test
    public void testGetName(){
        SubjectPath path = new SubjectPath("/测试/测试2/测试科目");
        assertEquals(path.getName(),"测试科目");
        assertEquals(SubjectPath.ROOT.getName(), SubjectPath.ROOT_PATH);
    }

}