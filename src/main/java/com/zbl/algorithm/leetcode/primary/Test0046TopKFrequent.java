package com.zbl.algorithm.leetcode.primary;

import java.util.*;

/**
 * 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/12 15:01
 */
@SuppressWarnings("unused")
public class Test0046TopKFrequent {
    public static void main(String[] args) {

        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        int[] ints2 = topKFrequent(new int[]{1}, 1);

    }

    static class FrequentNode implements Comparable<FrequentNode> {
        int value;
        int frequent;

        FrequentNode(int value, int frequent) {
            this.value = value;
            this.frequent = frequent;
        }

        @Override
        public int compareTo(FrequentNode o) {
            return o.frequent - this.frequent;
        }
    }

    private static int[] topKFrequent(int[] nums, int k) {
        //利用hashMap统计频率
        HashMap<Integer, FrequentNode> frequentNodes = new HashMap<>();
        for (int num : nums) {
            FrequentNode obj = frequentNodes.get(num);
            if (obj != null) {
                frequentNodes.put(num, new FrequentNode(obj.value, obj.frequent + 1));
            } else {
                frequentNodes.put(num, new FrequentNode(num, 1));
            }
        }

        //拿出所有values，放入到大根堆(FrequentNode定义自然排序)中即可
        Collection<FrequentNode> values = frequentNodes.values();
        PriorityQueue<FrequentNode> heap = new PriorityQueue<>(values);

        //依次拿出堆顶元素即可
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (!heap.isEmpty())
                result[i] = heap.poll().value;
        }

        return result;
    }
}
