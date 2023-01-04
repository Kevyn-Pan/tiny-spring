package cn.springframework.test.common;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.PropertyValue;
import cn.springframework.beans.PropertyValues;
import cn.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Classname MyBeanFactoryPostProcessor
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/1/3 10:01
 * @Created by kevynpan
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
