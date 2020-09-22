package io.netty.intent.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * io.netty.intent.nio
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/9/21 12:44
 * @since 1.0
 */
public class NioTest3 {
    /**
     * 测试NIO写入文件
     *
     * @param args
     */
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannel = null;
        try {
            URL url = NioTest2.class.getClassLoader().getResource("./");
            if (url == null) {
                throw new IOException("Resources path not found!");
            }
            fileOutputStream = new FileOutputStream(url.getPath() + "test2.txt");
            fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            byte[] message = "Hello NIO!".getBytes();
            for (byte data : message) {
                byteBuffer.put(data);
            }
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
