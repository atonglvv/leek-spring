package cn.atong.leek.spring.beans.factory;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-04-01 11:49
 */
public interface DisposableBean {
    void destroy() throws Exception;
}