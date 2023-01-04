package cn.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname FileSystemResource
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/28 15:40
 * @Created by kevynpan
 */
public class FileSystemResource implements Resource {

    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    public final String getPath() {
        return this.path;
    }

    /**
     * 提供获取InputStream流的方法，接下来再分别实现三种不同的流文件操作：classPath、FileSystem、URL
     *
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
}
