package com.zyy.sort;

import com.zyy.Util;

/**
 * ˼·��
 * 1.n��������n-1������
 * 2.ÿһ�����������Ƚϴ�С����������㽻��˳��ÿһ�˽��ų����/С����
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
