package com.zyy.offer;

public class Three {

	/***
	 * 
	 * ��ά�����ȱ����ǣ��˷��ڴ�ռ䣬
	 * 	 int [][] a = new int[y][x];
		   ȡy�ĳ��ȣ� a.length;
		   ȡx�ĳ��ȣ� a[0].length;  ps:a[0].length=a[1].length= a[n].length
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
	 * @param arr ˼·�� �������Ͻǿ�ʼ������Ƚϣ����Ҫ�Ƚϵ���С����ôX--�����Ҫ�Ƚϵ�������ôY++,ֱ���ٽ���������.
	 * @param num
	 * @return
	 */
	public boolean Serach(int [][] arr,int num){
		//[y][x] [4][6]
		int x = arr[0].length-1;
		int y = 0;
		
		if(arr!=null && arr.length>0 && arr[0].length>0){
			if(arr[0][0]>num){ //Ҫ�Ƚϵ���С�ڶ�ά�����е���С��
				return false;
			}
			if(arr[arr.length-1][arr[0].length-1]<num){  //Ҫ�Ƚϵ������ڶ�ά�����е������ 
				return false;
			}
			while(x>=0 && y<arr.length){
				System.out.println("[" + y + "][" + x + "]");
				if(arr[y][x]==num){
					return true;
				}else if (arr[y][x] > num){  //��С
					x--;
				}else {   //����
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
