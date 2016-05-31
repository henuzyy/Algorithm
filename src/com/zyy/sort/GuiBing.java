package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @�㷨����:�鲢����
 * @����˼·:</br>
 * 	����������������ϲ���˼�룬����M��Ԫ�ص������ֳɲ��ɲ��M�����飬Ȼ���ٺϲ������ϲ��������
 * 
 */
public class GuiBing implements Base {

	public static void main(String[] args) {
		new GuiBing().sort();
	}

	@Override
	public void sort() {
		int[] arr = Util.fixedArray();
		int[] temp = new int[10];   //��ʱ���飬��Ҫ���𵽵������ǣ�������������Ѿ�����õĲ���
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
	 * ������������ϲ�����������
	 * 
	 * @param arr
	 * @param first
	 *            ��ʼ�±�
	 * @param mid
	 *            �м��±�
	 * @param last
	 *            ����±�
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
