package com.zbl.algorithm.practice._0319;
/**
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累计起来，叫做数组的小和。求一个数组的小和
 * 例子：
 * [1，3，4，2，5]
 * 1左边比1小的数，没有，
 * 3左边比3小的数，1
 * 4左边比4小的数，1，3
 * 2左边比2小的数，1
 * 5左边比5小的数，1，3，4，2
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class Test002{
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5};
		int sum = process(arr, 0, arr.length - 1);
	}

	public static int process(int[] arr, int left, int right) {
		if (left == right) {
			return 0;
		}

		int mid = left + ((right - left) >> 1);
		return process(arr, left, mid) 
				+ process(arr, mid + 1, right)
				+ merge(arr, left, mid, right);
	}


	public static int merge(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];
		//记录小和
		int sum = 0;

		int i = 0;
		int p1 = left;
		int p2 = mid + 1;

		while(p1 <= mid && p2 <= right) {
			sum += arr[p2] > arr[p1] ? arr[p1] * (right - p2 + 1) : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= right) {
			help[i++] = arr[p2++];
		}

		for (int j = 0; j < help.length; j++) {
			arr[left + j] = help[j];
		}

		return sum;
	}
}

