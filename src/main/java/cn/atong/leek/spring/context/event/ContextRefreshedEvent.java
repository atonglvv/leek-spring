package cn.atong.leek.spring.context.event;

/**
 * @description  Event raised when an <code>ApplicationContext</code> gets initialized or refreshed.
 * 监听 refreshed 动作
 * @author atong
 * @date 16:58 2022/4/3
 * @version 1.0.0.1
 **/
public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }

}
