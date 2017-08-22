package com.gunn.common.shiro.realm;

import com.gunn.model.sys.entity.User;
import com.gunn.model.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class simpleRealm  extends AuthorizingRealm{

    @Autowired
    private UserService userService;


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = token.getUsername();
        String password = String.valueOf(token.getPassword());

        User user = userService.login(account, password);

        if (user == null) {
            throw new AccountException("账号或密码不正确！");
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
