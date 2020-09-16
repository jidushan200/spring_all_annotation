package com.hong.project.service;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Description：日志服务
 */
public interface LogInfoService {

    /**
     * @Description 前置通知
     * @MethodName beforeLogInfo

     */
    void beforeLogInfo(JoinPoint joinPoint);

    /**
     * @Description 后置正常返回通知
     * @MethodName afterReturningLogInfo
     */
    void afterReturningLogInfo(JoinPoint joinPoint);

    /**
     * @Description 异常通知
     * @MethodName afterThrowingLogInfo
     */
    void afterThrowingLogInfo(JoinPoint joinPoint);

    /**
     * @Description 最终通知
     * @MethodName afterLogInfo
     */
    void afterLogInfo(JoinPoint joinPoint);

    /**
     * @Description 环绕通知
     * @MethodName aroundLogInfo
     */
    Object aroundLogInfo(ProceedingJoinPoint joinPoint);
}


