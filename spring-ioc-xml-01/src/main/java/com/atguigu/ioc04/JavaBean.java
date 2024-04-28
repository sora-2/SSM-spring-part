package com.atguigu.ioc04;

public class JavaBean {


    //周期方法要求： 方法命名随意，但是要求方法必须是 public void 无形参列表
    public void init(){
        System.out.println("JavaBean initialization");
    }
    public void destroy(){
        System.out.println("JavaBean destroy");
    }
}
