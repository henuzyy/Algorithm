package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @�㷨����:shell����
 * @����˼·:</br>
 *  1.���ڲ��������˼��<br/>
 *  2.��N��Ԫ�ط�ΪN/2���飬�ֱ�ÿ��Ԫ�ؽ��бȽϣ���([1 �� n/2 + 1] �� [2 �� n/2+2] )<br/>
 *  3.Ȼ�� N/2 / 2���飬�ٰ��ղ���2�еĽ��бȽϣ�ֱ�� N/2�Ľ��=1Ϊֹ�� ��ʵΪ1ʱ�����൱���ǲ�������<br/>
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
