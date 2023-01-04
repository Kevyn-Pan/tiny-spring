package cn.springframework.context;

import cn.springframework.beans.BeansException;

/**
 * @Classname ConfigurableApplicationContext
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/1/3 09:34
 * @Created by kevynpan
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
