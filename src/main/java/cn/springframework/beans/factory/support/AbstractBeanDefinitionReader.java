package cn.springframework.beans.factory.support;

import cn.springframework.core.io.DefaultResourceLoader;
import cn.springframework.core.io.ResourceLoader;

/**
 * @Classname AbstractBeanDefinitionReader
 * @Description Bean定义抽象类实现
 * @Version 1.0.0
 * @Date 2022/12/28 15:35
 * @Created by kevynpan
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    /**
     * 提供了构造函数，让外部的调用使用方把"Bean定义注入类"传递进来，这样在接口BeanDefinitionReader的具体实现类中就可以把
     * 解析后的XML文件中的Bean信息注册到Spring容器中
     *
     * @param registry
     */
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
