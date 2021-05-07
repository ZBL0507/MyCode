package com.zbl.algorithm.introduction;

/**
 * 寻找一个最大子数组
 * 说明： 一个最大子数组  不是  最大子数组，  因为可能有多个子数组达到最大和
 * 只有当数组中包含负数时，最大子数组问题才有意义，如果所有数组元素都是非负的，最大子数组问题没有任何难度，因为整个数组的和肯定是最大的
 */
@SuppressWarnings("unused")
public class FindMaximumSubArray {
    public static void main(String[] args) {
        int[] ints = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

        int[] maxCrossingSubArray = findMaxCrossingSubArray(ints, 0, (ints.length - 1) / 2, ints.length - 1);

        int[] maximumSubArray = findMaximumSubArray(ints);
        int[] arr = {7, 1, 5, 3, 6, 4};
        int[] maximumSubArray2 = findMaximumSubArray(arr);
    }

    /**
     * 给定一个数组，寻找其一个最大子数组
     *
     * @param arr 给定的数组
     * @return 返回一个形如int[3]型的数组，
     * * 该数组第一个元素就是[最大子数组]的开始下标，
     * * 该数组第二个元素就是[最大子数组]的结束下标，
     * * 该数组第三个元素就是[最大子数组]的和
     */
    private static int[] findMaximumSubArray(int[] arr) {
        return findMaximumSubArray(arr, 0, arr.length - 1);
    }

    /**
     * 对于给定数组，在给定区间上寻找其一个最大子数组
     *
     * @param arr  给定数组
     * @param low  给定区间下限
     * @param high 给定区间上限
     * @return 返回一个形如int[3]型的数组，
     * * 该数组第一个元素就是[最大子数组]的开始下标，
     * * 该数组第二个元素就是[最大子数组]的结束下标，
     * * 该数组第三个元素就是[最大子数组]的和
     */
    @SuppressWarnings("all")
    private static int[] findMaximumSubArray(int[] arr, int low, int high) {
        if (low == high)
            return new int[]{low, high, arr[low]};
        int mid = (low + high) / 2;
        int[] maximumSubArrayOfLeft = findMaximumSubArray(arr, low, mid);
        int[] maxCrossingSubArray = findMaxCrossingSubArray(arr, low, mid, high);
        int[] maximumSubArrayOfRight = findMaximumSubArray(arr, mid + 1, high);
        if (maximumSubArrayOfLeft[2] >= maxCrossingSubArray[2] &&
                maximumSubArrayOfLeft[2] >= maximumSubArrayOfRight[2])
            return maximumSubArrayOfLeft;
        else if (maximumSubArrayOfRight[2] >= maxCrossingSubArray[2]
                && maximumSubArrayOfRight[2] >= maximumSubArrayOfLeft[2])
            return maximumSubArrayOfRight;
        else
            return maxCrossingSubArray;
    }

    /**
     * 寻找跨越中点的最大子数组
     *
     * @param arr  给定数组
     * @param low  区间下限
     * @param mid  中点
     * @param high 区间上限
     * @return 返回一个形如int[3]型的数组，
     * * 该数组第一个元素就是[跨越中点最大子数组]的开始下标，
     * * 该数组第二个元素就是[跨越中点最大子数组]的结束下标，
     * * 该数组第三个元素就是[跨越中点最大子数组]的和
     */
    private static int[] findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
        int leftSum = arr[mid];
        int sum = arr[mid];
        int maxLeft = mid;
        for (int i = mid - 1; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = arr[mid + 1];
        sum = arr[mid + 1];
        int maxRight = mid + 1;
        for (int i = mid + 2; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
