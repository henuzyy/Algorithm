package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author:zyy
 * @名称: 生产者-消费者
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
	
	private int size ;  //当前容量
	
	private int MAX_SIZE = 10;  //最大容量
	
	/**
	 * 消费
	 */
	public synchronized void get(){
		while(size<=0){
			System.out.println("没有商品，为空");
			try {
				this.wait();  //当没有东西可以消费的话，当前线程放弃Product对象的锁，直到有别的线程唤醒该对象锁
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  --");
		}
		
		System.out.println("开始消费  --" + size--);
		//消费了之后，就唤醒之前放弃该对象锁的线程，(注意： 虽然notify()唤醒了，但是必须要等到该synchronized内的代码块执行完毕)
		this.notify();  
	}
	
	/**
	 * 生产
	 */
	public synchronized void add(){
		while(size>=MAX_SIZE){
			System.out.println("商品已经满了，不能存放");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("开始生产 --" + size++);  
		this.notify(); //生产了，然后之前放弃该对象锁的线程
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
				TimeUnit.SECONDS.sleep(1);  //这里设置时间，可以更直观的观看消费的情况
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
