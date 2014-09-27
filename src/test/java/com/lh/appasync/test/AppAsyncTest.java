package com.lh.appasync.test;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.lh.appasync.dao.ICompositionDAO;
import com.lh.appasync.model.po.Comment;
import com.lh.appasync.service.ICompositionService;
import com.lh.util.StringUtils;
import com.lh.util.redis.IRedisClient;

/**
 * Created by tju on 9/17/14.
 */
public class AppAsyncTest extends BaseTestCase {


    private static Logger _logger = LoggerFactory.getLogger(AppAsyncTest.class);

    private static Integer i=0;

    @Autowired
    private ICompositionDAO commentDAO;

    @Autowired
    private ICompositionService commentService;

    @Autowired
    private IRedisClient redisClientComment;

    @Autowired
    private IRedisClient redisClient1;

    @Test
    @Ignore
    public void testRedis() throws Exception {
        for (i=0 ; i< 100; i++) {
            redisClient1.set("DB0_"+i.toString(), StringUtils.getUUID());
            redisClientComment.set("DB1_"+i.toString(), StringUtils.getUUID());
        }
    }

    @Test
    @Ignore
    public void testCommentService() throws Exception {
        //commentService.saveComment(this.createComment());
    }

    @Test
    @Transactional("tmMyStyleMaster")
    @Rollback(false)
    @Ignore
    public void testCommentDAO() throws Exception {
        //commentDAO.saveComment(this.createComment());
    }

    @Test
    @Ignore
    @Transactional("tmTestMaster")
    public void testCommentDAOReadFromTest() throws Exception {
//        Comment comment = this.commentDAO.get("24944d0f-2a93-43e1-9409-01761557d6d9");
//        if (comment == null) {
//            _logger.debug("Comment is null in TestMaster...");
//        } else{
//            _logger.debug("Comment is not NULL...");
//        }
    }

    private Comment createComment() {
        Comment comment = new Comment();
        comment.setUid(StringUtils.getUUID());
        comment.setKey(StringUtils.getUUID());
        comment.setContent("Test Content from JUNIT.");
        return comment;
    }

    public void setCommentService(ICompositionService commentService) {
        this.commentService = commentService;
    }

    public void setRedisClientComment(IRedisClient redisClientComment) {
        this.redisClientComment = redisClientComment;
    }

    public void setRedisClient1(IRedisClient redisClient1) {
        this.redisClient1 = redisClient1;
    }
}
