package cn.springframework.beans.factory.config;

/**
 * @Classname BeanReference
 * @Description 类引用
 * @Version 1.0.0
 * @Date 2022/12/28 10:34
 * @Created by kevynpan
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
