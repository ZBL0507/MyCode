package com.zbl.algorithm.leetcode;

import java.util.*;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvqup5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Test0037Permute {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        List<List<Integer>> permute = permute(arr1);
        System.out.println(permute);
    }

    private static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1)
            return Collections.singletonList(Collections.singletonList(nums[0]));

        ArrayList<Integer> numList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        //排列数
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            count *= (i + 1);
            numList.add(nums[i]);
        }

        while (set.size() < count) {
            numList = new ArrayList<>(numList);
            Collections.shuffle(numList);
            StringBuilder str = new StringBuilder();
            for (Integer num : numList) {
                str.append(num);
            }
            if (set.add(str.toString()))
                result.add(numList);
        }

        return result;
    }
}


