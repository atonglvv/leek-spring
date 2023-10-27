package cn.atong.leek.spring.util;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link cn.atong.leek.spring.beans.factory.config.ConfigurableBeanFactory}.
 * <p>
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);

}
