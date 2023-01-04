package cn.springframework.beans.factory.config;

import cn.springframework.beans.BeansException;

/**
 * @Classname BeanPostProcessor
 * @Description 也是容器扩展机制，区别在于BeanPostProcessor是在Bean对象实例化后修改Bean对象，也可以替换Bean对象
 * @Version 1.0.0
 * @Date 2023/1/3 09:32
 * @Created by kevynpan
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行初始化方法后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
