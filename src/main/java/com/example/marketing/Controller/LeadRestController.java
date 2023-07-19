package com.example.marketing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.marketing.entites.Lead;
import com.example.marketing.services.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
   
	@Autowired
	private LeadService leadService;
	
	@GetMapping
	public List<Lead> getAllLeads(){
		  List<Lead> Leads = leadService.listLeads();
		  return Leads;
	}
	
	//how we record save the lead
	
	  @PostMapping  //http://localhost:8080/api/leads
	  public void saveOneLead(@RequestBody Lead lead) {
	  leadService.saveLead(lead); 
	  }
	
//	@PostMapping
//	public ResponseEntity<Lead> SaveLead(@RequestBody Lead lead) {
//		lead = leadService.saveLead(lead);
//		return new ResponseEntity<Lead>( HttpStatus.OK);
//	}
	 
	//for delete a record
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {

//		if(id==0) {
//			try {
//			
//				throw new Exception();
//			}catch(Exception e) {
//			 e.printStackTrace();	
//			}
//		}
//		
		leadService.deleteLeadById(id);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadService.saveLead(lead);
	}
	
	//After cretaing a Webservices we write this line
	@GetMapping("/leadinfo/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		Lead lead = leadService.getOneLead(id);
		return lead;
	}
}