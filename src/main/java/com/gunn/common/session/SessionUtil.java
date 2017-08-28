package com.gunn.common.session;

import com.gunn.common.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Gunn on 2017/8/25.
 */
public class SessionUtil {

	@Autowired
	private static JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public static boolean saveSessionToRedis(RedisSession session) {
		Jedis jedis;
		try {
				jedis = jedisPool.getResource();
				jedis.set(("session" + session.getId()).getBytes(), SerializeUtil.serialize(session));
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
