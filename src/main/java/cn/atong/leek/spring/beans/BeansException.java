package cn.atong.leek.spring.beans;

/**
 * @program: leek-spring
 * @description: 自定义Bean异常
 * @author: atong
 * @create: 2022-03-24 11:35
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
