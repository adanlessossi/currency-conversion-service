/**
 * 
 */
package com.businessdecision.microservices.currencyconversionservice.domain;

import java.math.BigDecimal;

/**
 * @author bernard.adanlessossi
 *
 */
public class CurrencyConversionBean {

	private Long id;

	private String currencyfrom;

	private String currencyto;

	private BigDecimal conversionMultiple;

	private BigDecimal amount;

	private BigDecimal calculatedAmount;

	private int port;

	/**
	 * 
	 */
	public CurrencyConversionBean() {
		super();
	}

	/**
	 * @param id
	 * @param from
	 * @param to
	 * @param conversionMultiple
	 * @param amount
	 * @param calculatedAmount
	 * @param port
	 */
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal amount,
			BigDecimal calculatedAmount, int port) {
		super();
		this.id = id;
		this.currencyfrom = from;
		this.currencyto = to;
		this.conversionMultiple = conversionMultiple;
		this.amount = amount;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the from
	 */
	public String getCurrencyfrom() {
		return currencyfrom;
	}

	/**
	 * @param from the from to set
	 */
	public void setCurrencyfrom(String currencyfrom) {
		this.currencyfrom = currencyfrom;
	}

	/**
	 * @return the to
	 */
	public String getCurrencyTo() {
		return currencyto;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String currencyto) {
		this.currencyto = currencyto;
	}

	/**
	 * @return the conversionMultiple
	 */
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	/**
	 * @param conversionMultiple the conversionMultiple to set
	 */
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the calculatedAmount
	 */
	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	/**
	 * @param calculatedAmount the calculatedAmount to set
	 */
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

}
