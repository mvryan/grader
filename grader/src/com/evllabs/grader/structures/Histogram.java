package com.evllabs.grader.structures;

import java.util.*;
import java.util.Map.Entry;

public class Histogram {
	
	private Map<String, Integer> histogram;
	
	private static Integer one = 1;
	
	private int total = 0;
	
	private int unique = 0;
	
	public Histogram(){
		histogram = new HashMap<String, Integer>();
	}
	
	public void add(String element){
		Integer value = histogram.get(element);
		if(value == null){
			histogram.put(element, one);
			unique++;
		} else {
			histogram.put(element, value+1);
		}
		total++;
	}
	
	public int get(String element){
		Integer value = histogram.get(element);
		if(value == null){
			return 0;
		}
		return value;
	}
	
	public Set<Entry<String, Integer>> entrySet(){
		return histogram.entrySet();
	}
	
	public int totalElements(){
		return total;
	}
	
	public int uniqueElements(){
		return unique;
	}
}
