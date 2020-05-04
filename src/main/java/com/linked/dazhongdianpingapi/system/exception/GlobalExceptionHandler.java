package com.linked.dazhongdianpingapi.system.exception;

import com.linked.dazhongdianpingapi.system.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@SuppressWarnings("deprecation")
	@ExceptionHandler(ServiceException.class)
	public ResultData<String> exceptionHandler(ServiceException e, HttpServletResponse response) {
        log.error(e.toString());
	    return new ResultData<>(e.getErrorCode(), e.getErrorMessage());
	}

	@SuppressWarnings("deprecation")
	@ExceptionHandler(Exception.class)
	public ResultData<String> exceptionHandler(Exception e, HttpServletResponse response) {
	    log.error(this.throwable2Strubg(e));
		return new ResultData<>(15000, "系统异常！");
	}

    /**
     * 将异常信息转为string
     * @param e
     * @return
     */
    public static String throwable2Strubg(Throwable e){
        PrintWriter pw = null;
        StringWriter sw = null;
        try{
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        }catch (Exception e1) {
            log.info(e.getMessage());
        }finally{
            if(sw!=null){
                try{
                    sw.close();
                }catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }else{
                return "";
            }
            if(pw!=null){
                pw.close();
            }
            return sw.toString();
        }
    }

}
