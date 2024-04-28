package com.atguigu.test;

import com.atguigu.ioc03.HappyComponent;
import com.atguigu.ioc05.JavaBean;          //.....
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : fanxuanyu
 * @Description : ioc容器创建和读取组件
 * @Date : 2024/4/1
 * @Time : 22:04
 * @Version : 1.0
 */
public class SpringIocTest {
    /**
     * @Description : 获取Ioc容器与读取配置文件
     * @Return : void
     */
    @Test
    public void createIoc(){
        //方式1:实例化并且指定配置文件
        //参数：String...locations 传入一个或者多个配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-03.xml");

        //方式2:先实例化，再指定配置文件，最后刷新容器触发Bean实例化动作 [springmvc源码和contextLoadListener源码方式]
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-03.xml");
        context.refresh();
    }

    /**
     * @Description : 如何获取Bean
     * @Return : void
     */
    @Test
    public void getBeanFromIoc(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-03.xml");
        //方式1:实例化并且指定配置文件
        //参数：String...location
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");
        //方式2: 根据id和类型获取
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);
        //方式3: 根据类型获取
        //根据类型获取,但是要求,同类型(当前类,或者之类,或者接口的实现类)只能有一个对象交给IoC容器管理
        //配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        //根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 instanceof 指定的类型』的返回结果，
        //只要返回的是true就可以认定为和类型匹配，能够获取到。
        //ex:若HappyComponent 实现A接口 下述也是正确的
        //A happyComponent = applicationContext.getBean(A.class);
        //A.dowork();
    }
    @Test
    public void test_04(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        context.refresh();
        JavaBean javaBean = context.getBean(JavaBean.class);
        context.close();
    }


    @Test
    public void test_05(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-05.xml");
        context.refresh();
        //注意: 直接根据声明FactoryBean的id,获取的是getObject方法返回的对象
        JavaBean javaBean = context.getBean(JavaBean.class);
        System.out.println(javaBean);
        //如果想要获取FactoryBean对象, 直接在id前添加&符号即可!  &happyMachine7 这是一种固定的约束
        Object bean = context.getBean("&javaBean");
        System.out.println(bean);
        context.close();
    }
}
