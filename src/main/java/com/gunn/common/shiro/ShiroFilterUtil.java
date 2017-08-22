package com.gunn.common.shiro;

import net.sf.json.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Map;

public class ShiroFilterUtil {

    /**
     * 判断是否ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    public static void out(ServletResponse response, Map<String, String> resultMap) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.println(JSONObject.fromObject(resultMap).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}
