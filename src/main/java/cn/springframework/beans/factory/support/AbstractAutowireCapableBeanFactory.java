package cn.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.springframework.beans.BeansException;
import cn.springframework.beans.PropertyValue;
import cn.springframework.beans.PropertyValues;
import cn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanPostProcessor;
import cn.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @Classname AbstractAutowireCapableBeanFactory
 * @Description 实例化Bean类
 * @Version 1.0.0
 * @Date 2022/12/6 15:29
 * @Created by kevynpan
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    // 创建对象的实例化策略属性类，这里选择Cglib的实现类
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给Bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行Bean的初始化方法和BeanPostProcessor的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 执行BeanPostProcessor Before处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        // TODO invokeInitMethods(beanName, wrappedBean, beanDefinition)
        invokeInitMethods(beanName, wrappedBean, beanDefinition);
        // 执行BeanPostProcessor After处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取所有构造函数的集合
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            // 循环比对出构造函数集合与入惨信息args的匹配情况
            // 这里仅作数量对比，而Spring中还会比对入参类型，否则相同数量而不同入参类型的情况就会抛异常
            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean属性填充
     * TODO 未处理循环依赖的问题
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            // 循环进行属性填充
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // A依赖B，获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    // 若为类引用，则需递归获取Bean实例。当把依赖的Bean对象创建完成后，会递归回现在属性填充中
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充时需要用到反射操作，可以使用工具类处理
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
