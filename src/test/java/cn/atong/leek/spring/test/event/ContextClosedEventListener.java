package cn.atong.leek.spring.test.event;


import cn.atong.leek.spring.context.ApplicationListener;
import cn.atong.leek.spring.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
