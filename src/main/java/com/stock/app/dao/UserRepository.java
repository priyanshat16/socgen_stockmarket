package com.stock.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.model.Company;
import com.stock.app.model.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity , Integer>{

	
	public UserEntity findByUsername(String username);
	
	
}