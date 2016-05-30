package com.zyy.sort;

import com.zyy.Util;

/**
 * @author zyy
 * @算法名称：简单选择排序
 * @基本思路</br>
 * 			1.N个元素，进行N-1趟排序 </br>
 *            2.在每趟比较中，找出每一趟的最小/大元素</br>
 *            3.将找出的元素和该趟的下标元素进行交换</br>
 * 
 */
public class XuanZe implements Base {

	@Override
	public void sort() {
		// int[] arr = Util.createArray(1);
		int[] arr = Util.fixedArray();
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					index = j;
				}
			}
			if (i != index) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
		Util.print(arr);

	}

	public static void main(String[] args) {
		new XuanZe().sort();
	}

}
