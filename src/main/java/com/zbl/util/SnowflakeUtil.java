package com.zbl.util;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @since 2021/9/4 10:20
 */
public class SnowflakeUtil {

    /**
     * 定义一个字符数组，旨在表示10进制到64进制的映射关系
     * '0' ~ '9' --> 0 ~ 9
     * 'A' ~ 'Z' --> 10 ~ 35
     * 'a' ~ 'z' --> 36 ~ 61
     * '_','-'   --> 62,63
     */
    private final static Character[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z',
            '_', '-'
    };

    /**
     * 定义一个map, 旨在通过一个64进制字符快速获取对应的10进制数
     */
    private final static HashMap<Character, Integer> map = new HashMap<>();

    static {
        for (int i = 0; i < digits.length; i++) {
            map.put(digits[i], i);
        }
    }

    //位移位数
    private final static int shift = 6;

    private final static long mask = (1 << shift) - 1;

    /**
     * 将雪花算法id转化为64进制的字符串形式
     * 注意：不对入参做合法性校验，参数合法性由调用者自行校验
     *
     * @param nextId 雪花算法id
     * @return 转换后的64进制字符串
     */
    public static String to64Radix(long nextId) {
        StringBuilder result = new StringBuilder();
        for (; nextId != 0; ) {
            result.append(digits[(int) (nextId & mask)]);
            nextId >>= shift;
        }
        return result.reverse().toString();
    }

    /**
     * 将 一个雪花算法生成的id转化为64进制的字符串 再次转回为雪花算法id
     * 注意：不对入参做合法性校验，参数合法性由调用者自行校验
     *
     * @param value 雪花算法id转化为64进制的字符串
     * @return 转回后的雪花算法id
     */
    public static long toLong(String value) {
        long result = 0;
        char[] chars = value.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            Integer temp = map.get(chars[i]);
            result = result | temp;
            result <<= shift;
        }
        result |= map.get(chars[chars.length - 1]);

        return result;
    }
}
