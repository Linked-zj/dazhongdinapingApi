package com.linked.dazhongdianpingapi.system.interceptor.customInterceptors;


import com.linked.dazhongdianpingapi.system.base.ErrorCode;
import com.linked.dazhongdianpingapi.system.base.SystemConfig;
import com.linked.dazhongdianpingapi.system.exception.ServiceException;
import com.linked.dazhongdianpingapi.system.interceptor.UrlFilter;
import com.linked.dazhongdianpingapi.system.util.spring.SpringBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Cookie
 * @Description: 拦截器
 * @Date: Create in 15:34 2019/1/15
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    WebTokenCheck webTokenCheck = SpringBeanUtil.getBean(WebTokenCheck.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        log.info("=========Request  =========");
        //TODO 前端待完善，请求未带TOKEN
//        return true;
        //判断时候在不拦截范围
        if (UrlFilter.urlHandler(request)) {
            return true;
        }
        //其他接口拦截(可扩展：web,app,miniapp..）
        if (request.getHeader(SystemConfig.WEB_TOKEN) != null ) {
            //webToken验证
            return webTokenCheck.check(request);
        }else {
            //throw new ServiceException(ErrorCode.TOKEN_WITHOUT);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
