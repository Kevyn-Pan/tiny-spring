package cn.springframework.beans.factory.config;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.BeanFactory;

/**
 * @Classname AutowireCapableBeanFactory
 * @Description 自动化处理Bean工厂配置的接口
 * @Version 1.0.0
 * @Date 2022/12/28 15:33
 * @Created by kevynpan
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcessors接口实现类的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行BeanPostProcessors接口实现类的postProcessorsAfterInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
