package com.interview.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interview.model.Factory;
import com.interview.model.ProductDTO;
import com.interview.model.ProductsDTO;
import com.interview.services.ProductConstants;

@Repository
public class ProductsRepository {

	private ProductsDTO products;
	private Pattern pattern = Pattern.compile("\\s*(\"[^\"]*\"|[^,]*)\\s*");


	@Autowired
	private Factory factory;

	@PostConstruct
	public void init() throws IOException {
		products = factory.getProductsDTO();
		String line = "";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(ProductConstants.CSV_FILE)))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String type="";
				String prop="";
				String price="";
				String address="";
				Matcher matcher = pattern.matcher(line);
				int ind = 0;
				while (matcher.find()) {
					String str = matcher.group(1).trim().replaceAll("^\"|\"$", "");
					if (ind == 0) {
						type = str;
					} else if (ind == 2) {
						prop = str;
					} else if (ind == 4) {
						price = str;
					} else if (ind == 6) {
						address = str;
					}
					ind++;
				}
				
				
				ProductDTO product = factory.getProductDTO();
				product.setType(type.trim());
				String[] property=prop.trim().split(ProductConstants.PROPERTY_SPLIT_BY);
				if(property[0].equalsIgnoreCase(ProductConstants.COLOR)) {
					product.setColor(property[1]);
				}
				else if(property[0].equalsIgnoreCase(ProductConstants.GB_LIMIT)) {
					product.setGb_limit(Float.valueOf(property[1]));
				}
				product.setPrice(Float.valueOf(price.trim()));
				product.setAddress(address.trim());
				products.add(product);
			}
		} 

	}

	public ProductsDTO getData() {
		return products;
	}

}
