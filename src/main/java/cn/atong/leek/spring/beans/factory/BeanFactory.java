package cn.atong.leek.spring.beans.factory;

import cn.atong.leek.spring.beans.BeansException;

/**
 * @program: leek-spring
 * @description: Spring 顶级接口
 * @author: atong
 * @create: 2022-03-24 11:24
 */
public interface BeanFactory {

    /**
     * 提供从容器中获取 Bean 的方法
     *
     * @param name bean's name
     * @return Object
     */
    Object getBean(String name) throws BeansException;

    /**
     * 提供从容器中获取 Bean 的方法, 传递入参给构造函数实例化
     *
     * @param name
     * @param args 构造参数
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;
}
