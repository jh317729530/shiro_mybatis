package com.gunn.common.shiro.filter;

import com.gunn.common.shiro.ShiroFilterUtil;
import com.gunn.model.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginFilter extends AccessControlFilter {

    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        User token = (User) SecurityUtils.getSubject().getPrincipal();
        if (null != token || isLoginRequest(servletRequest, servletResponse)) {
            return true;
        }

        if (ShiroFilterUtil.isAjax(servletRequest)) {
            Map<String, String> resultMap = new HashMap<String, String>();

            resultMap.put("login_status", "300");
            resultMap.put("message", "\u5F53\u524D\u7528\u6237\u6CA1\u6709\u767B\u5F55\uFF01");
            ShiroFilterUtil.out(servletResponse, resultMap);
        }

        return false;
    }

    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        saveRequestAndRedirectToLogin(servletRequest, servletResponse);
        return false;
    }
}
