package com.gunn.common.shiro.session;

import com.gunn.common.jedis.JedisManager;
import com.gunn.common.utils.SerializeUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by Gunn on 2017/8/25.
 */
public class RedisSessionDAO extends CachingSessionDAO {

	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

	private static final int DB_INDEX = 0; //  redis 0数据库用于存储session

	private static final int EXPIRE_TIME = 1800; // redis 中session 过期时间

	private JedisManager jedisManager;

	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}

	protected void doUpdate(Session session) {

	}

	protected void doDelete(Session session) {

	}

	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		try {
			jedisManager.saveValueByKey(DB_INDEX, SerializeUtil.serialize(sessionId), SerializeUtil.serialize(session),EXPIRE_TIME);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return sessionId;
	}

	protected Session doReadSession(Serializable serializable) {
		return null;
	}
}
