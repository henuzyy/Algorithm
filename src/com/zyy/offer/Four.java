package com.zyy.offer;

import com.zyy.Util;

public class Four {

	/*
	 * public String replaceBlank(String str){ StringBuffer buffer = new
	 * StringBuffer(); if(str!=null && str.length()>0){ for(int
	 * i=0;i<str.length();i++){ char index = str.charAt(i);
	 * System.out.println(index); if(" ".equals(index)){ buffer.append("%2D");
	 * }else{ buffer.append(index); } } return buffer.toString(); } return null;
	 * 
	 * }
	 */

	// 替换到字符串中的所有空格为#20(在原字符串的基础上)
/**
 * 注意要点：字符串中取出空格，是一个char类型，判断是否为空，需要用 ' '== xxxxx   ，因为char为基本类型
 * 
 * 
 * **/
	
	/**
	 * @return
	 */
	public static StringBuilder replaceBlank() {
		char [] str =new char[100];
		String sr = new String(" We are happy!We    are happy!We are happy ");
		for(int i=0;i<sr.length();i++){
			str[i] = sr.charAt(i);
			if(' '==str[i]){
				System.out.println(str[i] + "空格");
			}
		}
		System.out.println("*********************************************");
		if (str != null && str.length > 0) {
			int count = 0;
			for (int i = 0; i < str.length; i++) {
				if (' '== str[i]) {
					count++;
				}
			}
			System.out.println("count=" + count);
			if (count > 0) {
				int index = sr.length()-1;
				while(count>0){
					if (' '== str[index]) { // 移动三位
						str[index + count * 2] = '0';
						str[index + count * 2 -1] = '2';
						str[index + count * 2 -2] = '#';
						count--;
					}else{
						str[index + count * 2] = str[index];						
					}
					index--;
				}
			}
		}
		
		System.out.println("--------------------------");
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]);
		}
		
		return null;
	}

	public static void main(String[] args) {
		/*
		 * String str = "We are happy!"; System.out.println(str.replace(" ",
		 * "%2D")); System.out.println(new Four().replaceBlank(str));
		 */
		Four.replaceBlank();
	}

}
