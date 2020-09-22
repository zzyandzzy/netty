package io.netty.intent.nio;

import java.nio.ByteBuffer;

/**
 * @author intent zzy.main@gmail.com
 * @date 2020/9/22 15:06
 * @since 1.0
 */
public class NioTest5 {
    /**
     * ByteBuffer类型化的put和gei方法
     * @param args
     */
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        // 1 byte
        byteBuffer.put(Byte.MAX_VALUE);
        // 2 byte
        byteBuffer.putShort(Short.MAX_VALUE);
        // 2 byte
        byteBuffer.putChar(Character.MAX_VALUE);
        // 4 byte
        byteBuffer.putInt(Integer.MAX_VALUE);
        // 4 byte
        byteBuffer.putFloat(Float.MAX_VALUE);
        // 8 byte
        byteBuffer.putLong(Long.MAX_VALUE);
        // 8 byte
        byteBuffer.putDouble(Double.MAX_VALUE);
        // 共29个字节
        byteBuffer.flip();
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
    }
}
