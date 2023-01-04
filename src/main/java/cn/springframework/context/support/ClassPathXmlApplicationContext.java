package cn.springframework.context.support;

import cn.springframework.beans.BeansException;

/**
 * @Classname ClassPathXmlApplicationContext
 * @Description 应用上下文实现类。在继承了AbstractXmlApplicationContext以及层层抽象类的功能分离实现后，在此类的实现中就简单多了，
 *              主要是对继承抽象类中方法的调用和提供了配置文件地址信息
 * @Version 1.0.0
 * @Date 2023/1/3 09:36
 * @Created by kevynpan
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {

    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    /**
     * 从入口上下文类获取配置信息的地址描述
     *
     * @return
     */
    @Override
    public String[] getConfigLocations() {
        return configLocations;
    }
}
