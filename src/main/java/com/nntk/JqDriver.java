package com.nntk;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

@Slf4j
public class JqDriver implements Driver {
    private static boolean registered;
    private static final JqDriver INSTANCE = new JqDriver();

    static {
        load();
    }

    private static JqDriver load() {
        try {
            if (!registered) {
                registered = true;
                DriverManager.registerDriver(INSTANCE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }


    @Override
    public Connection connect(String url, Properties info) throws SQLException {

        return new JqConnection();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        log.info("my acceptsURL:{}", url);
        return true;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        log.info("==getPropertyInfo:{}", info);
        return new DriverPropertyInfo[0];
    }


    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }
}
