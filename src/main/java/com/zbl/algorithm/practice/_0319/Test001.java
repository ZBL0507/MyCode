package com.zbl.algorithm.practice._0319;

public class Test001{
	public static void main(String[] args) {
		int[] arr = {23, 45645, 56, 90, -232, 0, 8980, -79, 6786, 0};
		mergeSort(arr, 0, arr.length - 1);
	} 


	public static void mergeSort(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}

		int mid = (i + j) / 2;
		mergeSort(arr, i, mid);
		mergeSort(arr, mid + 1, j);
		merge(arr, i, mid, j);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];

		int i = 0;
		int p1 = left;
		int p2 = mid + 1;

		while(p1 <= mid && p2 <= right) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= right) {
			help[i++] = arr[p2++];
		}

		for(int j = 0; j < help.length; j++) {
			arr[left + j] = help[j];
		}
	}
}