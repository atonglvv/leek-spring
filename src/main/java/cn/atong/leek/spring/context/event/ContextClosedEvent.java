package cn.atong.leek.spring.context.event;

/**
 * @description  Event raised when an <code>ApplicationContext</code> gets closed.
 * 监听关闭动作
 * @author atong
 * @date 16:58 2022/4/3
 * @version 1.0.0.1
 **/
public class ContextClosedEvent extends ApplicationContextEvent{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }

}
