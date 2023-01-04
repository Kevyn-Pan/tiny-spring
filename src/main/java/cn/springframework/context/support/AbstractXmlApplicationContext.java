package cn.springframework.context.support;

import cn.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Classname AbstractXmlApplicationContext
 * @Description 上下文中对配置信息的加载
 * @Version 1.0.0
 * @Date 2023/1/3 09:35
 * @Created by kevynpan
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        // 处理XML文件配置信息
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 从入口上下文类获取配置信息的地址描述
     *
     * @return
     */
    protected abstract String[] getConfigLocations();
}
