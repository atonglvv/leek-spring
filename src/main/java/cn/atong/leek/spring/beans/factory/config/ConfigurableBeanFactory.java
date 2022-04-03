package cn.atong.leek.spring.beans.factory.config;

import cn.atong.leek.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-29 13:48
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * Scope identifier for the standard singleton scope: {@value}.
     * <p>Custom scopes can be added via {@code registerScope}.
     */
    String SCOPE_SINGLETON = "singleton";

    /**
     * Scope identifier for the standard prototype scope: {@value}.
     * <p>Custom scopes can be added via {@code registerScope}.
     */
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 将 BeanPostProcessor 注册到BeanFactory中
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

}
