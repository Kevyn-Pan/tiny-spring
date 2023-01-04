package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Classname CglibSubclassingInstantiationStrategy
 * @Description Cglib实例化
 * @Version 1.0.0
 * @Date 2022/12/7 14:46
 * @Created by kevynpan
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    /**
     * Bean实例化策略
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor 包含了一些必要的类信息，用于获取到符合入参信息相对应的构造函数
     * @param args 具体的入参信息，最终实例化时会用到
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor == null) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
