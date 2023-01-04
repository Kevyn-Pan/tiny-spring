package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.core.io.Resource;
import cn.springframework.core.io.ResourceLoader;

/**
 * @Classname BeanDefinitionReader
 * @Description Bean定义读取接口
 * @Version 1.0.0
 * @Date 2022/12/28 15:35
 * @Created by kevynpan
 */
public interface BeanDefinitionReader {

    /**
     * getRegistry()和getResourceLoader()都是用于提供给后面三个方法的工具，加载和注册这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
