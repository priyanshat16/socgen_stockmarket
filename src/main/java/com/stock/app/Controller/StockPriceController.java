package com.stock.app.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stock.app.Services.ExcelHelper;
import com.stock.app.Services.StockPriceService;
import com.stock.app.dao.StockPriceDao;
import com.stock.app.model.StockPrice;



@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:3000")
public class StockPriceController {

	@Autowired
	private StockPriceService stockpriceservice;
	@Autowired
	private StockPriceDao stockpricedao;
	
	
	@GetMapping("/{companyid}/{stockexchange}/{in}/{out}")
	 public  ResponseEntity<List<StockPrice>> getallstocks(@PathVariable("companyid") int companyid, @PathVariable("stockexchange") String stockexchangename ,@PathVariable("in")
			 Date in ,@PathVariable("out") Date out)
	 {
		 
		 return   new ResponseEntity<List<StockPrice>>(stockpricedao.allStockPrice(companyid, stockexchangename, in, out),HttpStatus.OK);
		 
		
		 
	 }
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (ExcelHelper.hasExcelFormat(file)) {

			stockpriceservice.save(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(message);

		}

		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	
}
