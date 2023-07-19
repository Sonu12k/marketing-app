package com.example.marketing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.marketing.Dto.LeadData;
import com.example.marketing.entites.Lead;
import com.example.marketing.services.LeadService;

@Controller
public class LeadController { //it is just like servlet
	
//	@Autowired
//	private Emailservices emailService;
	
	@Autowired
	private LeadService leadService;
	
	
	//Handler Method
	//http://localhost:8080/createLead
	@RequestMapping("/createLead")
	public String viewCreateLeadPage(){ //handler method return type is String and it is a special method
		return "create_lead"; 
	}
	
	//this is the first way to read the form data
//	@RequestMapping("/saveLead")//1st option to read form data
//	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {		leadService.saveLead(lead);  
//		model.addAttribute("msg", "Lead is saved!!");
//		
////		System.out.println(lead.getFirstName());
////		System.out.println(lead.getLastName());
////		System.out.println(lead.getEmail());
////		System.out.println(lead.getMobile());
//		
//		model.addAttribute("msg", "Lead is saved!!");
//		return "create_lead";
//		
//	}
	
//	@RequestMapping("/saveLead")    //2nd Way to read form data
//	public String saveOneLead(@RequestParam("name") String fName,@RequestParam("lastName") String lName,
//		@RequestParam("emailId") String email,@RequestParam("mobileNumber") long mobile) {
//			
//		System.out.println(fName);//Reading the data using @Requestpara concept, it is reads the form data
//		                         //and initializesthe method argument.
//		System.out.println(lName);
//		System.out.println(email);
//		System.out.println(mobile);
		//Store and db we required entity class
		
//		Lead l = new Lead();
//		l.setFirstName(fName);
//		l.setLastName(lName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		
//		leadService.saveLead(l);
//	
//		return "create_lead";
//	}	
	
		//3rd way to read form data
		
       //DTO - Data Transfer Object		
//		@RequestMapping("/saveLead")//1st option to read form data
//		public String saveOneLead(LeadData data, ModelMap model) {
	
//			System.out.println(data.getFirstName());
//			System.out.println(data.getLastName());
//			System.out.println(data.getEmail());
//			System.out.println(data.getMobile());
//			System.out.println("Done");
			
//			Lead lead = new Lead();//save it data in db we require lead object
//			lead.setFirstName(data.getFirstName());
//			lead.setLastName(data.getLastName());
//			lead.setEmail(data.getEmail());
//			lead.setMobile(data.getMobile());
//			leadService.saveLead(lead);
//			
//			model.addAttribute("msg", "Lead is saved!!");
//			
//			return "create_lead";

	
			@RequestMapping("/saveLead")//1st option to read form data
			public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
				leadService.saveLead(lead);  
	//	emailService.sendSimpleEmail(lead.getEmail(),"Welcome","We have receved inquiry");
				
				model.addAttribute("msg", "Lead is saved!!");
				return "create_lead";
					
				}
				  
			//http://localhost:8080/listall
			@RequestMapping("/listall") 
			public String listAllLeads(ModelMap model) {
				List<Lead> leads = leadService.listLeads();
				//System.out.println(leads);
				model.addAttribute("leads", leads);
				return "lead_search_result";
				
                }
				@RequestMapping("/delete")
				public String deleteOneLead(@RequestParam("id") long id,ModelMap model) {
					
					leadService.deleteLeadById(id);
					
					List<Lead> leads = leadService.listLeads();
					model.addAttribute("leads", leads);
					return "lead_search_result";
				}

	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	@RequestMapping("/updateLead")
	public String updateOneLeadData(LeadData data, ModelMap model)  {
		Lead lead = new Lead();
		
//		System.out.println(data.getId());
//		System.out.println(data.getFirstName());
//		System.out.println(data.getLastName());
//		System.out.println(data.getEmail());
//		System.out.println(data.getMobile());
//		return "";
		
		lead.setId(data.getId());
		lead.setFirstName(data.getFirstName());
		lead.setLastName(data.getLastName());
		lead.setEmail(data.getEmail());
		lead.setMobile(data.getMobile());
		
		
        leadService.saveLead(lead);
		
		List<Lead> leads = leadService.listLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
	
}
