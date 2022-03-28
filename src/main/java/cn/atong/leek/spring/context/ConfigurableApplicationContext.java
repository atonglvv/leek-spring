package cn.atong.leek.spring.context;

import cn.atong.leek.spring.beans.BeansException;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-28 20:26
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
