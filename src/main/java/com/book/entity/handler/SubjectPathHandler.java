package com.book.entity.handler;

import com.book.entity.type.SubjectPath;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zhao Jinyan
 * @date 2019-03-30
 */
public class SubjectPathHandler implements TypeHandler<SubjectPath> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SubjectPath subjectPath, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, subjectPath.toString());
    }

    @Override
    public SubjectPath getResult(ResultSet resultSet, String s) throws SQLException {
        return new SubjectPath(resultSet.getString(s));
    }

    @Override
    public SubjectPath getResult(ResultSet resultSet, int i) throws SQLException {
        return new SubjectPath(resultSet.getString(i));
    }

    @Override
    public SubjectPath getResult(CallableStatement callableStatement, int i) throws SQLException {
        return new SubjectPath(callableStatement.getString(i));
    }
}
