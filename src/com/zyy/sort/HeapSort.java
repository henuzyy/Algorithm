package com.zyy.sort;

import com.zyy.Util;

/**
 * @author:zyy
 * @算法名称:堆排序
 * @基本思路:</br>
 * 			堆排序（二叉堆）拥有两个特性(初始化的过程，使数组具有二叉堆的以下两个性质)：
 *             1．父结点的键值总是大于或等于（小于或等于）任何一个子节点的键值。
 *             2．每个结点的左子树和右子树都是一个二叉堆（都是最大堆或最小堆）。
 * 
 */
public class HeapSort implements Base {

	public static void main(String[] args) {
		int[] arr = Util.fixedArray();
		new HeapSort().sort1(arr);
		Util.print(arr);
	}

	/**
	 * 堆排序
	 */
	public void sort(int[] arr) {
		// 初始化一个无序的二叉堆，（只是基本有序） ；初始化可以保证每个父节点都比各自的子节点大
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			sortHeapFixdown(arr, i, arr.length);
		}
		// 这里的作用是，将已经排好的最大堆顶(最大数)放入数组最后，然后再将数组最后一位的前一位，临时放入堆顶，进行下一次堆排序
		for (int i = arr.length - 1; i >= 1; i--) {
			int temp = arr[i]; // 交换a[0] 和最后的一个数
			arr[i] = arr[0];
			arr[0] = temp;

			sortHeapFixdown(arr, 0, i);
		}
	}

	/**
	 * 从i开始,从上到下排出最大的那个数，放入数组第i个位置 [大顶堆]，(该算法利用到了直接插入排序的算法)
	 * 
	 * @param arr
	 * @param i
	 *            从i开始排序
	 * @param length
	 */
	public static void sortHeapFixdown(int[] arr, int i, int length) {
		int temp = arr[i];
		int j = 2 * i + 1;

		while (j < length) {

			if (j + 1 < length && arr[j] < arr[j + 1]) { // 判断左右两个子节点的大小
				j++;
			}

			if (temp >= arr[j]) { // 父节点大于两个子节点，结束比较
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
		
/*		// 初始化一个无序的二叉堆，（只是基本有序） ；初始化可以保证每个父节点都比各自的子节点大
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			sortHeapFixdown(arr, i, arr.length);
		}
		// 这里的作用是，将已经排好的最大堆顶(最大数)放入数组最后，然后再将数组最后一位的前一位，临时放入堆顶，进行下一次堆排序
		for (int i = arr.length - 1; i >= 1; i--) {
			int temp = arr[i]; // 交换a[0] 和最后的一个数
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
