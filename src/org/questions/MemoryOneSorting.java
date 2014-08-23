package org.questions;

import java.util.HashSet;
import java.util.Set;

public class MemoryOneSorting {

	public static void main(String[] args) {
		Set<Integer> data = new HashSet<Integer>();
		while(data.size() < 100){
			data.add(new Integer((int) (Math.random() * 100)));
		}
		Integer[] array = data.toArray(new Integer[data.size()]);
		Integer temp = 0;
		for(int i=0; i< 100;i++){
			if(array[i] != i){
				temp = array[array[i]];
				array[array[i]] = array[i];
				array[i] = temp;
			}
		}
		
		for(Integer i : array){
			System.out.println(i);
		}
		
	}

}
