package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/***
 * 控制器拦截器
 * @author indy
 *
 */
@Aspect
@Component
public class AllRequestAroundAspect {

    @Autowired(required = false)
    private HttpServletRequest request;

    private final static Logger logger = LoggerFactory.getLogger(AllRequestAroundAspect.class);

    /***
     * 拦截所有控制器
     */
    @Pointcut("@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)")
    public void allRequest() {
    }


    /***
     * 拦截WEB接口请求
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("allRequest()")
    public Object allRequestAround(JoinPoint joinPoint) throws Throwable {
        long startMs = System.currentTimeMillis();
        //-------------
        logger.info("URL : {}", request.getRequestURL().toString());
        logger.info("URI : {}", request.getServletPath());
        logger.info("HTTP_METHOD : {}", request.getMethod());
        //-------------
        Object resultObj = ((ProceedingJoinPoint) joinPoint).proceed();
        long executiveMs = System.currentTimeMillis() - startMs;
        logger.info("调用方法[{}]共用时间: {} ms", joinPoint.toLongString(), executiveMs);
        logger.info("-------------------------------------");
        return resultObj;
    }

    /***
     * 抛出异常执行
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "allRequest()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error(e.getLocalizedMessage());
    }
}
