package com.stock.app.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table

public class SectorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int sectorid;

	public int getSectorid() {
		return sectorid;
	}


	@Column(name="sector_name")
	private String sector_name;
	
	@Column
	private String Brief;
	

	@OneToMany(mappedBy="sector",targetEntity=Company.class )
	 @JsonManagedReference
	  @JsonIgnore  
	private List<Company> company;

	public String getSectorName() {
		return sector_name;
	}


	public void setSectorName(String sectorName) {
		this.sector_name = sectorName;
	}


	public String getBrief() {
		return Brief;
	}


	public void setBrief(String brief) {
		Brief = brief;
	}


	public List<Company> getCompany() {
		return company;
	}


	public void setCompany(List<Company> company) {
		this.company = company;
	}


	public void setSectorid(int Sectorid) {
		sectorid = Sectorid;
	}

}
