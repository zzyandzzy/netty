package io.netty.intent.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * io.netty.intent.nio
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/9/21 12:27
 * @since 1.0
 */
public class NioTest2 {
    /**
     * 测试用NIO读取文件
     *
     * @param args
     */
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        try {
            URL url = NioTest2.class.getClassLoader().getResource("test1.txt");
            if (url == null) {
                throw new IOException("File not found!");
            }
            fileInputStream = new FileInputStream(url.getPath());
            fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.remaining() > 0) {
                System.out.println((char) byteBuffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
