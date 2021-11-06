package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopHelperCLS {

    private static final Logger logger = LoggerFactory.getLogger(LogAopHelperCLS.class);

    /**
     * @GetMapping 설정된 메소드 또는 클래스 설정
     * GetMapping 이 설정된 특정 클래스 /메소드에만 AspectJ가 적용됨
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping() {}

    /**
     * @param joinPoint
     */
    @Before("GetMapping()")
    public void before(JoinPoint joinPoint) {
        logger.info("=====================AspectJ TEST  : Before Logging Start=====================");
        logger.info("=====================AspectJ TEST  : Before Logging End=======================");
    }

    /**
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "GetMapping()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("=====================AspectJ TEST  : AfterReturning Logging Start=====================");
        logger.info("=====================AspectJ TEST  : AfterReturning Logging End=======================");
    }

    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("GetMapping()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("=====================AspectJ TEST  : Around Logging Start=====================");

        try {
            Object result = joinPoint.proceed();
            logger.info("=====================AspectJ TEST  : Around Logging Start=====================");
            return result;
        } catch (Exception e) {
            logger.error("=====================AspectJ Around Exception=====================");
            logger.error(e.toString());
            return null;
        }
    }
}
