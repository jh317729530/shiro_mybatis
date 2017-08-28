package com.gunn.common.session.filter;


import com.gunn.common.session.SecurityServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Gunn on 2017/8/25.
 */
public class RequestFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		System.out.println("-------------调用requestFilter过滤器--------------------");

		HttpServletRequest request = (HttpServletRequest) servletRequest;

		request = new SecurityServletRequestWrapper(request, request.getSession());

		filterChain.doFilter(request,servletResponse);
	}

	public void destroy() {

	}
}
