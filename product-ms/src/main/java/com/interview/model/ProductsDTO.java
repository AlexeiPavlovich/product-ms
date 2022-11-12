package com.interview.model;

import java.util.ArrayList;
import java.util.List;

public class ProductsDTO {
	private List<ProductDTO> data=new ArrayList<>();
	
	public ProductsDTO() {

	}
	
	public List<ProductDTO> getData() {
		return data;
	}

	public void setData(List<ProductDTO> data) {
		this.data = data;
	}
	
	public void add(ProductDTO product) {
		data.add(product);
	}
}
