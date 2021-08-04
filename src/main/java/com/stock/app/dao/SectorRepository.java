package com.stock.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.app.model.SectorEntity;



public interface SectorRepository extends JpaRepository<SectorEntity, Integer>{
	
	public SectorEntity findBysector_name(String sector_name);
}