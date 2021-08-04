package com.stock.app.Services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stock.app.dao.StockPriceDao;
import com.stock.app.model.StockExchangeEntity;
import com.stock.app.model.StockPrice;


@Service
public class StockPriceServiceImpl  implements StockPriceService{

	@Autowired
	private StockPriceDao stockpricedao;
	
	@Autowired
	  private EntityManager entitymanager;
	
	@Override
    
	public List<StockPrice> allStockPrice(int Companycode, String exchangename, Date in, Date out) {
		// TODO Auto-generated method stub
		return stockpricedao.findAll();
	
	}
	@Override
	@Transactional
	public void save(MultipartFile file) throws RuntimeException{
		try {
			List<StockPrice> stockPriceList = ExcelHelper.excelToStockPriceEntity(file.getInputStream());
			//stockpricedao.saveAll(stockPriceList);
			for(StockPrice stockent:stockPriceList)
			{ String exch = stockent.getStockExchange();
				TypedQuery<StockExchangeEntity> q1 =   entitymanager.createQuery(" select c from StockExchangeEntity c where c.StockExchange =: name",StockExchangeEntity.class);
		        ((javax.persistence.Query) q1).setParameter("name", "BSE"); 
		 
		        StockExchangeEntity c =  (StockExchangeEntity) ((javax.persistence.Query) q1).getSingleResult();
				stockent.setStockExchangeent(c);
				
		        stockpricedao.save(stockent);
		        System.out.println(stockent.getStockExchangeent().getStockExchangenid());
		       
			}
			
			
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	

}
