package com.gunn.common.session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.io.Serializable;
import java.util.Enumeration;

/**
 * 实现新的httpsession 可序列化
 * Created by Gunn on 2017/8/25.
 */
public class RedisSession implements HttpSession,Serializable{

	private transient HttpSession httpSession;

	private String sessionId;

	public RedisSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}

	public long getCreationTime() {
		return httpSession.getCreationTime();
	}

	public String getId() {
		return httpSession.getId();
	}

	public long getLastAccessedTime() {
		return httpSession.getLastAccessedTime();
	}

	public ServletContext getServletContext() {
		return httpSession.getServletContext();
	}

	public void setMaxInactiveInterval(int i) {
		httpSession.setMaxInactiveInterval(i);
	}

	public int getMaxInactiveInterval() {
		return httpSession.getMaxInactiveInterval();
	}

	public HttpSessionContext getSessionContext() {
		return httpSession.getSessionContext();
	}

	public Object getAttribute(String s) {
		return httpSession.getAttribute(s);
	}

	public Object getValue(String s) {
		return httpSession.getValue(s);
	}

	public Enumeration getAttributeNames() {
		return httpSession.getAttributeNames();
	}

	public String[] getValueNames() {
		return httpSession.getValueNames();
	}

	public void setAttribute(String s, Object o) {
		httpSession.setAttribute(s,o);
	}

	public void putValue(String s, Object o) {
		httpSession.putValue(s,o);
	}

	public void removeAttribute(String s) {
		httpSession.removeAttribute(s);
	}

	public void removeValue(String s) {
		httpSession.removeValue(s);
	}

	public void invalidate() {
		httpSession.invalidate();
	}

	public boolean isNew() {
		return httpSession.isNew();
	}
}
