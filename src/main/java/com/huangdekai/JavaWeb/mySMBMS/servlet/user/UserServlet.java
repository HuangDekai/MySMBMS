package com.huangdekai.JavaWeb.mySMBMS.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.huangdekai.JavaWeb.mySMBMS.Util.Constants;
import com.huangdekai.JavaWeb.mySMBMS.pojo.User;
import com.huangdekai.JavaWeb.mySMBMS.service.user.UserService;
import com.huangdekai.JavaWeb.mySMBMS.service.user.UserServiceImpl;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Autord: HuangDekai
 * @Date: 2020/6/4 8:04
 * @Version: 1.0
 * @since: jdk11
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");


        if (method != null && method.equals("savepwd")){
            this.updatePassword(req, resp);
        }
        else if (method != null && method.equals("pwdmodify")){
            this.passwordModify(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    // 修改密码
    public boolean updatePassword(HttpServletRequest req, HttpServletResponse resp){
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String newPassword = req.getParameter("newpassword");
        boolean flag = false;

        if (attribute!=null && StringUtils.isNotEmpty(newPassword)){
            UserService userService = new UserServiceImpl();
            User user = (User)attribute;

            flag = userService.updateUserPassword(user.getId(),newPassword);
            if (flag){
                req.setAttribute(Constants.USER_MESSAGE,"修改密码成功，请使用新密码登陆");
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }
            else {
                req.setAttribute(Constants.USER_MESSAGE, "修改密码失败");
            }
        }
        else{
            req.setAttribute(Constants.USER_MESSAGE,"新密码有问题");
        }

        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

        return flag;
    }

    // 验证密码
    public void passwordModify(HttpServletRequest req, HttpServletResponse resp){
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        Map<String,String> result = new HashMap<>();

        // Session失效
        if (attribute == null){
            result.put("result","sessionerror");
        }

        // 输入密码为空
        else if (StringUtils.isEmpty(oldpassword)){
            result.put("result","error");
        }

        //
        else{
            String userPassword = ((User)attribute).getUserPassword();
            if (userPassword.equals(oldpassword)){
                result.put("result","true");
            }
            else{
                result.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");

            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(result));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
