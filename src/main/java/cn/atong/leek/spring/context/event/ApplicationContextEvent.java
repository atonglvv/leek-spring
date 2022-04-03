package cn.atong.leek.spring.context.event;

import cn.atong.leek.spring.context.ApplicationContext;
import cn.atong.leek.spring.context.ApplicationEvent;

/**
 * @program: leek-spring
 * @description: Base class for events raised for an <code>ApplicationContext</code
 * 定义事件的抽象类，所有的事件包括关闭、刷新，以及用户自己实现的事件，都需要继承这个类。
 * @author: atong
 * @create: 2022-04-03 16:54
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}

