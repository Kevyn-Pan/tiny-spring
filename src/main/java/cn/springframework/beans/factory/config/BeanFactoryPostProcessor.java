package cn.springframework.beans.factory.config;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Classname BeanFactoryPostProcessor
 * @Description 容器扩展机制，允许在Bean对象注册后但未实例化之前对Bean对定义信息BeanDefinition执行修改操作
 * @Version 1.0.0
 * @Date 2023/1/3 09:32
 * @Created by kevynpan
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的BeanDefinition加载完成后，实例化Bean对象之前，提供修改BeanDefinition属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
