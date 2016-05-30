package com.zyy.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
	
	
	public static void main(String[] args) {
		Map<String,Object> map1 = new HashMap<String,Object>();  //倒序迭代输出
		map1.put("key1", "value1");
		map1.put("key2", "value2");
		map1.put("keydd", "value3");
		map1.put("key4", "value4");
		MapTest.testHashMap(map1);
		System.out.println("---------------------------------");
		Map<String,Object> map2 = new LinkedHashMap<String,Object>();  //倒序迭代输出
		map2.put("key1", "value1");
		map2.put("key2", "value2");
		map2.put("keydd", "value3");
		map2.put("key4", "value4");
		MapTest.testHashMap(map2);		
		System.out.println("---------------------------------");
		Map<String,Object> map3 = new TreeMap<String,Object>();  //按照Key生成的顺序迭代输出
		map3.put("keyff", "value1");
		map3.put("key2", "value2");
		map3.put("key3", "value3");
		map3.put("keydd", "value4");
		map3.put("key4", "value4");
		MapTest.testHashMap(map3);

		
		
		
	}
	

	public static void testHashMap(Map<String,Object> list){
		Set<Entry<String,Object>> sets = list.entrySet();
		for(Entry<String,Object> item:sets){
			System.out.println("key=" +  item.getKey() + ",value=" + item.getValue());
		}
	}
	
}
