package com.gunn.model.sys.controller;

import com.gunn.model.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserLoginController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "loginSuccess",method = RequestMethod.GET)
    public ModelAndView loginSuccess(){
        return new ModelAndView("loginSuccess");
    }

    @RequestMapping(value="submitLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> submitLogin(User user, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
            SecurityUtils.getSubject().login(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");
        } catch (DisabledAccountException e) {
            resultMap.put("status", 500);
            resultMap.put("message", "账号已经被禁用");
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "账号或密码错误");
        }

        return resultMap;
    }

    @RequestMapping("loginFailure")
    public ModelAndView loginFailue(){
        return new ModelAndView("loginFailure");
    }
}
