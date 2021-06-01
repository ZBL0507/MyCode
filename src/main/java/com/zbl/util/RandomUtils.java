package com.zbl.util;

import java.util.Random;

@SuppressWarnings("unused")
public class RandomUtils {

    private static Random random = new Random();

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

}
