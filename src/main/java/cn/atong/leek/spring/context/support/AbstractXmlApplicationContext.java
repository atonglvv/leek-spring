package cn.atong.leek.spring.context.support;

import cn.atong.leek.spring.beans.factory.support.DefaultListableBeanFactory;
import cn.atong.leek.spring.beans.factory.xml.XmlBeanDefinitionReader;
import cn.atong.leek.spring.core.io.DefaultResourceLoader;
import cn.atong.leek.spring.core.io.ResourceLoader;

/**
 * @program: leek-spring
 * @description: loadBeanDefinitions 模板
 * @author: atong
 * @create: 2022-03-28 21:48
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}

