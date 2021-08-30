package com.zbl.algorithm.leetcode.primary;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * 示例 1：
 * 输入：nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
 * 输出：[1, 2, 2, 3, 5, 6]
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("all")
public class Test0011MergeArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int countOfTemp = m;
        int countOfNums2 = n;
        int indexOfTemp = 0;
        int indexOfNums2 = 0;
        int indexOfNums1 = 0;
        while (countOfTemp > 0 && countOfNums2 > 0) {
            if (temp[indexOfTemp] <= nums2[indexOfNums2]) {
                nums1[indexOfNums1++] = temp[indexOfTemp];
                indexOfTemp++;
                countOfTemp--;
            } else {
                nums1[indexOfNums1++] = nums2[indexOfNums2];
                indexOfNums2++;
                countOfNums2--;
            }
        }

        while (countOfTemp > 0) {
            nums1[indexOfNums1++] = temp[indexOfTemp++];
            countOfTemp--;
        }

        while (countOfNums2 > 0) {
            nums1[indexOfNums1++] = nums2[indexOfNums2++];
            countOfNums2--;
        }
    }
}
