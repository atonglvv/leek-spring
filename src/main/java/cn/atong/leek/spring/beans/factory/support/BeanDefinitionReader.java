package cn.atong.leek.spring.beans.factory.support;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.core.io.Resource;
import cn.atong.leek.spring.core.io.ResourceLoader;

/**
 * @program: leek-spring
 * @description: 读取 BeanDefinition
 * @author: atong
 * @create: 2022-03-26 17:32
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();
}
