package com.interview.resource;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.interview.model.Factory;
import com.interview.model.Parameters;
import com.interview.services.ProductConstants;

@Service
public class MapParameters {
	
	@Autowired
	private Factory factory;
	
	private Function<String,Float> parseFloat= str->!StringUtils.isEmpty(str) ? Float.valueOf(str) : null;
	private BiFunction<String,String,String> extractProperty= (p1,p2) -> (p1!=null) ? p1 : p2;
	
	

	public Parameters map(Map<String, String> requestParams) {
		Parameters parameters = factory.getParameters();
		parameters.setType(requestParams.get(ProductConstants.TYPE));
		parameters.setMin_price(parseFloat.apply(requestParams.get(ProductConstants.MIN_PRICE)));
		parameters.setMax_price(parseFloat.apply(requestParams.get(ProductConstants.MAX_PRICE)));
		parameters.setCity(requestParams.get(ProductConstants.CITY));
		parameters.setColor(extractProperty.apply(requestParams.getOrDefault(ProductConstants.PROPERTY_COLOR,requestParams.get(ProductConstants.PROPERTY_COLOR2)),requestParams.get(ProductConstants.COLOR)));
		parameters.setGb_limit(parseFloat.apply(extractProperty.apply(requestParams.getOrDefault(ProductConstants.PROPERTY_GB_LIMIT,requestParams.get(ProductConstants.PROPERTY_GB_LIMIT2)),requestParams.get(ProductConstants.GB_LIMIT))));
		parameters.setGb_limit_min(parseFloat.apply(requestParams.getOrDefault(ProductConstants.PROPERTY_GB_LIMIT_MIN,requestParams.get(ProductConstants.PROPERTY_GB_LIMIT_MIN2))));
		parameters.setGb_limit_max(parseFloat.apply(requestParams.getOrDefault(ProductConstants.PROPERTY_GB_LIMIT_MAX,requestParams.get(ProductConstants.PROPERTY_GB_LIMIT_MIN2))));
		return parameters;
	}
}
