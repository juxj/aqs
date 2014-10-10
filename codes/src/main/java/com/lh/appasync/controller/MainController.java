package com.lh.appasync.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tju on 9/16/14.
 */

@Controller
@RequestMapping(value = "/main")
public class MainController {


    private static Logger _logger = LoggerFactory.getLogger(MainController.class);
    @RequestMapping (value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String test(HttpServletRequest request) throws Exception {

        String a = request.getParameter("a");
        String b = request.getParameter("b");

        _logger.debug("a = {}", a);
        _logger.debug("b = {}", b);

        Integer a1 = Integer.valueOf(a);
        Integer b1 = Integer.valueOf(b);

        _logger.debug("a1 = {}", a1);
        _logger.debug("b1 = {}", b1);

        return "test";
    }

}
