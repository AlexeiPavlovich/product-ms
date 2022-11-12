package com.interview.model;

public class Parameters {
	private String type;
	private Float min_price;
	private Float max_price;
	private String city;
	private String color;
	private Float gb_limit;		
	private Float gb_limit_min; 
	private Float gb_limit_max; 
	
	public Parameters() {

	}	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getMin_price() {
		return min_price;
	}

	public void setMin_price(Float min_price) {
		this.min_price = min_price;
	}

	public Float getMax_price() {
		return max_price;
	}

	public void setMax_price(Float max_price) {
		this.max_price = max_price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Float getGb_limit() {
		return gb_limit;
	}

	public void setGb_limit(Float gb_limit) {
		this.gb_limit = gb_limit;
	}
	public Float getGb_limit_min() {
		return gb_limit_min;
	}

	public void setGb_limit_min(Float gb_limit_min) {
		this.gb_limit_min = gb_limit_min;
	}

	public Float getGb_limit_max() {
		return gb_limit_max;
	}

	public void setGb_limit_max(Float gb_limit_max) {
		this.gb_limit_max = gb_limit_max;
	}
	
}
