package cn.atong.leek.spring.beans.factory.support;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @program: leek-spring
 * @description: Bean 的 实例化策略
 * @author: atong
 * @create: 2022-03-25 10:22
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
