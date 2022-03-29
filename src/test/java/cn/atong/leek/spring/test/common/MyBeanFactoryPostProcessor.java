package cn.atong.leek.spring.test.common;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.PropertyValue;
import cn.atong.leek.spring.beans.PropertyValues;
import cn.atong.leek.spring.beans.factory.ConfigurableListableBeanFactory;
import cn.atong.leek.spring.beans.factory.config.BeanDefinition;
import cn.atong.leek.spring.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @program: leek-spring
 * @description: 自定义BeanFactoryPostProcessor
 * @author: atong
 * @create: 2022-03-29 09:55
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("age", 28));
    }

}
