package com.zbl.algorithm.leetcode;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnzlu6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0009CountPrimes {
    public static void main(String[] args) {
        int countPrime = countPrime(20);
        int i = countPrimes(12);
        int i1 = countPrimes(1);
        int i2 = countPrimes(0);
    }


    private static int countPrimes(int n) {
        int count = 0;
        if (n < 5) {
            for (int i = 2; i < n; i++)
                if (isPrimeV2(i))
                    count++;
        } else {
            for (int i = 2; i < 5; i++)
                if (isPrimeV2(i))
                    count++;
        }

        for (int i = 5; i < n; i += 5) {
            if (isPrimeV2(i))
                count++;
        }

        for (int i = 7; i < n; i += 5) {
            if (isPrimeV2(i))
                count++;
        }

        return count;
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrimeV2(int n) {
        if (n <= 3)
            return n > 1;
        //程式走到这里，不在6两侧的数字一定不是质数
        if (n % 6 != 1 && n % 6 != 5)
            return false;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    private static int countPrime(int n) {
        if (n < 2)
            return 0;

        boolean[] notPrime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                int k = 2;
                while (i * k < n) {
                    //开始标记为合数
                    notPrime[i * k] = true;
                    k++;
                }
            }
        }

        return count;
    }

}
