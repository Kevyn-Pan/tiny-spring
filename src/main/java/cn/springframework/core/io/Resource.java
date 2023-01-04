package cn.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname Resource
 * @Description 资源加载接口
 * @Version 1.0.0
 * @Date 2022/12/28 15:40
 * @Created by kevynpan
 */
public interface Resource {

    /**
     * 提供获取InputStream流的方法，接下来再分别实现三种不同的流文件操作：classPath、FileSystem、URL
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
