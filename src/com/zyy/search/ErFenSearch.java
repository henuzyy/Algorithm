package com.zyy.search;

/**
 * @author:zyy
 * @�㷨����:�۰����(���ֲ���)
 * @����˼·:</br>
 * 			0.����������������� 1.�ؼ����ڿ�����β������ֵ
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
			} else if (key > arr[mid]) { // �������ں��棬�޸�start
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
