package cn.atong.leek.spring.context.support;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.ConfigurableListableBeanFactory;
import cn.atong.leek.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @program: leek-spring
 * @description: refreshBeanFactory 模板
 * @author: atong
 * @create: 2022-03-28 21:20
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
