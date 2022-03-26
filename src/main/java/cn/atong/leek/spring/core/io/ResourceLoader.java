package cn.atong.leek.spring.core.io;

/**
 * @program: leek-spring
 * @description: 包装一下Resource，方便使用
 * @author: atong
 * @create: 2022-03-26 19:33
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
