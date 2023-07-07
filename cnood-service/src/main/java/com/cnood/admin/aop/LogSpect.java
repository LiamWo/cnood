package com.cnood.admin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author LogSpect
 * @Date 2023/6/29
 * @Description
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class LogSpect {
    @Pointcut("execution(* com.cnood.admin.service..*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "================>");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "================>");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "================>");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("环绕之前================>");
        Object obj = joinPoint.proceed();
        System.out.println("环绕之后================>");
        return obj;
    }
}
