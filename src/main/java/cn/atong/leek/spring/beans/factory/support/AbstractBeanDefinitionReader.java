package cn.atong.leek.spring.beans.factory.support;

import cn.atong.leek.spring.core.io.DefaultResourceLoader;
import cn.atong.leek.spring.core.io.ResourceLoader;

/**
 * @program: leek-spring
 * @description: 将子类中的属性抽象一下子
 * 将 XmlBeanDefinitionReader 中的 BeanDefinitionRegistry 跟 ResourceLoader 抽象出来
 * @author: atong
 * @create: 2022-03-28 11:07
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
