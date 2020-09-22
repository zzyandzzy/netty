package io.netty.intent.nio;

import java.nio.ByteBuffer;

/**
 * @author intent zzy.main@gmail.com
 * @date 2020/9/22 15:57
 * @since 1.0
 */
public class NioTest7 {
    /**
     * 只读buffer
     *
     * @param args
     */
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.getClass());

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readonlyBuffer.getClass());

        readonlyBuffer.position(0);
//        readonlyBuffer.put((byte) 1); // 只读buffer不能put
    }
}
