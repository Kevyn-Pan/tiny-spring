package cn.springframework.beans.factory.config;

import cn.springframework.beans.PropertyValues;

/**
 * @Classname BeanDefinition
 * @Description Class类型的bean可以把Bean的实例化操作放到容器中处理
 * @Version 1.0.0
 * @Date 2022/12/6 15:08
 * @Created by kevynpan
 */
public class BeanDefinition {

    // Bean注册时只注册一个类信息，而不会把实例化信息注册到Spring容器中，因此不应为Object，而应为Class
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
