package com.atguigu.test;

import com.atguigu.ioc_01.XxxDao;
import com.atguigu.ioc_02.JavaBean;
import com.atguigu.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void testIoc_01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        XxxDao xxxDao = applicationContext.getBean(XxxDao.class);


    }
    @Test
    public void testIoc_02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean javaBean = applicationContext.getBean(JavaBean.class);
        applicationContext.close();
    }

    @Test
    public void testIoc_03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController controller = applicationContext.getBean(UserController.class);
        controller.show();
        applicationContext.close();
    }

    
}
