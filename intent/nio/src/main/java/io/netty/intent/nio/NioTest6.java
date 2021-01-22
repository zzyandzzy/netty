package io.netty.intent.nio;

import java.nio.ByteBuffer;

/**
 * @author intent zzy.main@gmail.com
 * @date 2020/9/22 15:43
 * @since 1.0
 */
public class NioTest6 {
    /**
     * Slice Buffer 和 原来的Buffer的关系
     *
     * @param args
     */
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer sliceBuffer = buffer.slice();

        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get();
            b *= 2;
            sliceBuffer.put(i, b);
        }

        buffer.clear();

        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.get());
        }
    }
}
