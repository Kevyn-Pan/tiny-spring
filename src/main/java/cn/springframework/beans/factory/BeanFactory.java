package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;

/**
 * @Classname BeanFactory
 * @Description
 * @Version 1.0.0
 * @Date 2022/12/6 15:08
 * @Created by kevynpan
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    /**
     * 重载一个含有入参信息args的getBean方法，这样可以传递入参给构造函数实例化
     *
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 按照类型获取Bean
     *
     * @param name
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
