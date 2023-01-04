package cn.springframework.beans.factory.support;

import cn.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DefaultSingletonBeanRegistry
 * @Description 单例注册接口的实现
 * @Version 1.0.0
 * @Date 2022/12/6 15:30
 * @Created by kevynpan
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * protected方法可以被继承此类的其他类调用，包括被AbstractBeanFactory、继承的DefaultListableBeanFactory调用
     *
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
