package com.stock.app.Controller;

import java.awt.print.Pageable;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Optional;
import com.google.inject.spi.Message;
import com.stock.app.Services.IpoService;
import com.stock.app.dao.CompanyRepository;
import com.stock.app.dao.IpoDao;
import com.stock.app.dao.IpoRepository;
import com.stock.app.model.Company;
import com.stock.app.model.IPOEntity;
import com.stock.app.model.Role;
import com.stock.app.model.SectorEntity;
import com.stock.app.model.UserEntity;
import com.stock.app.model.UserRole;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@RestController
@RequestMapping("/ipo")
@CrossOrigin(origins = "http://localhost:3000")
public class IpoController {
	@Autowired
	IpoService iposervice;
	
	@Autowired
	IpoRepository ipo;
	
	
	@Autowired
	CompanyRepository companyrepository;

	
	@RequestMapping
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("normal/ipo");
	    return modelAndView;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPOEntity>> ipolist()
	{ 
		
		return new ResponseEntity<List<IPOEntity>>(iposervice.getAllIpo(),HttpStatus.OK);

	}
	
    @PostMapping("/addipo")
	public ResponseEntity<String> addIpo(
	@RequestBody IPOEntity ipoentity)
	{      
	            
	iposervice.addIpo(ipoentity);
	return  new ResponseEntity<String>("IPO is added of "+ipoentity.getCompany_Name(), HttpStatus.OK); 
	

	}
    
    @GetMapping("/viewcompany/{page}")
    public String showCompany(@PathVariable("page") Integer page,Model model)
    {
    model.addAttribute("title","View Company");

    Pageable pg = (Pageable) PageRequest.of(page, 4);

    Page<Company> companylist = this.companyrepository.findallCompany(pg);
    model.addAttribute("companylist",companylist);
    model.addAttribute("currentpage",page);
    model.addAttribute("totalpages",companylist.getTotalPages());
    return "admin/viewcompany";
    }

    @GetMapping("/company/{companyId}")
    public String showCompanyDetail(@PathVariable("companyId") Integer companyId,Model model){

    System.out.println("CID "+companyId);
    java.util.Optional<Company> companydet = this.companyrepository.findById(companyId);
    Company companyEntity = companydet.get();
    SectorEntity sector = companyEntity.getSector();
    model.addAttribute("company", companyEntity);
    model.addAttribute("sector",sector);
    return "admin/companydetail";
    }

    @GetMapping("/deletecompany/{companyId}")
    public String deletecompany(@PathVariable("companyId") Integer companyId,HttpSession session){

    System.out.println("CID "+companyId);
    java.util.Optional<Company> companydet = this.companyrepository.findById(companyId);
    Company companyEntity = companydet.get();
    try {
    companyEntity.setSector(null);
    this.companyrepository.delete(companyEntity);
    session.setAttribute("message", new Message("Contact Deleted Successfully","alert-success"));
    } catch (Exception e) {
    // TODO: handle exception
    session.setAttribute("message", new Message(" Failed to delete Contact","alert-danger"));
    }

    return "redirect:/admin/viewcompany/0";
    }

    @PostMapping("/updatecompany/{companyId}")
    public String updatecompany(@PathVariable("companyId") Integer companyId,HttpSession session,Model model)
    {
    model.addAttribute("title","Update Company");
    Company companyEntity = this.companyrepository.findById(companyId).get();
    model.addAttribute("company",companyEntity);
    return "admin/updatecompany";

    }
    
	
	
		
		
}
