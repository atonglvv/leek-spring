package cn.atong.leek.spring.beans.factory;

import cn.atong.leek.spring.beans.BeansException;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-04-01 15:26
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
