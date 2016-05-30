package com.zyy.search;

/**
 * @author:zyy
 * @算法名称:顺序查找
 * @基本思路:</br>
 * 1.此算法比较简单，逐个遍历比较查找
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
