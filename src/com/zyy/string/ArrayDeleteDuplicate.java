package com.zyy.string;

import java.util.Arrays;

import com.zyy.Util;

/**
 * @author:zyy
 * @�㷨����: ����������ȥ���ظ�����
 * @����˼·:</br>
 * 
 */
public class ArrayDeleteDuplicate {

	/**
	 *  ���������У����ظ��ĸ���
	 */
	public static int countUnique(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i + 1]) {
				count++;
			}
		}
		return (A.length - count);
	}
	// [1,2,2,4,5,5,5,6,7,7] 10 ����
	// [1,2,4,4,5,5,5,6,7,7] 10 ����
	// [1,2,4,5,5,5,5,6,7,7] 10 ����
	// [1,2,4,5,6,5,5,6,7,7] 10 ����
	// [1,2,4,5,6,7,5,6,7,7] 10 ����
	/**
	 * ȥ�ز���
	 * */
	public static int[] removeDuplicates(int[] A) {
		if (A.length < 2)
			return A;
		int j = 0;
		int i = 1;
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		int[] B = Arrays.copyOf(A, j + 1);
		return B;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 2, 4, 5, 5, 5, 6, 7, 7 };
		 Util.print(removeDuplicates(arr));
	}

}
