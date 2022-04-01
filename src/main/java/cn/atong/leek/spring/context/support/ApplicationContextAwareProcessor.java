package cn.atong.leek.spring.context.support;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.config.BeanPostProcessor;
import cn.atong.leek.spring.context.ApplicationContext;
import cn.atong.leek.spring.context.ApplicationContextAware;

/**
 * @program: leek-spring
 * @description: ApplicationContextAwareProcessor
 * @author: atong
 * @create: 2022-04-01 15:38
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
