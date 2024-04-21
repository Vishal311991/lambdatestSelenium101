package com.lenskart.testCases;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Multiset.Entry;

public class testing {

	public static void main(String[] arg) {
		
		// [4, 1, 3, 4, 3, 1, 3, 2, 3, 3, 3, 8, 7]
		
		List lt = new ArrayList();
		
		lt.add(4);
		lt.add(1);
		lt.add(3);
		lt.add(4);
		lt.add(3);
		lt.add(1);
		lt.add(3);
		lt.add(2);
		lt.add(3);
		
		for (Object c: lt) {
			
			Map <Object, Integer> countMap = new HashMap<Object, Integer>();
			
			if(countMap.get(c)>1) {
				
				countMap.put(c, countMap.get(c)+1);
			
			}else {
				countMap.put(c,1);
				
			}
			
			
			System.out.println(countMap);
			}
		}
		
		
		
		
		
		
	}
	
		
