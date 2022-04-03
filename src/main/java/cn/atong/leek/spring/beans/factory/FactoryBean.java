package cn.atong.leek.spring.beans.factory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-04-03 14:26
 */
public interface FactoryBean<T> {

    /**
     * 获取对象
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否单例对象
     * @return
     */
    boolean isSingleton();
}
