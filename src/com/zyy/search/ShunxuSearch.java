package com.zyy.search;

/**
 * @author:zyy
 * @�㷨����:˳�����
 * @����˼·:</br>
 * 1.���㷨�Ƚϼ򵥣���������Ƚϲ���
 */
public class ShunxuSearch {

	public boolean search(int [] arr ,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int [] arr  = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(new ShunxuSearch().search(arr, 4));
	}

}
