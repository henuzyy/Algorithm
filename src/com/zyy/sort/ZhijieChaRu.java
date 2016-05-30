package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @�㷨����:ֱ�Ӳ�������
 * @����˼·:</br>
 * 			1.������һ�������˳�򣬽�֮���Ԫ�غ�ǰ�������Ԫ�ؽ��бȽ�</br>
 *             2.��Ϊ������ģ�����һ��Ӻ�����ǰ��Ƚϣ����ǰ���������������ǰ���Ԫ������ƶ�һ��λ��</br>
 *             3.ֱ����������������Ҫ�Ƚϵ�Ԫ�ط��벻�����λ�ô�</br>
 */
public class ZhijieChaRu implements Base {

	@Override
	public void sort() {
		// int[] arr = Util.fixedArray();
		int[] arr = Util.createArray(10);
		for (int j = 1; j < arr.length; j++) {
			int temp = arr[j];
			int index = j - 1;
			// ע��˴��ļ���
			while (index >= 0 && arr[index] > temp) {
				arr[index + 1] = arr[index];
				index--;
			}
			arr[index + 1] = temp;
		}
		Util.print(arr);
	}

	public void sortS() {
		// int[] arr = Util.fixedArray();
		int[] arr = Util.createArray(10);
		for (int j = 1; j < arr.length; j++) {
			int temp = arr[j];
			int index = j;
			// ע��˴��ļ���
			while (index >= 0 && arr[index - 1] > temp) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = temp;
		}
		Util.print(arr);
	}

	public void prin() {
		int[] arr = Util.createArray(10);
		for (int j = arr.length / 2; j >= 1; j /= 2)
			for (int i = 1; i < arr.length; i++) {
				int index = i - j;
				int value = arr[i];
				while (index >= 0 && arr[index] > value) {
					arr[index + j] = arr[index];
					index -= j;
				}
				arr[index + j] = value;
			}
		Util.print(arr);
	}

	public void sortQuickS() {
		// int[] arr = Util.fixedArray();

		int[] arr = Util.createArray(10);

		int N = arr.length / 2;

		while (N >= 1) {
			for (int j = 1; j < arr.length; j++) {
				int temp = arr[j];
				int index = j - N;
				// ע��˴��ļ���
				while (index >= 0 && arr[index] > temp) {
					arr[index + N] = arr[index];
					index -= N;
				}
				arr[index + N] = temp;
			}
			N /= 2;
		}
		Util.print(arr);
	}

	public static void main(String[] args) {
		int[] arr = Util.createArray(10);
		new ZhijieChaRu().heapSort(arr);
		Util.print(arr);
	}

	public void kuai(int[] arr, int start, int end) {
		if (start < end) {
			int i = start, j = end;
			int value = arr[start];
			while (j > i) {
				while (j > i && arr[j] > value)	j--;
				if (j > i)	arr[i++] = arr[j];
				while (j > i && arr[i] < value)	i++;
				if (j > i)	arr[j--] = arr[i];
			}
			arr[i] = value;
			kuai(arr, start, i - 1);
			kuai(arr, j + 1, end);
		}

	}
	
	
	public void heapSort(int [] arr){
		for(int i=arr.length/2-1;i>=0;i--)
			fix(arr,i,arr.length);
		for(int i=arr.length-1;i>=1;i--){
			int temp =arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			fix(arr, 0, i);
		}
	}
	public void fix(int [] arr,int i,int end){
		int value = arr[i];
		int j = 2 * i + 1; 
		while(j<end){
			if(j+1<end && arr[j+1] > arr[j]){	j++;}
			if(value > arr[j]){
				break;
			}
			arr[i] = arr[j];
			i = j;
			j = 2 * i +1;
		}
		arr[i] = value;
	}
	
	

	public void sorts() {
		int[] arr = Util.createArray(10);
		for (int r = arr.length / 2; r >= 1; r /= 2) {
			for (int i = r; i < arr.length; i++) {
				int j = i - r;
				int value = arr[i];
				while (j >= 0 && arr[j] > value) {
					arr[j + r] = arr[j];
					j -= r;
				}
				arr[j + r] = value;
			}
		}

		Util.print(arr);
	}

}
