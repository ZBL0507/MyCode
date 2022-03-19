package com.zbl.algorithm.practice._0319;

public class Test003{
	public static void main(String[] args){
		int[] arr = {23, 456, -89, 456, 0, 45645, -34563};
		quickSort(arr, 0, arr.length - 1);
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int begin, int end) {
		if (begin >= end) {
			return;
		}

		int pos = findPosition(arr, begin, end);
		quickSort(arr, begin, pos - 1);
		quickSort(arr, pos + 1, end);
	}

	public static int findPosition(int[] arr, int begin, int end) {
		int key = arr[begin];

		int p1 = begin;
		int p2 = end;

		while (p1 < p2) {
			while(arr[p2] > key) {
				p2--;
			}
			if (p2 > p1) {
				arr[p1++] = arr[p2];
			}
			while(p1 < p2 && arr[p1] < key) {
				p1++;
			}
			if (p2 > p1) {
				arr[p2--] = arr[p1];
			}
		}

		arr[p1] = key;
		return p1;
	}
}