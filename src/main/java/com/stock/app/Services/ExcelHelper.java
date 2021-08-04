package com.stock.app.Services;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.stock.app.dao.StockExchangeDao;
import com.stock.app.model.StockPrice;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelHelper {

	
	private static  StockExchangeDao stockexchangedao;
	 @Autowired
	 private   StockExchangeDao stockexchangedao1 ;
	 
	 @PostConstruct 
	 void fun()
	 { stockexchangedao=this.stockexchangedao1;}

	 
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERS = { "companyCode", "stockExchange", "currentPrice", "date", "time" };

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<StockPrice> excelToStockPriceEntity(InputStream inputStream) throws RuntimeException {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = workbook.getSheetAt(0);
			
			List<StockPrice> stockPriceList = new ArrayList<>();
			
			for (int index = sheet.getFirstRowNum()+1; index < sheet.getPhysicalNumberOfRows()-1; index++) {
				if (index > 0) {
					StockPrice stockPriceEntity = new StockPrice();
				  
					XSSFRow row = sheet.getRow(index);
					
					Integer companyCode = (int)(row.getCell(0).getNumericCellValue());
					String stockExchange = row.getCell(1).getStringCellValue();
					double currentPrice = row.getCell(2).getNumericCellValue();
					LocalDate date = row.getCell(3).getLocalDateTimeCellValue().toLocalDate();
					LocalTime time = row.getCell(4).getLocalDateTimeCellValue().toLocalTime();
					
					stockPriceEntity.setCompanyCode(companyCode);
					stockPriceEntity.setStockExchange(stockExchange);
					stockPriceEntity.setCurrent_Price(currentPrice);
					stockPriceEntity.setDate(date);
					stockPriceEntity.setTime(time);
                     // stockPriceEntity.setStockExchangeent(stockexchangedao.getById(1));
					stockPriceList.add(stockPriceEntity);
				}
			}

			workbook.close();

			return stockPriceList;
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}

	}
}