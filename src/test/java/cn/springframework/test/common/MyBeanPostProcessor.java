package cn.springframework.test.common;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanPostProcessor;
import cn.springframework.test.bean.UserService;

/**
 * @Classname MyBeanPostProcessor
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/1/3 10:01
 * @Created by kevynpan
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
