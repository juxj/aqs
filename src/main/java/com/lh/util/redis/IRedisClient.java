package com.lh.util.redis;


import java.util.List;

public interface IRedisClient {
	

    void set(String key, String value);
    void setTimeout(String key, String value, int seconds);
    void append(String key, String value);
    void setExpired(String key, int seconds);
    List<String> mget(String...keys);
    void del(String...keys);
    String get(String key);
    String getKey(String pattern);
    String[] getKeys(String pattern);
    void delKeys(String pattern);
    void rpush(String key, String value);
    String lpop(String key);
    void sSet(String key, String member);
    void sDel(String key, String member);
    Boolean sIsMember(String key, String member);
    String[] sMembers(String key);

}