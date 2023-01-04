package cn.springframework.beans.factory.config;

/**
 * @Classname SingletonBeanRegistry
 * @Description 单例注册接口的定义
 * @Version 1.0.0
 * @Date 2022/12/6 15:28
 * @Created by kevynpan
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
