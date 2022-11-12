package com.interview.model;

import org.springframework.stereotype.Service;

@Service
public class Factory {

	public ProductDTO getProductDTO() {
		return new ProductDTO();
	}

	public ProductsDTO getProductsDTO() {
		return new ProductsDTO();
	}

	public Parameters getParameters() {
		return new Parameters();
	}
}
