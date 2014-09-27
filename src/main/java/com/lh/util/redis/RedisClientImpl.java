package com.lh.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by tju on 9/16/14.
 */
public class RedisClientImpl extends BaseRedisClient implements IRedisClient {

    //redis db;
    private int _db;
    //logger.
    private static Logger _logger = LoggerFactory.getLogger(RedisClientImpl.class);

    public RedisClientImpl(String server, short port, int db) {
        super(server, port);
        this._db = db;
        _logger.debug("initialize redis client for db: {}", this._db);
    }

    @Override
    public void set(String key, String value) {
        this.execute(RedisActionEnum.SET_VALUE, key, value, null);
    }

    @Override
    public void setTimeout(String key, String value, int seconds) {
        this.execute(RedisActionEnum.SET_VALUE_WITH_TIMEOUT, key, value, String.valueOf(seconds));
    }

    @Override
    public void append(String key, String value) {
        this.execute(RedisActionEnum.APPEND_VALUE, key, value);
    }

    @Override
    public void setExpired(String key, int seconds) {
        this.execute(RedisActionEnum.SET_VALUE_EXPIRED, key, null, String.valueOf(seconds));
    }

    @Override
    public List<String> mget(String... keys) {
        List<String> result = null;
        Object obj = execute(RedisActionEnum.M_GET, null, null, keys);
        if (obj != null) {
            result = (List<String>) obj;
        }
        return result;
    }

    @Override
    public void del(String... keys) {
        this.execute(RedisActionEnum.DEL_KEYS, null, null, keys);
    }

    @Override
    public String get(String key) {
        String result = null;
        Object obj = this.execute(RedisActionEnum.GET_VALUE_BY_KEY, key, null, null);

        if (obj != null) {
            result = (String) obj;
        }
        return result;
    }

    @Override
    public String getKey(String pattern) {

        String result = null;
        Object obj = this.execute(RedisActionEnum.GET_KEY_WITH_PATTEN, null, null, pattern);
        if (obj != null) {
            Set<String> value = (Set<String>) obj;
            for (String s: value) {
                result =  s;
            }
        }
        return result;
    }

    @Override
    public String[] getKeys(String pattern) {
        String[] result = null;
        Set<String> value = null;
        Object obj = this.execute(RedisActionEnum.GET_KEYS_WITH_PATTEN, null, null, pattern);
        if (obj != null) {
            value = (Set<String>) obj;
        }

        if (null != value && value.size() > 0) {
            result = new String[value.size()];
            result = value.toArray(result);
        }
        return result;
    }

    @Override
    public void delKeys(String pattern) {
        this.execute(RedisActionEnum.DEL_KEYS, null, null, pattern);
    }

    @Override
    public void rpush(String key, String value) {
        this.execute(RedisActionEnum.R_PUSH, key, value);
    }

    @Override
    public String lpop(String key) {
        String result = null;
        Object obj = this.execute(RedisActionEnum.L_POP, key, null, null);
        if (obj != null) {
            result= (String) obj;
        }
        return result;
    }

    @Override
    public void sSet(String key, String member) {
        this.execute(RedisActionEnum.S_ADD, key, null, member);
    }

    @Override
    public void sDel(String key, String member) {
        this.execute(RedisActionEnum.S_DEL, key, null, member);
    }

    @Override
    public Boolean sIsMember(String key, String member) {
        Boolean result = false;
        Object obj = this.execute(RedisActionEnum.S_IS_MEMBER, key, null, member);
        if (obj != null) {
            result = (Boolean) obj;
        }
        return result;
    }

    @Override
    public String[] sMembers(String key) {
        String[] result = null;
        Set<String> value = null;
        Object obj = this.execute(RedisActionEnum.S_MEMBERS, key, null, null);
        if (obj != null) {
            value = (Set<String>) obj;
        }
        if (null != value && value.size() > 0) {
            result = new String[value.size()];
            result = value.toArray(result);
        }
        return result;
    }

    @Override
    public int getDB() {
        return this._db;
    }

}
