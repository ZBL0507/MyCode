package com.zbl.algorithm.leetcode.primary;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("all")
public class Test0007IsPalindrome {
    public static void main(String[] args) {
        isPalindrome(", ");
        isPalindrome("A man, a plan, a canal: Panama");
        isPalindrome("race a car");
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i])) {
                i++;
                if (i == chars.length)
                    return true;
            }
            while (!Character.isDigit(chars[j]) && !Character.isLetter(chars[j]))
                j--;
            if (chars[i] != chars[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
