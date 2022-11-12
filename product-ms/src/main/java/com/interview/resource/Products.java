package com.interview.resource;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private List<Product> data=new ArrayList<>();
	
	public Products() {

	}
	
	public List<Product> getData() {
		return data;
	}

	public void setData(List<Product> data) {
		this.data = data;
	}
	
	public void add(Product product) {
		data.add(product);
	}
}
