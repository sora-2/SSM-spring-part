package com.atguigu.test;

import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocAnnotationTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.findAll();
        applicationContext.close();
    }

}
