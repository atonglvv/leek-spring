package cn.atong.leek.spring.beans;

/**
 * @program: leek-spring
 * @description: Bean属性对象
 * @author: atong
 * @create: 2022-03-25 11:09
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
