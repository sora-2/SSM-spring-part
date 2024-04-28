package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Component
@Aspect
public class MyAdvice {


    @Before("com.atguigu.pointcut.MyPointCut.Mypc()")
    public void before(JoinPoint joinPoint){
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        int modifiers = joinPoint.getSignature().getModifiers();
        String string = Modifier.toString(modifiers);
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
    }
    @AfterReturning(value = "com.atguigu.pointcut.MyPointCut.Mypc()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){

    }
    @After("com.atguigu.pointcut.MyPointCut.Mypc()")
    public void after(JoinPoint joinPoint){

    }
    @AfterThrowing(value = "com.atguigu.pointcut.MyPointCut.Mypc()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable){

    }
}
