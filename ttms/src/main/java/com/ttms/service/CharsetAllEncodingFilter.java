package com.ttms.service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hjh on 16-11-1.
 */

public class CharsetAllEncodingFilter implements Filter {

    private String encoding = null;

    public void init(FilterConfig filterConfig) throws ServletException {

        encoding = filterConfig.getInitParameter("encoding");

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpreq = (HttpServletRequest)servletRequest;
        if(httpreq.getMethod().equalsIgnoreCase("post")){
            servletRequest.setCharacterEncoding(encoding);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
