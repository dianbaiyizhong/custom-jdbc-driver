package com.nntk;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class JqStatement implements Statement {

    JqStatement() {
        log.info("=================JqStatement");
    }

    private boolean isComplete = false;

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {

        log.info("sql:{}", sql);

        String tableName = "t1";
        List<String> cols = Lists.newArrayList("l1", "l2");

        JqResultSet jqResultSet = new JqResultSet(null, cols, tableName);

        isComplete = true;
        return jqResultSet;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        return 0;
    }

    @Override
    public void close() throws SQLException {

        log.info("========jqStatement close");
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
        log.info("=============getMaxRows");
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
        log.info("============jqStatement sql:{}", sql);
        return false;
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        log.info("============================:getResultSet");
        List<String> cols = Lists.newArrayList("l1", "l2");
        JqResultSet resultSet = new JqResultSet(null, cols, null);
        return resultSet;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        // https://youtrack.jetbrains.com/issue/DBE-18495/Query-wont-finish-running-in-DuckDB-with-0.8.1-driver-version
        // 包含更新计数的 int 值。 如果返回的结果是一个结果集对象或没有更多结果，则返回 -1。
        log.info("=====================getUpdateCount");
        if (isClosed()) {
            throw new SQLException("Statement was closed");
        }
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
        log.info("===========getFetchDirection");
        return ResultSet.FETCH_FORWARD;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {

        log.info("=============setFetchSize:{}", rows);
    }

    @Override
    public int getFetchSize() throws SQLException {
        log.info("===========getFetchSize");

        return 10;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        log.info("===========getResultSetConcurrency");

        return 0;
    }

    @Override
    public int getResultSetType() throws SQLException {
        log.info("============getResultSetType");
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
        log.info("=========getConnection");

        return null;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        log.info("=========getMoreResults current:{}", current);

        return false;
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        log.info("=========getGeneratedKeys");
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
        log.info("=========getResultSetHoldability");

        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException {
        log.info("jqStatement:{}", isComplete);
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
        log.info("==================isCloseOnCompletion");
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