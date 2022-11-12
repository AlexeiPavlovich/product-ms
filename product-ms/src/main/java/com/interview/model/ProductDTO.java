package com.interview.model;

public class ProductDTO {

	private String type;
	private String color;
	private Float gb_limit;
	private Float price;
	private String address;

	public ProductDTO() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color=color;
	}
	
	public Float getGb_limit() {
		return gb_limit;
	}

	public void setGb_limit(Float gb_limit) {
		this.gb_limit=gb_limit;
	}
	
	


	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
