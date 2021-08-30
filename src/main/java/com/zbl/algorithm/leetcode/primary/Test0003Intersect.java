package com.zbl.algorithm.leetcode.primary;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0003Intersect {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 3, 4, 5, 6, 7};
        int[] nums2 = new int[]{2, 3, 4, 8};

        int[] intersect = intersect(nums1, nums2);
    }

    /**
     * 给定两个数组，计算它们的交集    暴力求解
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 交集
     */
    @SuppressWarnings("Duplicates")
    private static int[] intersect(int[] nums1, int[] nums2) {
        int temp;
        //对 nums1 进行升序排序
        //Arrays.sort(nums1);
        for (int i = 0; i < nums1.length - 1; i++) {
            int swapCount = 0;
            for (int j = 0; j < nums1.length - 1 - i; j++) {
                if (nums1[j] > nums1[j + 1]) {
                    temp = nums1[j];
                    nums1[j] = nums1[j + 1];
                    nums1[j + 1] = temp;
                    swapCount++;
                }
            }
            if (swapCount == 0)
                break;
        }

        //对 nums2 进行升序排序 
        for (int i = 0; i < nums2.length - 1; i++) {
            int swapCount = 0;
            for (int j = 0; j < nums2.length - 1 - i; j++) {
                if (nums2[j] > nums2[j + 1]) {
                    temp = nums2[j];
                    nums2[j] = nums2[j + 1];
                    nums2[j + 1] = temp;
                    swapCount++;
                }
            }
            if (swapCount == 0)
                break;
        }

        int[] resultTempArr = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
        int tempIndex = 0;

        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                resultTempArr[tempIndex++] = nums1[index1];
                index1++;
                index2++;
            }
        }

        int[] resultArr = new int[tempIndex];
        System.arraycopy(resultTempArr, 0, resultArr, 0, resultArr.length);

        return resultArr;
    }
}
