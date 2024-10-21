package com.cdac.acts.javamain;

import java.util.Comparator;

public class SortByName implements Comparator <Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o2.getName().compareTo(o1.getName());
	}

}
