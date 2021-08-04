package com.stock.app.model;
import java.sql.Timestamp;

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
@Table(name="IPO")
public class IPOEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IPOid;
	
	@Column(name="CompanyName")
	private String Company_Name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "StockExchangeid",insertable = true, updatable = true)
	@JsonIgnore
	private StockExchangeEntity stockExchange;
	
	@Column(name="PricePerShare")
	 private double Price_per_Share;
	
	@Column(name ="TotalnumberofShares")
	private long Total_Number_of_Shares;
	
	@Column(name ="OpenDateTime",nullable=false)
	private Timestamp openDateTime;
	
	 @Column
	 private String Remarks;
	 
	 
	 //relationship between ipos and company
 @ManyToOne(fetch = FetchType.LAZY, optional = true)
		@JoinColumn(name = "Companyid" ,insertable = true, updatable = true)
		@JsonIgnore
		private Company company;


public int getIPOid() {
	return IPOid;
}


public void setIPOid(int iPOid) {
	IPOid = iPOid;
}


public String getCompany_Name() {
	return Company_Name;
}


public void setCompany_Name(String company_Name) {
	Company_Name = company_Name;
}


public StockExchangeEntity getStockExchange() {
	return stockExchange;
}


public void setStockExchange(StockExchangeEntity stockExchange) {
	this.stockExchange = stockExchange;
}


public double getPrice_per_Share() {
	return Price_per_Share;
}


public void setPrice_per_Share(double price_per_Share) {
	Price_per_Share = price_per_Share;
}


public long getTotal_Number_of_Shares() {
	return Total_Number_of_Shares;
}


public void setTotal_Number_of_Shares(long total_Number_of_Shares) {
	Total_Number_of_Shares = total_Number_of_Shares;
}


public Timestamp getOpenDateTime() {
	return openDateTime;
}


public void setOpenDateTime(Timestamp openDateTime) {
	this.openDateTime = openDateTime;
}


public String getRemarks() {
	return Remarks;
}


public void setRemarks(String remarks) {
	Remarks = remarks;
}


public Company getCompany() {
	return company;
}


public void setCompany(Company company) {
	this.company = company;
}


public IPOEntity() {
	super();
	// TODO Auto-generated constructor stub
}
 

}
