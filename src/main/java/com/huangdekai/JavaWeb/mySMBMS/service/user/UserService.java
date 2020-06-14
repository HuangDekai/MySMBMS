package com.huangdekai.JavaWeb.mySMBMS.service.user;

import com.huangdekai.JavaWeb.mySMBMS.pojo.User;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/16 1:11
 * @Version: 1.0
 * @since: jdk11
 */
public interface UserService {
    // 登陆
    public User login(String userCode, String userPassword);

    // 修改密码
    public boolean updateUserPassword(int id, String userPassword);
}
