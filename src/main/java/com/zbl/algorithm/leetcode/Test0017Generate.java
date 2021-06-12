package com.zbl.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xncfnv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0017Generate {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        List<List<Integer>> list = generate(3);
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1){
            return result;
        }
        result.add(Collections.singletonList(1));

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>(i + 1);

            list.add(1);

            List<Integer> integers = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(integers.get(j) + integers.get(j - 1));
            }

            list.add(1);

            result.add(list);
        }
        return result;
    }
}
