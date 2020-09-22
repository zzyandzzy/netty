package io.netty.intent.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author intent zzy.main@gmail.com
 * @date 2020/9/22 16:49
 * @since 1.0
 */
public class NioTest8 {
    /**
     * DirectBuffer
     * @param args
     */
    public static void main(String[] args) throws IOException {
        URL url = NioTest4.class.getClassLoader().getResource("input2.txt");
        URL outputUrl = NioTest2.class.getClassLoader().getResource("./");
        if (url == null || outputUrl == null) {
            throw new IOException("File not found!");
        }
        FileInputStream fileInputStream = new FileInputStream(url.getPath());
        FileOutputStream fileOutputStream = new FileOutputStream(outputUrl.getPath() + "output2.txt");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);
        while (true) {
            byteBuffer.clear();// 不能注释该行
            int read = inputChannel.read(byteBuffer);
            System.out.println("read: " + read);
            if (-1 == read) {
                break;
            }
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
