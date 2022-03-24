package cn.atong.leek.spring.beans.factory.config;

/**
 * @program: leek-spring
 * @description: Bean的定义的封装
 * @author: atong
 * @create: 2022-03-24 11:41
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
