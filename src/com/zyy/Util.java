package com.zyy;

import java.util.Random;

public class Util {

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	/**
	 * 1-10ÎÞÐòÊý×é
	 */
	public static int[] fixedArray() {
		return new int[] { 2, 1, 6, 3, 9, 7, 5, 8, 10, 4 };
	}

	public static int[] createArray(int size) {
		int[] result = new int[size];
		Random r = new Random();
		for (int i = 0; i < result.length; i++) {
			result[i] = r.nextInt(100);
		}
		return result;
	}
}
