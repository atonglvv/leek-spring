package cn.atong.leek.spring.beans.factory.support;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.BeanFactory;
import cn.atong.leek.spring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: leek-spring
 * @description: 抽象BeanFactory
 * @author: atong
 * @create: 2022-03-24 14:17
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 模板模式, 获取 bean 的方法
     * @param name bean's name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    protected Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
