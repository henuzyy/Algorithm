package base.reflect;

import java.lang.reflect.Method;

public class ReflectObject {
	public static void main(String[] args) {
		
	}
	
	
	public <T> T reflcetObject(Class<T> clazz,T t){
		T result = null;
		try {
			result = clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();
			
			for(Method method : methods){
				if(method.getClass().getName().startsWith("set")){
//					method.invoke(result, args);
				}				
			}

			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void reflectObject(){
		Demo demo = new Demo(23,"zhangyangyang");
//		Class<T> clazz = demo.getClass();
		
		
		
		
		
	}
}


class Demo{
	private int id;
	
	private String name;

	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
