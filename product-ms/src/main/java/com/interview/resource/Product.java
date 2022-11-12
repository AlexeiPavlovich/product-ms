package com.interview.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Product {

	private String type;
	private Float price;
	private String store_address;
	private String property;

	public Product() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property=property;
	}
	@JsonSerialize(using = CustomPriceSerializer.class)
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String address) {
		this.store_address = address;
	}

}
