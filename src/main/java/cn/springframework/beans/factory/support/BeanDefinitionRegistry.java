package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

/**
 * @Classname BeanDefinitionRegistry
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/6 15:29
 * @Created by kevynpan
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);


    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的Bean名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
