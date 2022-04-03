package cn.atong.leek.spring.aop;

import java.lang.reflect.Method;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-04-03 19:36
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);

 }
