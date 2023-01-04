package cn.springframework.beans;

/**
 * @Classname PropertyValue
 * @Description 属性值类
 * @Version 1.0.0
 * @Date 2022/12/28 10:32
 * @Created by kevynpan
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
