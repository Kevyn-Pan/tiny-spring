package cn.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Classname UrlResource
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/28 15:40
 * @Created by kevynpan
 */
public class UrlResource implements Resource{

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    /**
     * 提供获取InputStream流的方法，接下来再分别实现三种不同的流文件操作：classPath、FileSystem、URL
     * 通过Http的方式读取云服务的文件，我们可以把配置文件放到GitHub或Gitee上
     *
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        }
        catch (IOException ex){
            if (con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();
            }
            throw ex;
        }
    }
}
