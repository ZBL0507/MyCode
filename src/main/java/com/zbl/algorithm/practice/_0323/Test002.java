package com.zbl.algorithm.practice._0323;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/3/29 20:22
 */
public class Test002 {
    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = -1;
        int left = 0;
        int right = input.length - 1;

        while (left != right) {
            int wide = right - left;
            int hig = Math.min(input[left], input[right]);
            res = Math.max(wide * hig, res);
            if (input[left] < input[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(res);
    }
    //赵保良
    //18434361345


    public static void main11(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int res = -1;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int wide = j - i;
                int hig = Math.min(input[i], input[j]);
                res = Math.max(wide * hig, res);
            }
        }

        System.out.println(res);
    }
}
