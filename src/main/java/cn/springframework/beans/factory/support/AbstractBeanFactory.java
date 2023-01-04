package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.BeanFactory;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanPostProcessor;
import cn.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AbstractBeanFactory
 * @Description 抽象类定义模板方法，继承了DefaultSingletonBeanRegistry即具备了使用单例注册类方法的功能
 *              继承本抽象类的类有两个：AbstractAutowireCapableBeanFactory、DefaultListableBeanFactory，这两个类做了相应的实现处理
 * @Version 1.0.0
 * @Date 2022/12/6 15:29
 * @Created by kevynpan
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    /**
     * 该方法主要是对单例Bean对象的获取 以及 在获取不到时需要拿到Bean的定义去做相应的Bean实例化操作
     * 可见，getBean并没有自身去实现这些方法，只是定义了调用过程和提供了抽象方法，由实现此抽象类的其他类做相应实现
     *
     * @param name
     * @return
     * @throws BeansException
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
