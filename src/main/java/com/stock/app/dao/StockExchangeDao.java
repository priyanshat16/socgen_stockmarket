package com.stock.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.model.StockExchangeEntity;


@Repository
public interface StockExchangeDao extends JpaRepository<StockExchangeEntity, Integer>{

}