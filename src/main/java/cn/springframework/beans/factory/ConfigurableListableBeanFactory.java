package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Classname ConfigurableListableBeanFactory
 * @Description 提供分析和修改Bean以及预先实例化的操作接口
 * @Version 1.0.0
 * @Date 2022/12/28 15:36
 * @Created by kevynpan
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
