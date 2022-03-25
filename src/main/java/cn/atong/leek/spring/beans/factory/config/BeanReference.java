package cn.atong.leek.spring.beans.factory.config;

/**
 * @program: leek-spring
 * @description: Bean Name 的 封装类
 * @author: atong
 * @create: 2022-03-25 14:40
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
