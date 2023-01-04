package cn.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Classname DefaultResourceLoader
 * @Description 包装资源加载器实现
 * @Version 1.0.0
 * @Date 2022/12/28 15:39
 * @Created by kevynpan
 */
public class DefaultResourceLoader implements ResourceLoader{

    /**
     * 在获取资源的实现中，主要是把三种不同类型的资源处理方式进行了包装，分为：判断是否为ClassPath、URL以及文件
     *
     * @param location
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null!");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
