package cn.atong.leek.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leek-spring
 * @description: Bean属性集合
 * @author: atong
 * @create: 2022-03-25 11:13
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
