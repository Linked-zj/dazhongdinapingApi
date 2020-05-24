package com.linked.dazhongdianpingapi.system.interceptor.customInterceptors;


import com.linked.dazhongdianpingapi.system.base.ErrorCode;
import com.linked.dazhongdianpingapi.system.base.SystemConfig;
import com.linked.dazhongdianpingapi.system.exception.ServiceException;
import com.linked.dazhongdianpingapi.system.util.jwt.JWTUtil;
import com.linked.dazhongdianpingapi.system.util.redis.RedisUtil;
import com.linked.dazhongdianpingapi.system.util.threadlocal.ThreadLocalManager;
import com.linked.dazhongdianpingapi.system.util.threadlocal.TokenContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Cookie
 * @Description: web端Token验证
 * @Date: Create in 16:43 2019/1/15
 */
@Component
public class WebTokenCheck {


    @Autowired
    RedisUtil redisUtil;

    /**
     * @Author: Cookie
     * @Date: 2019/1/15 16:44
     * @Description: Token验证
     */
    protected boolean check(HttpServletRequest request) throws Exception {
        //初始化token变量
        String securityToken;
        //获取url中的token
        securityToken = request.getHeader(SystemConfig.WEB_TOKEN);
        //判断token是否合法
        if (!JWTUtil.checkToken(securityToken)) {
            throw new ServiceException(ErrorCode.TOKEN_WITHOUT);
        }

        //根据token获取redis中保存的用户信息
        TokenContext tokenContext = (TokenContext)redisUtil.get(securityToken);
        if (tokenContext == null) {
            //若无查询的信息，则token无效
            throw new ServiceException(ErrorCode.TOKEN_WITHOUT);
        }
        //判断是否超时
        long currentTime = System.currentTimeMillis();
        long tokenCreateTime = Long.parseLong(tokenContext.getCreateTime().toString());
        if (currentTime - tokenCreateTime > 0 && currentTime - tokenCreateTime <= (SystemConfig.MODIFY_TOKEN_TIME)) {
            //30分钟内令牌不变
            ThreadLocalManager.setTokenContext(tokenContext);
        } else if (currentTime - tokenCreateTime > (SystemConfig.MODIFY_TOKEN_TIME)
                && currentTime - tokenCreateTime <= (SystemConfig.OVERDUE_TOKEN_TIME)) {
            //30分钟到1小时之间更新token
            redisUtil.remove(securityToken);
            tokenContext.setCreateTime(System.currentTimeMillis());
            securityToken = JWTUtil.createToken();
            tokenContext.setToken(securityToken);
            ThreadLocalManager.setTokenContext(tokenContext);
            redisUtil.set(securityToken,tokenContext,SystemConfig.OVERDUE_TOKEN_TIME);
        } else {
            //超过一个小时后需要重新登录
            redisUtil.remove(securityToken);
            ThreadLocalManager.removeTokenContext();
            throw new ServiceException(ErrorCode.TOKEN_INVALID);
        }
        return true;
    }
}
