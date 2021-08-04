package com.stock.app.Services;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stock.app.model.StockPrice;


public interface StockPriceService {
 
	void save(MultipartFile file);

	List<StockPrice> allStockPrice(int Companycode, String exchangename, Date in, Date out);
}