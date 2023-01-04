package cn.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PropertyValues
 * @Description 属性集合类，用于传递类中属性信息
 * @Version 1.0.0
 * @Date 2022/12/28 10:32
 * @Created by kevynpan
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
