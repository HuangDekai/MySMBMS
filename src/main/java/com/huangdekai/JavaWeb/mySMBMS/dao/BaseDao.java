package com.huangdekai.JavaWeb.mySMBMS.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/14 23:18
 * @Version: 1.0
 * @since: jdk11
 */
// 操作数据库的公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static{
        InputStream resourceAsStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        assert resourceAsStream != null;
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    // 获取数据库的连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }

    // 编写查询公共方法
    public static ResultSet executeQuery(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql, Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }

        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    // 编写增删改公共方法
    public static int executeUpdate(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }

        int updateRows = preparedStatement.executeUpdate();

        return updateRows;
    }

    // 关闭连接
    public static boolean closeResource(Connection connection, Statement statement, ResultSet resultSet){
        boolean flag = true;

        if (resultSet != null){
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }

        return flag;
    }
}
