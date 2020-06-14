package com.huangdekai.JavaWeb.mySMBMS.dao.User;

import com.huangdekai.JavaWeb.mySMBMS.dao.BaseDao;
import com.huangdekai.JavaWeb.mySMBMS.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/16 0:35
 * @Version: 1.0
 * @since: jdk11
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            String sql = "Select * from smbms_user where userCode = ?";
            Object[] paramters = {userCode};
            resultSet = BaseDao.executeQuery(connection, preparedStatement, resultSet, sql, paramters);

            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setCreationDate(resultSet.getDate("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getDate("modifyDate"));
            }
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }

        return user;
    }

    @Override
    public int updatePassword(Connection connection, int id, String userPassword) throws SQLException {
        PreparedStatement preparedStatement = null;
        int execute = 0;

        if (connection != null){
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object[] parameters = {userPassword,id};

            preparedStatement = connection.prepareStatement(sql);
            execute = BaseDao.executeUpdate(connection, preparedStatement, sql, parameters);

            BaseDao.closeResource(null,preparedStatement,null);
        }

        return execute;
    }
}
