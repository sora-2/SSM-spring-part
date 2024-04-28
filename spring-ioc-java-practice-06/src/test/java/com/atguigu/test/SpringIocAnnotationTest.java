package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocAnnotationTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController studentController = annotationConfigApplicationContext.getBean(StudentController.class);
        studentController.findAll();
    }

}
