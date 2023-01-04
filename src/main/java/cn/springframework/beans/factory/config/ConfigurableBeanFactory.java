package cn.springframework.beans.factory.config;

import cn.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Classname ConfigurationBeanFactory
 * @Description 可获取BeanPostProcessor、BeanClassLoader等的一个配置化接口
 * @Version 1.0.0
 * @Date 2022/12/28 15:34
 * @Created by kevynpan
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
