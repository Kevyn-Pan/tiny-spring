package cn.springframework.core.io;

/**
 * @Classname ResourceLoader
 * @Description 包装资源加载器
 * @Version 1.0.0
 * @Date 2022/12/28 15:40
 * @Created by kevynpan
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 定义获取资源接口，里面传递location地址即可
     * 按照资源加载的不同方式，资源加载器可以把这些方式（classPath、FileSystem、URL这三种不同的流文件操作）集中到统一的类服务下进行处理，外部用户只需要传递资源地址即可，简化使用
     *
     * @param location
     * @return
     */
    Resource getResource(String location);
}
