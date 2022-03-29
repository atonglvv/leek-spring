package cn.atong.leek.spring.beans.factory.config;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @program: leek-spring
 * @description: 允许自定义修改BeanDefinition. 允许用户自己实现改接口, 修改BeanDefinition
 * @author: atong
 * @create: 2022-03-29 09:30
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
