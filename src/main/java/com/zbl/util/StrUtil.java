package com.zbl.util;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/6/21 20:52
 */
public class StrUtil {

    /**
     * 将一个字符串转化为下划线格式的字符串
     * <p>
     * 如：
     * bbbAaa -> bbb_aaa;
     *
     * @param str 原字符串
     * @return 转化后的字符串
     */
    public static String toUnderlineStr(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (CharUtil.isLetterUpper(ch)) {
                sb.append('_').append((char) (ch + 32));
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
