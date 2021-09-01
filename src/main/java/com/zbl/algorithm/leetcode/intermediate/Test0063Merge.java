package com.zbl.algorithm.leetcode.intermediate;

import java.util.ArrayList;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/1 21:27
 */
@SuppressWarnings("all")
public class Test0063Merge {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {0, 4}};
        int[][] merge = merge(intervals);
    }

    private static int[][] merge(int[][] intervals) {
        //base case
        if (intervals.length <= 1)
            return intervals;

        //sort
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        ArrayList<DS> list = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curBegin = intervals[i][0];
            int curEnd = intervals[i][1];
            if (begin <= curBegin && curBegin <= end) {
                if (curEnd > end)
                    end = curEnd;
            } else {
                DS ds = new DS(begin, end);
                list.add(ds);
                begin = curBegin;
                end = curEnd;
            }
        }
        list.add(new DS(begin, end));

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = new int[2];
            res[i][0] = list.get(i).begin;
            res[i][1] = list.get(i).end;
        }

        return res;
    }

    static class DS {
        int begin;
        int end;

        DS(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
