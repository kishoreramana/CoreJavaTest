package com.kishore.first;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Sample {

	public static void main(String[] args) {
		
		Map<Integer, String> map1 = new Hashtable<Integer, String>();
		map1.put(8, "Kishore");
		
		map1.put(9, "Kishore");
		
		Collections.synchronizedMap(map1);
		
		Set<Integer> map1Keys = map1.keySet();
		
		for(Integer map1Key : map1Keys){
			System.out.println("Value for key : "+map1Key+" is : "+map1.get(map1Key));
		}
		
	}

}
