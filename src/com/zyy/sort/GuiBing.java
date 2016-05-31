package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @算法名称:归并排序
 * @基本思路:</br>
 * 	根据两个有序数组合并的思想，将有M个元素的数组拆分成不可拆的M个数组，然后再合并，最后合并成有序的
 * 
 */
public class GuiBing implements Base {

	public static void main(String[] args) {
		new GuiBing().sort();
	}

	@Override
	public void sort() {
		int[] arr = Util.fixedArray();
		int[] temp = new int[10];   //临时数组，主要是起到的作用是：存放两个数组已经排序好的部分
		mergeSort(arr, 0, arr.length - 1, temp);
		Util.print(arr);
	}

	public static void mergeSort(int[] arr, int first, int last, int[] temp) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(arr, first, mid, temp);
			mergeSort(arr, mid + 1, last, temp);
			mergeTwoArrays(arr, first, mid, last, temp);
		}
	}

	/**
	 * 两个有序数组合并，升序排列
	 * 
	 * @param arr
	 * @param first
	 *            开始下标
	 * @param mid
	 *            中间下标
	 * @param last
	 *            最后下标
	 * @param temp
	 */
	public static void mergeTwoArrays(int[] arr, int first, int mid, int last, int[] temp) {
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = 0;
		while (i <= m && j <= n) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= m) {
			temp[k++] = arr[i++];
		}
		while (j <= n) {
			temp[k++] = arr[j++];
		}
		
		for (i = 0; i < k; i++) {
			arr[first + i] = temp[i];
		}

	}
	
	

}
