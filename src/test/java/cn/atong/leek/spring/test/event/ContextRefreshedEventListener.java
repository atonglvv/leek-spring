package cn.atong.leek.spring.test.event;


import cn.atong.leek.spring.context.ApplicationListener;
import cn.atong.leek.spring.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}
