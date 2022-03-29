package cn.atong.leek.spring.beans.factory.support;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.ConfigurableListableBeanFactory;
import cn.atong.leek.spring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-24 15:02
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取BeanDefinition
     * BeanFactoryPostProcessor 修改BeanDefinition用
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            // 判断type是否为beanClass的父类
            if (type.isAssignableFrom(beanClass)) {
                /*
                 * 在这里先将 实现了BeanFactoryPOSTProcessor接口的类实例化 放到容器
                 * 然后调用postProcessBeanFactory方法修改BeanDefinition
                 */
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
