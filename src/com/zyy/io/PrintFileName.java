package com.zyy.io;

import java.io.File;

/**
 * @author:zyy
 * @算法名称:遍历某个文件夹下的所有文件
 * @基本思路:</br>
 * 
 */
public class PrintFileName {

	public static void main(String[] args) {
		File file = new File("D:\\solr_home");
		new PrintFileName().printFileName(file);
	}
	
	public void printFileName(File dir){
		if(dir!=null){
			File [] files = dir.listFiles();
			for(File file : files){
				if(file.isDirectory()){
					System.out.println("-------");
					printFileName(file);
					
				}else{
					System.out.println(file.getAbsolutePath());
				}
			}
		}
	}
}
