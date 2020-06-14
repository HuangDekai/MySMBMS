package com.huangdekai.JavaWeb.mySMBMS.service.user;

import com.huangdekai.JavaWeb.mySMBMS.dao.BaseDao;
import com.huangdekai.JavaWeb.mySMBMS.dao.User.UserDao;
import com.huangdekai.JavaWeb.mySMBMS.dao.User.UserDaoImpl;
import com.huangdekai.JavaWeb.mySMBMS.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/16 2:06
 * @Version: 1.0
 * @since: jdk11
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String userPassword) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection,userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Override
    public boolean updateUserPassword(int id, String userPassword) {
        Connection connection = null;
        int execute = 0;
        boolean flag = false;

        try {
            connection = BaseDao.getConnection();
            execute = userDao.updatePassword(connection,id,userPassword);
            if (execute > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }

        return flag;
    }
}
