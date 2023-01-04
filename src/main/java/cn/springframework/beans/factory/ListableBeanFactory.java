package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Classname ListableBeanFactory
 * @Description 拓展Bean工厂接口的接口
 * @Version 1.0.0
 * @Date 2022/12/28 15:37
 * @Created by kevynpan
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回Bean实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
