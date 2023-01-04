package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Classname SimpleInstantiationStrategy
 * @Description JDK实例化
 * @Version 1.0.0
 * @Date 2022/12/7 14:47
 * @Created by kevynpan
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    /**
     * Bean实例化策略
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor 包含了一些必要的类信息，用于获取到符合入参信息相对应的构造函数
     * @param args 具体的入参信息，最终实例化时会用到
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        // 获取在Bean定义时传递进去的Class信息
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                // 有构造函数实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // 无构造函数实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
