package com.interview.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.resource.MapParameters;
import com.interview.resource.MapProducts;
import com.interview.resource.Products;
import com.interview.services.ProductsService;

@RestController
public class GetProductsController {
	
	@Autowired
	private ProductsService service;
	
	@Autowired
	private MapParameters mapperParameters;
	
	@Autowired
	private MapProducts mapProducts;
	

	@GetMapping(path = "/product", produces = "application/json")
	public ResponseEntity<Products> getProducts(@RequestParam Map<String, String> requestParams) {
		Products products=mapProducts.map(service.retrieve(mapperParameters.map(requestParams)));
		return ResponseEntity.ok(products);
	}

}
