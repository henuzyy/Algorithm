package com.zyy.sort;

import com.zyy.Util;

/**
 * 思路：
 * 1.n个数进行n-1趟排序
 * 2.每一趟排序，两两比较大小，条件满足便交换顺序，每一趟将排出最大/小的数
 */
public class MaoPao implements Base{

	@Override
	public void sort() {
		int [] arr = Util.fixedArray();
//		int [] arr = Base.createArray(20);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		Util.print(arr);
	}

	public static void main(String[] args) {
		new MaoPao().sort();
	}



}
