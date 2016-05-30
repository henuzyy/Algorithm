package com.zyy.search;

/**
 * @author:zyy
 * @算法名称:折半查找(二分查找)
 * @基本思路:</br>
 * 			0.适用于有序数组查找 1.关键在于控制首尾索引的值
 * 
 */
public class ErFenSearch {


	public boolean search(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == arr[mid]) {
				return true;
			} else if (key > arr[mid]) { // 数可能在后面，修改start
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(new ErFenSearch().search(arr, 3));
	}

}
