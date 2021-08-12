package com.zbl.algorithm.leetcode;

/**
 * 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 示例 1：
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * <p>
 * 示例 2：
 * 输入：n = 1, bad = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= bad <= n <= 2^31 - 1
 *
 * @author zbl
 * @version 1.0
 * @since 2021/8/12 10:49
 */
@SuppressWarnings("unused")
public class Test0052FirstBadVersion {

    private static boolean[] arr = new boolean[10];

    static {
        for (int i = 0; i < 5; i++) {
            arr[i] = false;
        }

        for (int i = 5; i < 9; i++) {
            arr[i] = true;
        }
    }

    public static void main(String[] args) {
        int i = firstBadVersionV2(5);
    }

    private static int firstBadVersionV2(int n) {
        int begin = 1;
        int end = n;
        int mid;
        while (begin < end) {
            mid = begin + ((end - begin) >> 1);
            if (isBadVersion(mid))
                end = mid;
            else
                begin = mid + 1;
        }

        return begin;
    }


    private static int firstBadVersion(int n) {
        if (isBadVersion(1))
            return 1;

        int begin = 2;
        int end = n;
        int mid = begin + ((end - begin) >> 1);
        while (!(isBadVersion(mid) && !isBadVersion(mid - 1))) {
            if (isBadVersion(mid)) {
                if (isBadVersion(mid - 1)) {
                    end = mid - 1;
                    mid = begin + ((end - begin) >> 1);
                }
            } else {
                begin = mid + 1;
                mid = begin + ((end - begin) >> 1);
            }
        }

        return mid;
    }

    private static boolean isBadVersion(int version) {
        return arr[version];
    }
}
