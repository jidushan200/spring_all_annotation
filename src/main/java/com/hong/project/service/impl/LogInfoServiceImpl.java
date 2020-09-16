package com.hong.project.service.impl;

import com.hong.project.service.LogInfoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description：
 */
@Component
@Aspect
public class LogInfoServiceImpl implements LogInfoService {


    @Override
    @Before("execution(* com.hong.project.com.hong.project.service.impl.*.*(..))")
    public void beforeLogInfo(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("前置通知：" + method.getName());
    }

    @Override
    @AfterReturning("execution(* com.hong.project.com.hong.project.service.impl.*.*(..))")
    public void afterReturningLogInfo(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("后置正常通知：" + method.getName());
    }

    @Override
    @AfterThrowing("execution(* com.hong.project.com.hong.project.service.impl.*.*(..))")
    public void afterThrowingLogInfo(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("后置异常通知：" + method.getName());
    }

    @Override
    @After("execution(* com.hong.project.com.hong.project.service.impl.*.*(..))")
    public void afterLogInfo(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("后置最终通知：" + method.getName());
    }

    @Override
    @Around("execution(* com.hong.project.com.hong.project.service.impl.*.*(..))")
    public Object aroundLogInfo(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        try {
            System.out.println("环绕-前置通知：" + method.getName());
            Object object = joinPoint.proceed();
            System.out.println("环绕-后置正常通知：" + method.getName());
            return object;
        } catch (Throwable throwable) {
            System.out.println("环绕-后置异常通知：" + method.getName());
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕-最终通知：" + method.getName());
        }
    }
}

