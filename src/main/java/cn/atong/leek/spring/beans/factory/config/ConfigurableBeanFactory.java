package cn.atong.leek.spring.beans.factory.config;

import cn.atong.leek.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-29 13:48
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    /**
     * 将 BeanPostProcessor 注册到BeanFactory中
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
