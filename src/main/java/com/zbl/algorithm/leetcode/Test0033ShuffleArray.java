package com.zbl.algorithm.leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * <p>
 * 实现 Solution class:
 * <p>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn6gq1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0033ShuffleArray {
    private int[] arrFrom;
    private int[] arrTo;
    private Random random = new Random();
    private HashSet<String> arrStrSet = new HashSet<>();
    //记录所有排列的情况个数
    private int count = 1;

    @SuppressWarnings("all")
    public Test0033ShuffleArray(int[] nums) {
        arrFrom = Arrays.copyOf(nums, nums.length);
        arrTo = nums;
        if (nums.length > 1) {
            for (int i = 1; i <= nums.length; i++) {
                count *= i;
            }
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    @SuppressWarnings("all")
    public int[] reset() {
        return arrFrom;
    }

    /**
     * Returns a random shuffling of the array.
     */
    @SuppressWarnings("all")
    public int[] shuffle() {
        int length = arrTo.length;
        //首次打乱数组
        for (int i = 0; i < length; i++) {
            swap(arrTo, i, random.nextInt(length));
        }

        //将打乱后的数组字符串化
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arrTo.length; i++) {
            str.append(arrTo[i]);
        }
        //如果打乱后的数组之前已经出现过，则重新打乱直到出现一个之前没有出现过的组合
        while (arrStrSet.contains(str.toString())) {
            for (int i = 0; i < length; i++) {
                swap(arrTo, i, random.nextInt(length));
            }
            str.delete(0, str.length());
            for (int i = 0; i < arrTo.length; i++) {
                str.append(arrTo[i]);
            }
        }
        //能走到这里，则说明已经出现一个之前没有出现过的组合
        arrStrSet.add(str.toString());
        //如果所有组合情况已经出现，则将组合集合清空，进行新一轮
        if (arrStrSet.size() == count)
            arrStrSet.clear();

        return arrTo;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        Test0033ShuffleArray array = new Test0033ShuffleArray(ints);
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.shuffle()));

        System.out.println("====================================");

        System.out.println(Arrays.toString(array.reset()));
    }
}
