package com.stock.app.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.app.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	@Query(value="SELECT * FROM Company",nativeQuery = true)
	public Page<Company> findallCompany(Pageable pePageable);
	@Query(value="SELECT * FROM Company WHERE company_name = ?1",nativeQuery = true)
	public Company findBycompany_name(String company_name);
}
