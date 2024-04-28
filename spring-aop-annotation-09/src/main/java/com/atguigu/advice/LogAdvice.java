package com.atguigu.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
    @Before("com.atguigu.pointcut.MyPointCut.pc()")
    public void start(){
        System.out.println("method start");
    }
    @After("com.atguigu.pointcut.MyPointCut.pc()")
    public void stop(){
        System.out.println("method stop");
    }
    @AfterThrowing("com.atguigu.pointcut.MyPointCut.pc()")
    public void error(){
        System.out.println("method error");
    }

}
