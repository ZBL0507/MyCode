package com.zbl.algorithm.practice._0319;

public class Test004{

	private static int heapSize = 0;

	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5, 6, 7};
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void heapInsert(int[] arr, int index) {
		heapSize++;

		while(arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2; 
		}
	}


	public static void heapfy(int[] arr, int index) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;

			largest = arr[index] < arr[largest] ? index : largest;

			if (index == largest) {
				break;
			}

			swap(arr, index, largest);
			index = largest;
			left = index * 2 + 1;
		}
	}



}