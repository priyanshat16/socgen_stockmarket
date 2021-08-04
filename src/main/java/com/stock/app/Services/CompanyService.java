package com.stock.app.Services;

import java.util.List;

import com.stock.app.model.Company;


public interface CompanyService {

	public Company createCompany(Company company,String sectorname);
	public Company  updatecompany(Company companyEntity, Company company, String sectorname);
	
}
