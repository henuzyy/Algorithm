package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author:zyy
 * @����: ������-������
 * 
 */
public class ProduceAndConsumer {
	public static void main(String[] args) {
		Product pro = new Product();
		Thread thread1 = new Thread(new Produce(pro),"thread1");
		Thread thread2 = new Thread(new Consumer(pro),"thread2");
		Thread thread3 = new Thread(new Produce(pro),"thread3");
		Thread thread4 = new Thread(new Consumer(pro),"thread4");
		ExecutorService servicePool = Executors.newCachedThreadPool();
		
		servicePool.execute(thread1);
		servicePool.execute(thread2);
		servicePool.execute(thread3);
		servicePool.execute(thread4);
//		
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();		
//		
		
	}
}


class Product {
	
	private int size ;  //��ǰ����
	
	private int MAX_SIZE = 10;  //�������
	
	/**
	 * ����
	 */
	public synchronized void get(){
		while(size<=0){
			System.out.println("û����Ʒ��Ϊ��");
			try {
				this.wait();  //��û�ж����������ѵĻ�����ǰ�̷߳���Product���������ֱ���б���̻߳��Ѹö�����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  --");
		}
		
		System.out.println("��ʼ����  --" + size--);
		//������֮�󣬾ͻ���֮ǰ�����ö��������̣߳�(ע�⣺ ��Ȼnotify()�����ˣ����Ǳ���Ҫ�ȵ���synchronized�ڵĴ����ִ�����)
		this.notify();  
	}
	
	/**
	 * ����
	 */
	public synchronized void add(){
		while(size>=MAX_SIZE){
			System.out.println("��Ʒ�Ѿ����ˣ����ܴ��");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("��ʼ���� --" + size++);  
		this.notify(); //�����ˣ�Ȼ��֮ǰ�����ö��������߳�
	}
	
}

class Produce implements Runnable{

	private Product product;

	public Produce(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		while(true){
			product.add();
		/*	try {
				TimeUnit.SECONDS.sleep(1);  //��������ʱ�䣬���Ը�ֱ�۵Ĺۿ����ѵ����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
}


class Consumer implements Runnable{

	private Product product;

	public Consumer(Product product) {
		super();
		this.product = product;
	}
	
	@Override
	public void run() {
		while(true){
			product.get();	
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
}
