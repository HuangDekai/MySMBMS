package com.huangdekai.JavaWeb.mySMBMS.servlet.user;

import com.huangdekai.JavaWeb.mySMBMS.Util.Constants;
import com.huangdekai.JavaWeb.mySMBMS.pojo.User;
import com.huangdekai.JavaWeb.mySMBMS.service.user.UserService;
import com.huangdekai.JavaWeb.mySMBMS.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/16 2:27
 * @Version: 1.0
 * @since: jdk11
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if (user != null && userPassword.equals(user.getUserPassword())) {
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            resp.sendRedirect("jsp/frame.jsp");
        }
        else {
            req.getSession().setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
