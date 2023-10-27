package cn.atong.leek.spring.aop;

import cn.atong.leek.spring.util.ClassUtils;

/**
 * @program: leek-spring
 * @description: 被代理的目标对象
 * @author: atong
 * @create: 2022-04-03 21:15
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * Return the type of targets returned by this {@link TargetSource}.
     * <p>Can return <code>null</code>, although certain usages of a
     * <code>TargetSource</code> might just work with a predetermined
     * target class.
     * @return the type of targets returned by this {@link TargetSource}
     */
    public Class<?>[] getTargetClass(){
        Class<?> clazz = this.target.getClass();
        // target 可能是JDK代理创建也可能是CGlib创建，为了保证都能正确的获取到结果，需要增加判读ClassUtils.isCglibProxyClass(clazz)
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    /**
     * Return a target instance. Invoked immediately before the
     * AOP framework calls the "target" of an AOP method invocation.
     * @return the target object, which contains the joinpoint
     * @throws Exception if the target object can't be resolved
     */
    public Object getTarget(){
        return this.target;
    }

}
