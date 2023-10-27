package cn.atong.leek.spring.beans.factory.config;

/**
 * @program: leek-spring
 * @description: 单例Bean 注册
 * @author: atong
 * @create: 2022-03-24 16:17
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
