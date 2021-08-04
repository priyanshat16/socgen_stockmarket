package com.stock.app.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stock.app.model.IPOEntity;

public interface IpoRepository extends JpaRepository<IPOEntity, Integer>{
	
	@Query(value="SELECT * FROM IPO",nativeQuery = true)
	public Page<IPOEntity> findallIpos(Pageable pePageable);
	
	
}
