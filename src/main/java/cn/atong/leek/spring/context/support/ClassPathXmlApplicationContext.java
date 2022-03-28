package cn.atong.leek.spring.context.support;

import cn.atong.leek.spring.beans.BeansException;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-28 21:59
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        //创建容器, 刷新容器
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
