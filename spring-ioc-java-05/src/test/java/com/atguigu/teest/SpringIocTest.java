package com.atguigu.teest;

import com.atguigu.ioc_01.config.JavaConfiguration;
import com.atguigu.ioc_01.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController bean = annotationConfigApplicationContext.getBean(StudentController.class);
        System.out.println(bean);

    }

}
