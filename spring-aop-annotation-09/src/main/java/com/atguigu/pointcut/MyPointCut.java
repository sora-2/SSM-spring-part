package com.atguigu.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointCut {
    @Pointcut("execution(* com..impl.*.*(..))")
    public void Mypc() {}

    @Pointcut("execution(* com.atguigu.impl.*.*(..))")
    public void pc() {}
}
