package com.zyy.offer;


public class Eight {

	
	public static void main(String[] args) {
//		int [] arr= {2,3,3,3,3,3,2,-3,0,1};
//		int [] arr= {2,0,};
//		int [] arr= {3,4,5,1,2};
//		int [] arr= {1,0,1,1,1}; error indexout
//		findMin(arr);
		int [] arr= {1,2,3,3,34,125}; 
		System.out.println(finMax(arr));
	}
	
	
	public static  boolean findNum(int arr[],int value){
		if(arr==null || arr.length<=0) return false;
		int start=0,end=arr.length-1;
		int mid = (start+end)/2;
		while(start<=end){
			if(arr[mid]==value){
				return true;
			}else if(arr[mid]>value){
				end = --mid;
			}else{
				start = ++mid;
			}
			mid = (start+end)/2;
		}
		
		return false;
	}
	
	public static int finMax(int [] arr){
		int max = arr[0];
		for(int i=1;i<=arr.length-1;i++)
			if(arr[i]>max) max = arr[i];
		return max;
	}
	
	public static void findMin(int [] arr){
		int temp = arr[0];
		int start = 0,end = arr.length;
		int mid = (end + start)/2;
		while(start<end){
			if(arr[mid]>=temp){
				start = mid;
			}else{
				end = mid;
			}
			if(start+1==end){
				break;
			}
			mid = (end + start)/2;
		}
		System.out.println(arr[end]);
		
	}
	
}
