package com.atguigu.ioc05;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author : fanxuanyu
 * @Description : 制造JavaBean的工厂Bean对象
 * @Date : 2024/4/2
 * @Time : 17:01
 * @Version : 1.0
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    @Override
    public JavaBean getObject() throws Exception {
        JavaBean javaBean = new JavaBean();
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
