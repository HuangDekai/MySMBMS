package com.huangdekai.JavaWeb.mySMBMS.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/16 0:19
 * @Version: 1.0
 * @since: jdk11
 */
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
