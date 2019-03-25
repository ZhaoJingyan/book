package com.book.entity.handler;

import com.book.entity.type.AccountDate;
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
 * @date 2019-03-23
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(AccountDate.class)
public class AccountDateHandler implements TypeHandler<AccountDate> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, AccountDate accountDate, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, accountDate.toString());
    }

    @Override
    public AccountDate getResult(ResultSet resultSet, String s) throws SQLException {
        return new AccountDate(resultSet.getString(s));
    }

    @Override
    public AccountDate getResult(ResultSet resultSet, int i) throws SQLException {
        return new AccountDate(resultSet.getString(i));
    }

    @Override
    public AccountDate getResult(CallableStatement callableStatement, int i) throws SQLException {
        return new AccountDate(callableStatement.getString(i));
    }
}
