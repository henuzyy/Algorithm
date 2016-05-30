package com.zyy.offer;

import java.util.concurrent.SynchronousQueue;

/**
 * @author:zyy
 * @�㷨����:쳲���������
 * @����˼·:</br>
 * 
 */
public class Nine {
	
	//1,2,3,5,8,13,21
	public static void main(String[] args) {
		
		long start1 = System.currentTimeMillis();
		System.out.println(getN(1000));
		System.out.println(System.currentTimeMillis()-start1);
		
		long start = System.currentTimeMillis();
		System.out.println(getN1(60));
		System.out.println(System.currentTimeMillis()-start);


		
	}

	public static int getN(int n){
		if(n<=1) return 1;
		if(n==2) return 2;
		int one = 1;
		int two = 2;
		n -=2;
		while(n >0){
			int temp  = two;
			two = one + two;
			one = temp;
			n--;
		}
		return two;
	}
	
	/**
	 * �ݹ飬Ч��̫�ͣ�ʱ�临�Ӷ���N��ָ����
	 */
	public static int getN1(int n){
		if(n<=1) return 1;
		if(n==2) return 2;
		return getN1(n-1) + getN1(n-2);
	}
	
	
}
