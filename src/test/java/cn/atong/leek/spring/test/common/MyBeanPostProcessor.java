package cn.atong.leek.spring.test.common;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.config.BeanPostProcessor;
import cn.atong.leek.spring.test.bean.UserService;

/**
 * @program: leek-spring
 * @description: 自定义 BeanPostProcessor
 * @author: atong
 * @create: 2022-03-29 14:31
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("====postProcessBeforeInitialization :: " + beanName + "====");
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setAge(88);
        }
        return bean;
    }

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("====postProcessAfterInitialization :: " + beanName + "====");
        return null;
    }
}
