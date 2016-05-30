package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @算法名称:shell排序
 * @基本思路:</br>
 *  1.基于插入排序的思想<br/>
 *  2.将N个元素分为N/2个组，分别将每组元素进行比较，即([1 和 n/2 + 1] 、 [2 和 n/2+2] )<br/>
 *  3.然后将 N/2 / 2个组，再按照步骤2中的进行比较，直到 N/2的结果=1为止， 其实为1时，就相当于是插入排序<br/>
 * 
 */
public class Shell implements Base {

	@Override
	public void sort() {
		int[] arr = Util.fixedArray();
		for (int i = arr.length / 2; i >= 1; i /= 2) {
			for (int j = i; j < arr.length; j++) {
				int count = arr[j];
				int index = j - i;
				while (index >= 0 && arr[index] > count) {
					arr[index + i] = arr[index];
					index -= i;

				}
				arr[index + i] = count;
			}
		}
		Util.print(arr);
	}

	public static void main(String[] args) {
		new Shell().sort();
	}

}
