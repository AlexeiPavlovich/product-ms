package com.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.controller.GetProductsController;
import com.interview.resource.Product;
import com.interview.resource.Products;



@RunWith(SpringRunner.class)
@SpringBootTest()
public class RetrieveProductsTests {

	
	@Autowired
	private GetProductsController controller;
	
	@Test
	public void retrieveProducts() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("min_price", "300");
		parameters.put("max_price", "500");
		parameters.put("property.color", "brun");
		ResponseEntity<Products> products=controller.getProducts(parameters);
		assertTrue(products.getBody().getData().stream().map(Product::getPrice).min(Comparator.comparing(Float::valueOf)).get()>=300);
		assertTrue(products.getBody().getData().stream().map(Product::getPrice).max(Comparator.comparing(Float::valueOf)).get()<=500);
		assertThat(products.getBody().getData().stream().map(Product::getProperty).collect(Collectors.toList())).containsExactlyInAnyOrder("color:brun");
		
		parameters.put("property.color", null);
		parameters.put("city", "Stockholm");
		parameters.put("property:gb_limit_min", "50");
		products=controller.getProducts(parameters);
		List<String> addresses = products.getBody().getData().stream().map(Product::getStore_address).collect(Collectors.toList());
		List<String> properties =products.getBody().getData().stream().map(Product::getProperty).collect(Collectors.toList());
		assertTrue(addresses.stream().filter(addr->addr.contains("Stockholm")).count()>0);
		assertTrue(addresses.stream().filter(addr->!addr.contains("Stockholm")).count()==0);
		assertTrue(!properties.stream().filter("gb_limit:50"::equals).collect(Collectors.toList()).isEmpty());
		assertTrue(properties.stream().filter(prop->!"gb_limit:50".equals(prop)).collect(Collectors.toList()).isEmpty());


	}

}
