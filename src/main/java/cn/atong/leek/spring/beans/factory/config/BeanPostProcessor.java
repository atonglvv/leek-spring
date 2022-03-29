package cn.atong.leek.spring.beans.factory.config;

import cn.atong.leek.spring.beans.BeansException;

/**
 * @program: leek-spring
 * @description: 用于修改实例化Bean对象的扩展点(初始化前修改 与 初始化后修改)
 * @author: atong
 * @create: 2022-03-29 11:20
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
