package com.zbl.util;

import java.util.Random;

@SuppressWarnings("unused")
public class RandomUtils {

    private static final Random random = new Random();

    /**
     * 生成一个在 [low, hig] 范围上的随机数
     *
     * @param low 下限
     * @param hig 上限
     * @return [low, hig] 范围上的随机数
     */
    public static int randomInt(int low, int hig) {
        if (low == hig)
            return low;
        return Math.min(low, hig) + random.nextInt(Math.abs(hig - low) + 1);
    }


    /**
     * 随机生成一个指定长度的int型数组
     *
     * @param length 指定的长度
     * @return 随机生成的数组
     */
    public static int[] randomIntArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = randomInt(0, Integer.MAX_VALUE - 1);
        }
        return arr;
    }
}
