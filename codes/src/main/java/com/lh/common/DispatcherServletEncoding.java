package com.lh.common;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tju on 7/22/14.
 */
public class DispatcherServletEncoding extends DispatcherServlet {

    private String encoding;

    public void init(ServletConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        super.init(config);
    }

    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding(encoding);
        super.doService(request, response);
    }
}
