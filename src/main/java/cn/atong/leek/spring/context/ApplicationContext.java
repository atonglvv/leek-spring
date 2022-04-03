package cn.atong.leek.spring.context;

import cn.atong.leek.spring.beans.factory.ListableBeanFactory;

/**
 * @program: leek-spring
 * @description: 应用上下文
 * @author: atong
 * @create: 2022-03-28 20:05
 */
public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher {
}
