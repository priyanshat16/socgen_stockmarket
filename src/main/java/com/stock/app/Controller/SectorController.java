package com.stock.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.app.Services.SectorService;
import com.stock.app.model.SectorEntity;


@RestController
@RequestMapping("/sector")
@CrossOrigin(origins = "http://localhost:3000")
public class SectorController {
	@Autowired  
	SectorService sectorservice;
	  
	  
	  @GetMapping("/all")
		public ResponseEntity<List<SectorEntity>> sectorlist()
		{
			return new ResponseEntity<List<SectorEntity>>(sectorservice.getAllSector(),HttpStatus.OK);
			
		}
	  
	  
	  @GetMapping("/{sectorid}")
		public ResponseEntity<SectorEntity> sectorbyId(@PathVariable("sectorid") Integer sectorid)
		{
			return new ResponseEntity<SectorEntity>((SectorEntity) sectorservice.getSectorById(sectorid),HttpStatus.OK);

	   }
    


       @PostMapping("/addSector")
       public ResponseEntity<String> addSector(@PathVariable("sectorname")String sectorname,
		@RequestBody SectorEntity sectorentity)
       {      
       
       sectorservice.addsector(sectorentity);


       return  new ResponseEntity<String>("Sector is added", HttpStatus.OK); 


       }
       
       
       
       
}
