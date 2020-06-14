package com.huangdekai.JavaWeb.mySMBMS.dao.User;

import com.huangdekai.JavaWeb.mySMBMS.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/16 0:31
 * @Version: 1.0
 * @since: jdk11
 */
public interface UserDao {
    // 获取要登陆的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;

    // 修改密码
    public int updatePassword(Connection connection, int id, String userPassword) throws SQLException;
}
