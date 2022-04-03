package cn.atong.leek.spring.context.event;

import cn.atong.leek.spring.context.ApplicationEvent;
import cn.atong.leek.spring.context.ApplicationListener;

/**
 * @description  事件广播器
 * @author atong
 * @date 17:07 2022/4/3
 * @version 1.0.0.1
 **/
public interface ApplicationEventMulticaster {

    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);

}
