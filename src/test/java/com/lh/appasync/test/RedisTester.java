package com.lh.appasync.test;

import com.lh.util.redis.IRedisClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tju on 9/21/14.
 */
public class RedisTester  {


    @Autowired
    private IRedisClient redisClientComment;

    @Autowired
    private IRedisClient redisClient1;

    public void setRedisClientComment(IRedisClient redisClientComment) {
        this.redisClientComment = redisClientComment;
    }

    public void setRedisClient1(IRedisClient redisClient1) {
        this.redisClient1 = redisClient1;
    }
}
