/**
 * 
 */
package com.businessdecision.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.businessdecision.microservices.currencyconversionservice.domain.CurrencyConversionBean;
import com.businessdecision.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

/**
 * @author bernard.adanlessossi
 *
 */
@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{currencyfrom}/to/{currencyto}/amount/{amount}")
	public CurrencyConversionBean convertCurrency(@PathVariable String currencyfrom, @PathVariable String currencyto,
			@PathVariable BigDecimal amount) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", currencyfrom);
		uriVariables.put("to", currencyto);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), currencyfrom, currencyto, response.getConversionMultiple(),
				amount, amount.multiply(response.getConversionMultiple()), response.getPort());
	}

	@GetMapping("/currency-converter-feign/from/{currencyfrom}/to/{currencyto}/amount/{amount}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String currencyfrom, @PathVariable String currencyto,
			@PathVariable BigDecimal amount) {
		
		CurrencyConversionBean response = proxy.getExchangeValue(currencyfrom, currencyto);
		
		return new CurrencyConversionBean(response.getId(), currencyfrom, currencyto, response.getConversionMultiple(),
				amount, amount.multiply(response.getConversionMultiple()), response.getPort());
	}
}
