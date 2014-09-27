package com.lh.appasync.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lh.appasync.async.Consumer;
import com.lh.appasync.service.ICompositionService;
import com.lh.util.StringUtils;

/**
 * Created by tju on 9/16/14.
 */

@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private Consumer commentConsumer;

    @Autowired
    private ICompositionService commentService;

    public void setCommentConsumer(Consumer commentConsumer) {
        this.commentConsumer = commentConsumer;
    }

    public void setCommentService(ICompositionService commentService) {
        this.commentService = commentService;
    }
    
}
