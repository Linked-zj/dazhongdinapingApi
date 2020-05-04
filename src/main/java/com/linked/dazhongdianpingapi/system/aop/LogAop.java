package com.linked.dazhongdianpingapi.system.aop;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Slf4j
@Aspect
@Component
public class LogAop {
    private final ObjectMapper objectMapper;
    /**
     * 存放目标类的log
     */
    private Map<String, Logger> logMap;
    /**
     * 不需要输出的参数，比如 request,response,session
     */
    private List<Class> notPrintParams;

    @Autowired
    public LogAop(ObjectMapper objectMapper) {
        init();
        this.objectMapper = objectMapper;
    }

    /**
     * 初始化
     */
    private void init() {
        logMap = new HashMap<>(16);

        //默认不需要输出的参数信息
        notPrintParams = new ArrayList<>();
        notPrintParams.add(ServletResponse.class);
        notPrintParams.add(ServletRequest.class);
        notPrintParams.add(HttpSession.class);
        notPrintParams.add(BindingResult.class);
        notPrintParams.add(MultipartFile.class);
    }


    /**
     * 切点
     */
    @Pointcut("execution(* com.linked.dazhongdianpingapi.business.controller..*.*(..))")
    public void pointcut() {
    }

    // @Around是可以同时在所拦截方法的前后执行一段逻辑 环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取连接点的方法签名对象
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        Logger log = getLog(signature.getDeclaringType());
        String logStr = "--------------- {}() {} ---------------";
        log.info(logStr, method.getName(), "方法开始");

        //输出参数信息
        printParam(joinPoint.getArgs(), signature.getParameterNames(), log);
        Object proceed;
        try {

            //执行目标方法
            proceed = joinPoint.proceed();
        } catch (Exception e) {
            log.info(logStr, method.getName(), "方法执行异常");
            //让异常处理器去处理，这里只记录
            throw e;
        }

        //输出返回信息
        printResult(signature.getReturnType(), proceed);

        log.info(logStr, method.getName(), "方法结束");

        return proceed;

    }


    /**
     * 输出参数
     *
     * @param args 参数列表
     * @param log  输出的日志对象
     */
    private void printParam(Object[] args, String[] names, Logger log) {
        // 开启了info才遍历输出
        if (log.isInfoEnabled()) {
            int i = 0;
            for (Object arg : args) {

                String value = "null";

                if (isPrintParams(arg)) {
                    try {
                        value = objectMapper.writeValueAsString(arg);
                    } catch (JsonProcessingException ignored) {
                        log.warn("输出参数json异常", ignored);
                    }
                } else {
                    break;
                }

                log.info("参数 {} ：{}", names[i], value);

                i++;

            }
        }

    }


    /**
     * 输出返回数据
     *
     * @param proceed 目标方法执行结果
     * @throws JsonProcessingException json异常
     */
    private void printResult(Class returnType, Object proceed) throws JsonProcessingException {
        if (returnType != null && proceed != null) {
            log.info("返回{} : {}", String.class.equals(returnType) ? "页面" : "json数据"
                    , objectMapper.writeValueAsString(proceed));
        }
    }

    /**
     * 获取日志对象，没有就新建一个，然后保存到logMap中缓存
     *
     * @param c 目标类
     * @return 日志对象
     */
    private Logger getLog(Class c) {
        // 看key是否有值存在，不存在就把Function的值设置进去
        return logMap.computeIfAbsent(c.getCanonicalName(), k -> LoggerFactory.getLogger(c));
    }


    /**
     * 是否输出参数
     *
     * @param obj 参数
     * @return {@link Boolean}
     */
    private boolean isPrintParams(Object obj) {
        for (Class c : notPrintParams) {
            //noinspection unchecked
            if (obj != null && c.isAssignableFrom(obj.getClass())) {
                return false;
            }
        }
        return true;
    }

}
