package cn.atong.leek.spring.beans.factory;


import cn.atong.leek.spring.beans.BeansException;

/**
 * Defines a factory which can return an Object instance
 * (possibly shared or independent) when invoked.
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
