/**
 * 
 */
package com.businessdecision.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.businessdecision.microservices.currencyconversionservice.domain.CurrencyConversionBean;

/**
 * @author bernard.adanlessossi
 *
 */
//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
// @FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getExchangeValue(@PathVariable String from, @PathVariable String to);
}
