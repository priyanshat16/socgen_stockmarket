package com.stock.app.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.app.dao.CompanyRepository;
import com.stock.app.dao.SectorRepository;
import com.stock.app.model.Company;
import com.stock.app.model.SectorEntity;


@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private SectorRepository sectorRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	@Override
	public Company createCompany(Company company, String sectorname) {
		SectorEntity sector = this.sectorRepository.findBysector_name(sectorname);
		company.setSector(sector);
		Company companyEntity = this.companyRepository.save(company);
		return companyEntity;
	}

	public Company updatecompany(Company companyEntity, Company company, String sectorname) {
		 companyEntity.setCompany_Name(company.getCompany_Name());
		 companyEntity.setTurnover(company.getTurnover());
		 companyEntity.setCEO(company.getCEO());
		 companyEntity.setBoard_of_Directors(company.getBoard_of_Directors());
		 companyEntity.setWrite_Up(company.getWrite_Up());
		 
		SectorEntity sector = this.sectorRepository.findBysector_name(sectorname);
		companyEntity.setSector(sector);
		
		Company companyEntity2 = this.companyRepository.save(companyEntity);
		return companyEntity2;
	}

}

/*import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dao.CompanyDao;
import com.stock.app.dao.SectorDao;
import com.stock.app.model.Company;

import javassist.NotFoundException;




@Service
public class CompanyServiceImpl implements CompanyService {
   
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private SectorDao sectordao;
  
	@Override
	public Company findCompanyById(Integer Companyid) {
		
		Optional<Company> companycheck = companyDao.findById(Companyid);
		if(companycheck.isPresent())return companycheck.get();
		else  //return new CompanyEntity();
			throw new NotFoundException("Company not found" + Companyid);
	
		
		
	}

	@Override
	public List<Company> findAllCompany() {
		//TODO Auto-generated method stub
		return companyDao.findAll();
	
	}

	@Override
	public void deleteById(Integer companyId) {
		companyDao.deleteById(companyId);
		
	}

	

	@Override
	public void addCompany(Company companyentity) {
		Company ent= companyDao.save(companyentity);
	}

	@Override
	public void updateCompany(Company companyentity, Integer companyid) {
		Company compent=companyDao.getById(companyid);
		compent.setCompany_Name(companyentity.getCompany_Name());
		compent.setCEO(companyentity.getCEO());
		compent.setTurnover(companyentity.getTurnover());
		compent.setCompanyid(companyentity.getCompanyid());
		compent.setWrite_Up(companyentity.getWrite_Up());
		compent.setSector(sectordao.getById(1));
		companyDao.save(compent);
	}
	

}*/