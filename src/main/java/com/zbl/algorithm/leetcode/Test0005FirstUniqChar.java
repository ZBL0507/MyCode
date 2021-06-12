package com.zbl.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0005FirstUniqChar {
    public static void main(String[] args) {
        int leetcode = firstUniqChar("leetcode");
        int loveleetcode = firstUniqChar("loveleetcode");
    }

    private static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            if (integer == null || integer == 0)
                map.put(aChar, 1);
            else
                map.put(aChar, integer + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
