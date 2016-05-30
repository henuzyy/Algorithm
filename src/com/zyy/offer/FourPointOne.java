package com.zyy.offer;

/**
 * @author:zyy
 * @算法名称:合并两个有序的数组（不去重）
 * @基本思路:</br>
 * 
 */
public class FourPointOne {

	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 3, 5, 6, 7, 7 };
		int b[] = { 1, 2, 4, 5, 8, 8, 9, 10, 11, 12, 12, 13, 14 };
		int[] d = { 1, 3, 2 };
		int[] c = FourPointOne.mergeArray(a, b);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + "\t");
		}
		System.out.println();
		System.out.println(isOrder(a));
		System.out.println(isOrder(d));

	}

	/**
	 * 合并有序数组
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] mergeArray(int[] a, int[] b) {
		if (a == null && b != null) {
			return b;
		} else if (a != null && b == null) {
			return a;
		} else if (a == null && b == null) {
			return null;
		}
		int[] c = new int[a.length + b.length];
		int aindex = 0, bindex = 0, cindex = 0;
		while (aindex < a.length && bindex < b.length) {
			if (a[aindex] < b[bindex]) { // b > a
				c[cindex] = a[aindex];
				aindex++;
			} else {
				c[cindex] = b[bindex];
				bindex++;
			}
			cindex++;
		}
		while (aindex < a.length) {
			c[cindex] = a[aindex];
			aindex++;
			cindex++;
		}
		while (bindex < a.length) {
			c[cindex] = b[bindex];
			bindex++;
			cindex++;
		}
		return c;
	}

	/**
	 * 检查数组是否为有序的
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isOrder(int [] arr ){
		if(arr.length<=1){
			return true;
		}
		for(int i=0;i<arr.length-1;){
			if(arr[i] < arr[++i]){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}


}
