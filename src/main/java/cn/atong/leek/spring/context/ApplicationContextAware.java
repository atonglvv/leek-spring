package cn.atong.leek.spring.context;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.Aware;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-04-01 15:18
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
