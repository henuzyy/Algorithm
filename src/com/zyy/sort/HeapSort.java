package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @�㷨����:������
 * @����˼·:</br>
 * 			�����򣨶���ѣ�ӵ����������(��ʼ���Ĺ��̣�ʹ������ж���ѵ�������������)��
 *             1�������ļ�ֵ���Ǵ��ڻ���ڣ�С�ڻ���ڣ��κ�һ���ӽڵ�ļ�ֵ��
 *             2��ÿ������������������������һ������ѣ��������ѻ���С�ѣ���
 * 
 */
public class HeapSort implements Base {

	public static void main(String[] args) {
		int[] arr = Util.fixedArray();
		new HeapSort().sort1(arr);
		Util.print(arr);
	}

	/**
	 * ������
	 */
	public void sort(int[] arr) {
		// ��ʼ��һ������Ķ���ѣ���ֻ�ǻ������� ����ʼ�����Ա�֤ÿ�����ڵ㶼�ȸ��Ե��ӽڵ��
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			sortHeapFixdown(arr, i, arr.length);
		}
		// ����������ǣ����Ѿ��źõ����Ѷ�(�����)�����������Ȼ���ٽ��������һλ��ǰһλ����ʱ����Ѷ���������һ�ζ�����
		for (int i = arr.length - 1; i >= 1; i--) {
			int temp = arr[i]; // ����a[0] ������һ����
			arr[i] = arr[0];
			arr[0] = temp;

			sortHeapFixdown(arr, 0, i);
		}
	}

	/**
	 * ��i��ʼ,���ϵ����ų������Ǹ��������������i��λ�� [�󶥶�]��(���㷨���õ���ֱ�Ӳ���������㷨)
	 * 
	 * @param arr
	 * @param i
	 *            ��i��ʼ����
	 * @param length
	 */
	public static void sortHeapFixdown(int[] arr, int i, int length) {
		int temp = arr[i];
		int j = 2 * i + 1;

		while (j < length) {

			if (j + 1 < length && arr[j] < arr[j + 1]) { // �ж����������ӽڵ�Ĵ�С
				j++;
			}

			if (temp >= arr[j]) { // ���ڵ���������ӽڵ㣬�����Ƚ�
				break;
			}
			arr[i] = arr[j];
			i = j;
			j = 2 * i + 1;
		}
		arr[i] = temp;

	}
	// -----------------------------------------------------------------------

	public  static void sort1(int arr[]){
		
/*		// ��ʼ��һ������Ķ���ѣ���ֻ�ǻ������� ����ʼ�����Ա�֤ÿ�����ڵ㶼�ȸ��Ե��ӽڵ��
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			sortHeapFixdown(arr, i, arr.length);
		}
		// ����������ǣ����Ѿ��źõ����Ѷ�(�����)�����������Ȼ���ٽ��������һλ��ǰһλ����ʱ����Ѷ���������һ�ζ�����
		for (int i = arr.length - 1; i >= 1; i--) {
			int temp = arr[i]; // ����a[0] ������һ����
			arr[i] = arr[0];
			arr[0] = temp;

			sortHeapFixdown(arr, 0, i);
		}
		*/
		for(int i= arr.length/2-1;i>=0;i--){
			sortSection(arr,i,arr.length);
		}
		
		for(int i=arr.length-1;i>=1;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			sortSection(arr, 0, i);
		}
		
		
	}

	public static void sortSection(int arr[], int i, int length) {
		int temp = arr[i];
		int r = 2 * i + 1;
		while (r < length) {
			if (r + 1 < length && arr[r + 1] > arr[r]) {
				r++;
			}
			if (temp > arr[r]) {
				break;
			}

			arr[i] = arr[r];
			i = r;
			r = 2 * i + 1;

		}
		arr[i] = temp;

	}

	@Override
	public void sort() {

	}

}
