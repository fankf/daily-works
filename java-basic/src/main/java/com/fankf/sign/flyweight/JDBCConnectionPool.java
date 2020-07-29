package com.fankf.sign.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author fankunfeng
 * @datetime 2020-07-23 17:15
 * @package com.fankf.sign.flyweight
 */
public class JDBCConnectionPool {

    private Vector<Connection> pool;

    public static final String url = "jdbc:mysql://localhost:3306/test";
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String username = "root";
    public static final String password = "root";

    public static final int poolSizeMin = 2;
    private Connection connection;

    public JDBCConnectionPool() throws ClassNotFoundException {
        pool = new Vector<>(poolSizeMin);
        Class.forName(driver);
        for (int i = 0; i < poolSizeMin; i++) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void back() {
        pool.add(connection);
    }

    public Connection get() {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        } else {
            return null;
        }
    }
}
