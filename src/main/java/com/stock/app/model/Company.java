package com.stock.app.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="company")
public class Company {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Companyid;
	
	@Column(name ="CompanyName")
	private String CompanyName; 
	
	@Column
	private int Turnover;
	
	@Column(name="CEO")
	private String CEO;
	
	@Column(name =" BoardofDirector")
	private String Board_of_Directors;


	@Column(name="WriteUp")
	private String Write_Up;


	
	//Relationships company and ipos
	@OneToMany(mappedBy="company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IPOEntity> ipos;
	
	
	//relationship between sectors and company
		@ManyToOne(fetch = FetchType.LAZY)
		 @JsonBackReference
		//@JoinColumn
	    //@JsonIgnore
		private SectorEntity sector;

	

   @ManyToMany
	@JoinTable(
			  name = "company_stockexchange", 
			  joinColumns = @JoinColumn(name = "companyid"), 
			  inverseJoinColumns = @JoinColumn(name = "stockexchangeid"))
   List<StockExchangeEntity> StockExchangeList;



public Company() {
	super();
	// TODO Auto-generated constructor stub
}



public int getCompanyid() {
	return Companyid;
}



public void setCompanyid(int companyid) {
	Companyid = companyid;
}



public String getCompany_Name() {
	return CompanyName;
}



public void setCompany_Name(String company_Name) {
	this.CompanyName = company_Name;
}



public int getTurnover() {
	return Turnover;
}



public void setTurnover(int turnover) {
	Turnover = turnover;
}



public String getCEO() {
	return CEO;
}



public void setCEO(String cEO) {
	CEO = cEO;
}



public String getBoard_of_Directors() {
	return Board_of_Directors;
}



public void setBoard_of_Directors(String board_of_Directors) {
	Board_of_Directors = board_of_Directors;
}



public String getWrite_Up() {
	return Write_Up;
}



public void setWrite_Up(String write_Up) {
	Write_Up = write_Up;
}



public List<IPOEntity> getIpos() {
	return ipos;
}



public void setIpos(List<IPOEntity> ipos) {
	this.ipos = ipos;
}



public SectorEntity getSector() {
	return sector;
}



public void setSector(SectorEntity sector) {
	this.sector = sector;
}



public List<StockExchangeEntity> getStockExchangeList() {
	return StockExchangeList;
}



public void setStockExchangeList(List<StockExchangeEntity> stockExchangeList) {
	StockExchangeList = stockExchangeList;
}





}
