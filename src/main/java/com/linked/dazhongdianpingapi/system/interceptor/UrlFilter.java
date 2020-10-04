package com.linked.dazhongdianpingapi.system.interceptor;




import com.linked.dazhongdianpingapi.system.util.threadlocal.ThreadLocalManager;
import com.linked.dazhongdianpingapi.system.util.threadlocal.TokenContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Cookie
 * @Date: 2019/1/15 17:09
 * @Description: url放行
 */
public class UrlFilter {
    /**
     * @param request
     * @return true 通过 false 不通过
     * @Description: url处理。（包括国际化的处理）
     * @author： Aaron
     * @datte: 2017/6/20 0020 上午 9:50
     * @company: 北京帮众信息技术有限公司
     */
    public static boolean urlHandler(HttpServletRequest request) throws Exception {
        //截取需要的url路径
        String url = request.getServletPath();
        //过滤不需要拦截的url
        if (urlFilter(url)) {
            //登录和swagger不拦截
            TokenContext tokenContext = new TokenContext();
            ThreadLocalManager.setTokenContext(tokenContext);
            return true;
        }
        return false;
    }

    /**
     * @param url 带拦截的url
     * @return
     * @Description: 细粒度控制不需要拦截的url，如果数量多可以提到一个配置文件
     * @author： Aaron
     * @datte: 2017/6/20 0020 上午 9:47
     * @company: 北京帮众信息技术有限公司
     */
    private static boolean urlFilter(String url) {
        if (url.contains("swagger")
                || url.contains("druid")
                || url.endsWith("login")
                || url.contains("upload")
                || url.contains("register")
                || url.contains("flash")
                || url.contains("swipe")
                || url.contains("product")
                || url.contains("shop")
                || url.contains("comment")
                || url.contains("image")
                || url.contains("order")
                ) {
            return true;
        }
        return false;
    }
}
