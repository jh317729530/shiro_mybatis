package com.gunn.common.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * Created by Gunn on 2017/8/25.
 */
public class SecurityServletRequestWrapper extends HttpServletRequestWrapper {

	private static Logger log = LoggerFactory.getLogger(SecurityServletRequestWrapper.class);

	private HttpSession session;

	public SecurityServletRequestWrapper(HttpServletRequest request,HttpSession session) {
		super(request);

		if (null != session) {
			this.session = session;
		}
	}

	@Override
	public RedisSession getSession() {
		log.debug("getSession is invoked!");

//		return getSession(true);
		return new RedisSession(session);
	}


//	@Override
//	public RedisSession getSession(boolean create) {
//		log.debug("getSession(boolean) is invoked!");
//
////		if (create && null == session) {
////			log.debug("creating new Session Object!");
////
////			 return new RedisSession(session);
////		}
//
//		return session;
//	}
}
