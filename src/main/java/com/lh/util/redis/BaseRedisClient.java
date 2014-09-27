package com.lh.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * Created by tju on 9/16/14.
 */

enum RedisActionEnum {
    SET_VALUE,
    SET_VALUE_WITH_TIMEOUT,
    APPEND_VALUE,
    SET_VALUE_EXPIRED,
    M_GET,
    DEL_VALUE_WITH_MULTI_KEYS,
    GET_VALUE_BY_KEY,
    GET_KEY_WITH_PATTEN,
    GET_KEYS_WITH_PATTEN,
    DEL_KEYS,
    R_PUSH,
    L_POP,
    S_ADD,
    S_DEL,
    S_IS_MEMBER,
    S_MEMBERS
}

public abstract class BaseRedisClient {

    private static Logger _logger = LoggerFactory.getLogger(IRedisClient.class);

    public abstract int getDB();
    private JedisPool clientPool = null;

    public BaseRedisClient(String server, short port) {

        if(clientPool == null)
        {
            _logger.debug("ready to connect to redis server {} on {}", server, port);
            try {
                JedisPoolConfig config = new JedisPoolConfig();
                _logger.debug("redis max active connections:{}", config.getMaxActive());
                clientPool = new JedisPool(config, server, port);
                _logger.debug("connected");
            } catch (Exception e) {
                _logger.error("exception raised with message: {}", e.getMessage());
            }
        }
        else
        {
            _logger.debug("reinit detected!");
        }

    }

    private Jedis getRedisClient() {
        Jedis client;
        client = clientPool.getResource();
        client.select(this.getDB());

        if (client==null) {
            _logger.error("redis client is null.");
        }

        return client;
    }

    private void returnResource(Jedis client) {
        if (client != null) {
            clientPool.returnResource(client);
            _logger.debug("return resource to pool." );
        } else {
            _logger.error("redis client is null...");
        }
    }

    private int getIntValueFromParamters(int index, String...params) {
        int result = 0;
        if (params == null) {
            _logger.error("parameters is empty.");
        } else {
            result = Integer.valueOf(params[index]).intValue();
        }
        return result;
    }

    private String getStringValueFromParameters(int index, String...params) {
        return params[index];
    }

    protected  Object execute(RedisActionEnum action, String key, String value, String...params) {
        Object result = null;
        Jedis client = null;
        try {
            client = this.getRedisClient();
            //_logger.debug("action: {}, set {} value {}", action, key, value);

            if (client == null) {
                return null;
            }

            switch (action) {
                case SET_VALUE: {
                    client.set(key, value);
                    break;
                }

                case SET_VALUE_WITH_TIMEOUT: {
                    int seconds = this.getIntValueFromParamters(0, params);
                    client.setex(key, seconds, value);
                    break;
                }

                case APPEND_VALUE:
                    client.append(key, value);
                    break;

                case SET_VALUE_EXPIRED: {
                    int seconds = this.getIntValueFromParamters(0, params);
                    client.expire(key, seconds);
                    break;
                }

                case M_GET: {
                    result = client.mget(params);
                    break;
                }

                case DEL_VALUE_WITH_MULTI_KEYS: {
                    client.del(params);
                    break;
                }

                case GET_VALUE_BY_KEY: {
                    result = client.get(key);
                    break;
                }

                case GET_KEY_WITH_PATTEN: {
                    String patten = this.getStringValueFromParameters(0, params);
                    result = client.keys(patten);
                    break;
                }

                case GET_KEYS_WITH_PATTEN: {
                    String patten = this.getStringValueFromParameters(0, params);
                    result = client.keys(patten);
                    break;
                }

                case DEL_KEYS: {
                    String patten = this.getStringValueFromParameters(0, params);
                    Set<String> keys = client.keys(patten);
                    if (null != value) {
                        for (String k: keys) {
                            client.del(k);
                        }
                    }
                    break;
                }

                case R_PUSH:{
                    client.rpush(key, value);
                    break;
                }

                case L_POP: {
                    result = client.lpop(key);
                    break;
                }

                case S_ADD: {
                    String member = this.getStringValueFromParameters(0, params);
                    client.sadd(key, member);
                    break;
                }

                //Remove the specified member from the set value stored at key.
                case S_DEL: {
                    String member = this.getStringValueFromParameters(0, params);
                    client.srem(key, member);
                    break;
                }

                case S_IS_MEMBER: {
                    String member = this.getStringValueFromParameters(0, params);
                    result = client.sismember(key, member);
                    break;
                }

                case S_MEMBERS: {
                    result = client.smembers(key);
                    break;
                }

                default:
                    _logger.debug("no action.");
            }
        }
        catch(Exception e){
            _logger.error("exception raised: {}", e.getMessage());
        }
        finally {
            this.returnResource(client);
        }

        return result;
    }
}
