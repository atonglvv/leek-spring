package cn.atong.leek.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: leek-spring
 * @description: 资源类
 * @author: atong
 * @create: 2022-03-26 17:13
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
