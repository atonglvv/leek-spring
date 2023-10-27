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

    /**
     * Does this bean factory contain a bean definition or externally registered singleton
     * instance with the given name?
     * <p>If the given name is an alias, it will be translated back to the corresponding
     * canonical bean name.
     * <p>If this factory is hierarchical, will ask any parent factory if the bean cannot
     * be found in this factory instance.
     * <p>If a bean definition or singleton instance matching the given name is found,
     * this method will return {@code true} whether the named bean definition is concrete
     * or abstract, lazy or eager, in scope or not. Therefore, note that a {@code true}
     * return value from this method does not necessarily indicate that {@link #getBean}
     * will be able to obtain an instance for the same name.
     * @param name the name of the bean to query
     * @return whether a bean with the given name is present
     */
    boolean containsBean(String name);
}
