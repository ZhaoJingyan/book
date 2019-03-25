package com.book.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface TestDao {

    @Update("alter table ${tableName} auto_increment= 1;")
    int resetAutoIncrement(@Param("tableName") String tableName);

}
