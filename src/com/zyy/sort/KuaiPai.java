package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @算法名称: 快速排序
 * @基本思路:</br>
 * 
 * 			借鉴：http://blog.csdn.net/morewindows/article/details/6684558
 * 
 */
public class KuaiPai implements Base {

	
	public void sortss(int [] arr,int index,int length){
		if(index<length){
			int temp = arr[index];
			int i= index,j = length;
			while(i<j){
				while(i<j && arr[j]>temp){
					j--;
				}
				if(i<j){
					arr[i++] = arr[j];
				}
				while(i<j && arr[i]<temp){
					i++;
				}
				if(i<j){
					arr[j--] = arr[i];
				}
			}
			arr[i] = temp;
			sortss(arr,index,i-1);
			sortss(arr,i+1,length);
		}
	}
	
	
	
	@Override
	public void sort() {
		int arr[] = Util.fixedArray();
		sortss(arr, 0, arr.length - 1);
		// sortImpl(arr, 0, arr.length - 1);
		Util.print(arr);

	}

	public void sors(int[] arr, int start, int end) {
		if (start < end) {
			int i = start, j = end;
			int value = arr[i];
			while (i < j) {
				while (i < j && arr[j] >= value) {
					j--;
				}
				if (i < j) {
					arr[i] = arr[j];
					i++;
				}
				while (i < j && arr[i] < value) {
					i++;
				}
				if (i < j) {
					arr[j] = arr[i];
					j--;
				}
			}
			arr[i] = value;
			sors(arr, start, i - 1);
			sors(arr, j + 1, end);
		}
	}

	public void sortImpl(int[] arr, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int i = leftIndex;
			int j = rightIndex;
			int x = arr[i];
			while (i < j) {
				while (i < j && arr[j] >= x) {
					j--;
				}
				if (i < j) {
					arr[i++] = arr[j];
				}
				while (i < j && arr[i] < x) {
					i++;
				}
				if (i < j) {
					arr[j--] = arr[i];
				}
			}
			arr[i] = x;
			sortImpl(arr, leftIndex, i - 1);
			sortImpl(arr, i + 1, rightIndex);
		}
	}

	public static void main(String[] args) {
		new KuaiPai().sort();
	}
}
