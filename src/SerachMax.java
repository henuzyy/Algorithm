import java.util.Random;

public class SerachMax {

	
	public static int serachMax(int  [] ...arrs){
		int max = 0;
		for(int i=0;i<arrs.length;i++){  //N���б�
			for (int k = 0; k < arrs[i].length - 1;k++) {
				if (max < arrs[i][k]) { // ����
					max = arrs[i][k];
				} else { 
					continue;
				}
			}
		}
		return max;
	}
	
	
}
