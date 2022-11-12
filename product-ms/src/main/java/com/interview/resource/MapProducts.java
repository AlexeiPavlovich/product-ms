package com.interview.resource;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.interview.model.ProductDTO;
import com.interview.model.ProductsDTO;
import com.interview.services.ProductConstants;

@Service
public class MapProducts {
	private Function<String,String> getPropertyColor=color->String.format("%s%s%s",ProductConstants.COLOR,ProductConstants.PROPERTY_SPLIT_BY,color);
	private Function<String,String> getPropertyGb_limit=gb_limit->String.format("%s%s%s",ProductConstants.GB_LIMIT,ProductConstants.PROPERTY_SPLIT_BY,gb_limit);
	
	public Products map(ProductsDTO dto) {
		Products products = new Products();
		products.setData(dto.getData().stream().map(this::map).collect(Collectors.toList()));
		return products;
	}
	private Product map(ProductDTO dto) {
		Product product = new Product();
		product.setType(dto.getType());
		product.setStore_address(dto.getAddress());
		product.setPrice(dto.getPrice());
		product.setProperty((dto.getGb_limit()!=null) ? getPropertyGb_limit.apply(dto.getGb_limit().toString().replaceAll("\\.?0*$", "")) : getPropertyColor.apply(dto.getColor())) ;
		return product;
	}

}
