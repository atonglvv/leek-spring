package cn.atong.leek.spring.beans.factory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-04-01 15:26
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}
