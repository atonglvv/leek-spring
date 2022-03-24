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
     * @param name bean's name
     * @return Object
     */
    Object getBean(String name) throws BeansException;
}
