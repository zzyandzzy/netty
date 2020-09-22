package io.netty.intent.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * io.netty.intent.nio
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/9/21 11:48
 * @since 1.0
 */
public class NioTest1 {
    /**
     * 使用NIO生成10个随机数
     *
     * @param args
     */
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            // SecureRandom更为健壮的随机数生成器
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
