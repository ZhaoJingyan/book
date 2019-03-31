package com.book.entity.handler;

import com.book.entity.type.SubjectNumber;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zhao Jinyan
 * @date 2019/3/31 21:38
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(SubjectNumber.class)
public class SubjectNumberHandler implements TypeHandler<SubjectNumber> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SubjectNumber subjectNumber, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, subjectNumber.toString());
    }

    @Override
    public SubjectNumber getResult(ResultSet resultSet, String s) throws SQLException {
        return SubjectNumber.of(resultSet.getString(s));
    }

    @Override
    public SubjectNumber getResult(ResultSet resultSet, int i) throws SQLException {
        return SubjectNumber.of(resultSet.getString(i));
    }

    @Override
    public SubjectNumber getResult(CallableStatement callableStatement, int i) throws SQLException {
        return SubjectNumber.of(callableStatement.getString(i));
    }
}
