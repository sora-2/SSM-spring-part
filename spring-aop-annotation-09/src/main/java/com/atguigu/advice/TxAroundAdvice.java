package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)
public class TxAroundAdvice {
    @Around("com.atguigu.pointcut.MyPointCut.Mypc()")
    public Object transaction(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object result=null;
        try {
            System.out.println("txaround invoked");
            result = joinPoint.proceed(args);
            System.out.println("txaround returned");
        } catch (Throwable e) {
            System.out.println("txaround threw exception");
            throw new RuntimeException(e);
        }
        return result;
    }
}
