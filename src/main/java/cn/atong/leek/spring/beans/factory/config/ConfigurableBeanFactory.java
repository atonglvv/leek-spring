package cn.atong.leek.spring.beans.factory.config;

import cn.atong.leek.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-29 13:48
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
