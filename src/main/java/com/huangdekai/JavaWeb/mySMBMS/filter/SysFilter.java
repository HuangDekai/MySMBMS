package com.huangdekai.JavaWeb.mySMBMS.filter;

import com.huangdekai.JavaWeb.mySMBMS.Util.Constants;
import com.huangdekai.JavaWeb.mySMBMS.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/17 0:25
 * @Version: 1.0
 * @since: jdk11
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        User attribute = (User) httpServletRequest.getSession().getAttribute(Constants.USER_SESSION);

        if (attribute == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/error.jsp");
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
