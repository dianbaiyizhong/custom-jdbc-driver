package com.nntk.jdbc.driver;

import com.google.common.collect.Lists;
import com.jayway.jsonpath.JsonPath;
import com.nntk.jdbc.driver.adapter.HttpAdapterImpl;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.List;
import java.util.Map;

@Log4j2
public class HttpStatement implements Statement {

    HttpStatement() {
        log.info("HttpStatement new instance");
    }


    @Override
    public ResultSet executeQuery(String sql) throws SQLFeatureNotSupportedException {
        log.info("executeQuery:{}", sql);
        HttpAdapterImpl httpAdapter = new HttpAdapterImpl();
        List<Map<String, String>> resultList = httpAdapter.sendHttp(sql);
        HttpResultSet httpResultSet = new HttpResultSet(resultList);
        return httpResultSet;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        log.info("d-d-sd-");
        throw new SQLFeatureNotSupportedException("不支持非select语句");
    }

    @Override
    public void close() throws SQLException {
        log.info("========statement close");
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return 0;
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {

    }

    @Override
    public int getMaxRows() throws SQLException {
        throw new SQLFeatureNotSupportedException();

    }

    @Override
    public void setMaxRows(int max) throws SQLException {

    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {

    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return 0;
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {

    }

    @Override
    public void cancel() throws SQLException {
        log.info("===============statement cancel");
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public void setCursorName(String name) throws SQLException {

    }

    @Override
    public boolean execute(String sql) throws SQLException {
        throw new SQLFeatureNotSupportedException("不支持非select语句");
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return null;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        // https://youtrack.jetbrains.com/issue/DBE-18495/Query-wont-finish-running-in-DuckDB-with-0.8.1-driver-version
        // 包含更新计数的 int 值。 如果返回的结果是一个结果集对象或没有更多结果，则返回 -1。
        return -1;
    }

    @Override
    public boolean getMoreResults() throws SQLException {

        return false;
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {

    }

    @Override
    public int getFetchDirection() throws SQLException {
        return ResultSet.FETCH_FORWARD;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
    }

    @Override
    public int getFetchSize() throws SQLException {

        return 0;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return 0;
    }

    @Override
    public int getResultSetType() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void addBatch(String sql) throws SQLException {

    }

    @Override
    public void clearBatch() throws SQLException {

    }

    @Override
    public int[] executeBatch() throws SQLException {
        return new int[0];
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {

        return false;
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return null;
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        return 0;
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {

        return 0;
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {

        return 0;
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {

        return false;
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {

        return false;
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {

        return false;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {

        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return true;
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {

    }

    @Override
    public boolean isPoolable() throws SQLException {
        return false;
    }

    @Override
    public void closeOnCompletion() throws SQLException {

    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return true;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
