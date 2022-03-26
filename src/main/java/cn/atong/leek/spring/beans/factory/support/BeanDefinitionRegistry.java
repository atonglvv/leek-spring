package cn.atong.leek.spring.beans.factory.support;

import cn.atong.leek.spring.beans.factory.config.BeanDefinition;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-24 15:53
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * 注册 BeanDefinition 方式较多, 这里将 registerBeanDefinition 单独拿出来做为接口
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);
}
