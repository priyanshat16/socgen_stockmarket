package com.stock.app.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table (name="StockPrice")

public class StockPrice {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int StorckPriceid;
	
	
	@Column(name=" StockExchange")
	private String StockExchange;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "StockExchangeid",insertable = true, updatable = false)
	
	@JsonIgnore
	private StockExchangeEntity stockExchangeent;
	
	 public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="CurrentPrice")
	private double Current_Price;
	 
	@Column
	private LocalDate date;
	
	@Column
	private LocalTime time;
	
	@Column
	private  int companyCode;

	public int getStorckPriceid() {
		return StorckPriceid;
	}

	public void setStorckPriceid(int storckPriceid) {
		StorckPriceid = storckPriceid;
	}

	public String getStockExchange() {
		return StockExchange;
	}

	public void setStockExchange(String stockExchange) {
		StockExchange = stockExchange;
	}

	public StockExchangeEntity getStockExchangeent() {
		return stockExchangeent;
	}

	public void setStockExchangeent(StockExchangeEntity stockExchangeent) {
		this.stockExchangeent = stockExchangeent;
	}

	public double getCurrent_Price() {
		return Current_Price;
	}

	public void setCurrent_Price(double current_Price) {
		Current_Price = current_Price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	
	

}
