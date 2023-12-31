package cn.atong.leek.spring.beans.factory;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.config.BeanDefinition;
import cn.atong.leek.spring.beans.factory.config.BeanPostProcessor;
import cn.atong.leek.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-28 20:43
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory {

    /**
     * 获取BeanDefinition
     * BeanFactoryPostProcessor 修改BeanDefinition用
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
