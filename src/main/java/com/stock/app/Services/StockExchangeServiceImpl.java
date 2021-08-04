package com.stock.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dao.CompanyDao;
import com.stock.app.dao.CompanyRepository;
import com.stock.app.dao.StockExchangeDao;
import com.stock.app.model.Company;
import com.stock.app.model.StockExchangeEntity;


@Service
public class StockExchangeServiceImpl implements StockExchangeService {
  
	 @Autowired
	  private StockExchangeDao stockexchangedao;
	  @Autowired
	  private CompanyRepository companyrepository;
	
	 @Override
	 public List<StockExchangeEntity> getall() {
		return stockexchangedao.findAll();
	 }

   	 @Override
	 public void addStockExchange(StockExchangeEntity stockexchangeentity) {
	 StockExchangeEntity ent= stockexchangedao.save(stockexchangeentity);
		
	 }

	 @Override
	 public List<Company> getallcompany() {
		// TODO Auto-generated method stub
		return companyrepository.findAll();
	 }

}
