package com.zyy.offer;

public class Three {

	/***
	 * 
	 * 多维数组的缺点就是：浪费内存空间，
	 * 	 int [][] a = new int[y][x];
		   取y的长度： a.length;
		   取x的长度： a[0].length;  ps:a[0].length=a[1].length= a[n].length
	 * */
	
	
	public static void main(String[] args) {
	
		//4 * 6
		int [][] array  = {{1,2,4,6,7,8},{2,4,7,9,13,17},{3,5,8,10,14,20},{4,6,9,11,15,23}};
//		System.out.println("y=" + array.length);
//		System.out.println("x=" + array[0].length);
		System.out.println(new Three().Serach(array,100));
	}

//	1	2	4	6	7	8	
//	2	4	7	9	13	17	
//	3	5	8	10	14	20	
//	4	6	9	11	15	23
	/**
	 * @param arr 思路： 从最右上角开始，逐个比较，如果要比较的数小，那么X--，如果要比较的数大，那么Y++,直到临界条件发生.
	 * @param num
	 * @return
	 */
	public boolean Serach(int [][] arr,int num){
		//[y][x] [4][6]
		int x = arr[0].length-1;
		int y = 0;
		
		if(arr!=null && arr.length>0 && arr[0].length>0){
			if(arr[0][0]>num){ //要比较的数小于二维数组中的最小数
				return false;
			}
			if(arr[arr.length-1][arr[0].length-1]<num){  //要比较的数大于二维数组中的最大数 
				return false;
			}
			while(x>=0 && y<arr.length){
				System.out.println("[" + y + "][" + x + "]");
				if(arr[y][x]==num){
					return true;
				}else if (arr[y][x] > num){  //数小
					x--;
				}else {   //数大
					y++;
				}
				
			}
		}
		return false;
	}
	

	
	
	public static void print(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}
