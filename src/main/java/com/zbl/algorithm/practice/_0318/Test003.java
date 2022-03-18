package com.zbl.algorithm.practice._0318;
/**
 * 在一个无序的数组中，相邻的数一定不相等。
 * 求一个局部最小值的位置
 * 要求时间复杂度好于O(n)
 */
public class Test003{
	public static void main(String[] args) {
		int[] arr = {345, 56, 23, 12, -1, 89, 90, 888, 9090};
		int index = findScopeMinIndex(arr);
	}

	public static int findScopeMinIndex(int[] arr) {
		//判断局部最小是不是发生在边界处
		if (arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 2] > arr[arr.length - 1]) {
			return arr.length - 1;
		}

		int minIndex = -1;

		int low = 0;
		int hig = arr.length - 1;
		int mid = (low + hig) / 2;

		while(low <= hig) {
			if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
				return mid;
			}
			if (arr[mid - 1] < arr[mid]) {
				hig = mid - 1;
			} else if (arr[mid + 1] < arr[mid]){
				low = mid + 1;
			}
			mid = (low + hig) / 2;
		}

		return minIndex;
	}
}
