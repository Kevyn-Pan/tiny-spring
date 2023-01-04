package cn.springframework.context.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Classname AbstractRefreshableApplicationContext
 * @Description 获取Bean工厂和加载资源
 * @Version 1.0.0
 * @Date 2023/1/3 09:35
 * @Created by kevynpan
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        // 获取DefaultListableBeanFactory的实例化
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        // 对资源配置的加载操作，在加载完成后即可完成对spring.xml配置文件中Bean对象的定义和注册，
        // 同时也包括实现了接口BeanFactoryPostProcessor和BeanPostProcessor的配置Bean信息
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 此时资源加载还只是定义了一个抽象类方法，继续由其他抽象类继承实现
     *
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
