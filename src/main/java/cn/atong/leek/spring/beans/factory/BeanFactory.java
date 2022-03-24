package cn.atong.leek.spring.beans.factory;

import cn.atong.leek.spring.beans.BeansException;

/**
 * @program: leek-spring
 * @description: Spring 顶级接口
 * @author: atong
 * @create: 2022-03-24 11:24
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
