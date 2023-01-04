package cn.springframework.beans;

/**
 * @Classname BeansException
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/6 15:31
 * @Created by kevynpan
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
