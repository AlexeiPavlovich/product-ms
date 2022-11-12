package com.interview.services;

import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.model.Factory;
import com.interview.model.Parameters;
import com.interview.model.ProductDTO;
import com.interview.model.ProductsDTO;
import com.interview.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private Factory factory;

	@Autowired
	private ProductsRepository repository;
		
	private BiPredicate<ProductDTO,Parameters> isType=(p,parameters)->parameters.getType()==null || parameters.getType().trim().equalsIgnoreCase(p.getType());
	private BiPredicate<ProductDTO,Parameters> isMinPrice=(p,parameters)->parameters.getMin_price()==null || p.getPrice()!=null && p.getPrice() >= parameters.getMin_price();
	private BiPredicate<ProductDTO,Parameters> isMaxPrice=(p,parameters)->parameters.getMax_price()==null ||  p.getPrice()!=null && p.getPrice() <= parameters.getMax_price();
	private BiPredicate<ProductDTO,Parameters> isCity=(p,parameters)->parameters.getCity()==null || p.getAddress()!=null&&p.getAddress().contains(parameters.getCity());
	private BiPredicate<ProductDTO,Parameters> isColor=(p,parameters)->parameters.getColor()==null || parameters.getColor().equalsIgnoreCase(p.getColor());
	private BiPredicate<ProductDTO,Parameters> isGb_limit=(p,parameters)->parameters.getGb_limit()==null || parameters.getGb_limit().equals(p.getGb_limit());
	private BiPredicate<ProductDTO,Parameters> isPropertyGBColorMin=(p,parameters)->parameters.getGb_limit_min()==null || p.getGb_limit()!=null && p.getGb_limit() >= parameters.getGb_limit_min();
	private BiPredicate<ProductDTO,Parameters> isPropertyGBColorMax=(p,parameters)->parameters.getGb_limit_max()==null ||  p.getGb_limit()!=null && p.getGb_limit() <= parameters.getGb_limit_max();

	public ProductsDTO retrieve(Parameters parameters) {
		ProductsDTO data = repository.getData();
		ProductsDTO products = factory.getProductsDTO();
		products.setData(data.getData().stream().filter(product -> filter(product, parameters)).collect(Collectors.toList()));
		return products;
	}

	private boolean filter(ProductDTO product, Parameters parameters) {
		return isType.test(product,parameters) && isMinPrice.test(product,parameters) && isMaxPrice.test(product,parameters)
				&& isCity.test(product,parameters) && isColor.test(product,parameters) && isGb_limit.test(product,parameters)
				&& isPropertyGBColorMin.test(product,parameters) && isPropertyGBColorMax.test(product,parameters);
	}
}
