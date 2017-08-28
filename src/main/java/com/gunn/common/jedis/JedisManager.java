package com.gunn.common.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * 管理jedis，所有获取jedis操作redis都经过此类进行分配
 * 封装reids crud
 * Created by Gunn on 2017/8/25.
 */
public class JedisManager {

	private static Logger logger = LoggerFactory.getLogger(JedisManager.class);

	private JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public Jedis getJedis() {
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
		} catch (JedisConnectionException e) {
			logger.error("Jedis Connection Exception!");
		}
		return jedis;
	}

	/**
	 * 通过键找值
	 *
	 * @param dbIndex
	 * @param key
	 * @return
	 */
	public byte[] getValueByKey(int dbIndex, byte[] key) throws Exception {
		Jedis jedis = null;
		byte[] result = null;
		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			result = jedis.get(key);
		} catch (Exception e) {
			throw e;
		}finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		return result;
	}

	public void saveValueByKey(int dbIndex,byte[] key,byte[] value,int expireTime)throws Exception {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.set(key, value);
			if (expireTime > 0) {
				jedis.expire(key, expireTime); //设置过期时间
			}
		} catch (Exception e) {
			throw e;
		}finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

	public void deleteValueByKey(int dbIndex,byte[] key) throws Exception {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.del(key);
		} catch (Exception e) {
			throw e;
		}finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}
}
