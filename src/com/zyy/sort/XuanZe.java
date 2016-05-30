package com.zyy.sort;

import com.zyy.Util;

/**
 * @author zyy
 * @�㷨���ƣ���ѡ������
 * @����˼·</br>
 * 			1.N��Ԫ�أ�����N-1������ </br>
 *            2.��ÿ�˱Ƚ��У��ҳ�ÿһ�˵���С/��Ԫ��</br>
 *            3.���ҳ���Ԫ�غ͸��˵��±�Ԫ�ؽ��н���</br>
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
