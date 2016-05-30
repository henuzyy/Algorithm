package com.zyy.offer;


import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author:zyy
 * @�㷨����:������ջʵ��һ������
 * @����˼·:</br>
 * 
 */
public class Seven <T> {

	private Stack<T> one = new Stack<T>();
	
	private Stack<T> two = new Stack<T>();
	
	private boolean flag = true;  //true����Ŀǰһ��
	
	private int size = 0;
	
	public int size(){
		return this.size;
	}
	
	/**
	 * ��һ�Ž������ų�
	 * */
	public synchronized  void push(T t){
		if(!flag){
			while(two.size()>0){
				one.push(two.pop());
			}
			flag = true;
		}
		one.push(t);
		this.size++;
		System.out.println("��ǰʣ��=" + this.size  + "������" +  t +	this.flag);
	}
	
	public synchronized T  pop(){
		if(flag){
			while(one.size()>0){
				two.push(one.pop());
			}
			flag = false;
		}
		if(two.size()>0){
			T temp  = two.pop();
			this.size--;
			System.out.println("��ǰʣ��=" + this.size  + "��ȥ��" +  temp + this.flag);
			return temp;	
		}else{
			return null;
		}

	}
	
	//--------------------------------------------------------
	
	public synchronized void push1(T t){
		this.one.push(t);
		this.size++;
	}
	
	public synchronized T  pop1(){
		if(this.two.size()<=0){ //������û�У��ӽ���������
			if(this.one.size()<=0){
				throw new RuntimeException("����Ϊ�գ�");
			}
			while(this.one.size()>0){
				this.two.push(this.one.pop());
			}
		}
		this.size--;
		return this.two.pop();
		
	}
	
	public static void main(String[] args) {
		Seven<String> item = new Seven<String>();
		item.push1("1");
		item.push1("2");
		item.push1("3");
		item.pop1();
		item.push1("4");
		item.pop1();
		item.push1("5");
		System.out.println("-------------" + item.size);
		int size = item.size();
		for(int i=0;i<size;i++)
		System.out.println(item.pop1());
		
		
		
		
		
	}
	
	
	
}
