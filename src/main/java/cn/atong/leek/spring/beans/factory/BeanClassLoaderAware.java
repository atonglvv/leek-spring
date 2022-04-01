package cn.atong.leek.spring.beans.factory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-04-01 15:25
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
