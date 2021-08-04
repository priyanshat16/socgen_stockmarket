package com.stock.app.Services;

import java.util.List;


import com.stock.app.model.Company;
import com.stock.app.model.StockExchangeEntity;

public interface StockExchangeService {
	List<StockExchangeEntity>getall();
   void addStockExchange(StockExchangeEntity stockexchangeentity);
    List<Company>getallcompany();
}
