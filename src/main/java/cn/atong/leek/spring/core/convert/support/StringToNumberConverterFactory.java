package cn.atong.leek.spring.core.convert.support;


import cn.atong.leek.spring.core.convert.converter.Converter;
import cn.atong.leek.spring.core.convert.converter.ConverterFactory;
import cn.atong.leek.spring.util.NumberUtils;
import com.sun.istack.internal.Nullable;

/**
 * Converts from a String any JDK-standard Number implementation.
 * <p>
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @Nullable
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }

}
