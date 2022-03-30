package cn.atong.leek.spring.beans.factory.support;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.DisposableBean;
import cn.atong.leek.spring.beans.factory.config.SingletonBeanRegistry;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: leek-spring
 * @description: 单例Bean注册实现类
 * @author: atong
 * @create: 2022-03-24 16:18
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    /**
     * 销毁单例Bean
     */
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                Method destroyMethod = disposableBean.getBean().getClass().getMethod(disposableBean.getDestroyMethodName());
                if (null == destroyMethod) {
                    throw new BeansException("Couldn't find a destroy method named '" + disposableBean.getBeanName() + "' on bean with name '" + beanName + "'");
                }
                destroyMethod.invoke(disposableBean.getBean());
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
