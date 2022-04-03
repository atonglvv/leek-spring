package cn.atong.leek.spring.context.event;


import cn.atong.leek.spring.beans.factory.BeanFactory;
import cn.atong.leek.spring.context.ApplicationEvent;
import cn.atong.leek.spring.context.ApplicationListener;

/**
 * @description
 * @author atong
 * @date 17:08 2022/4/3
 * @version 1.0.0.1
 **/
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}
