package com.example.marketing.services;

import java.util.List;

import com.example.marketing.entites.Lead;

public interface LeadService {
	  public void saveLead(Lead lead);
	  public List<Lead> listLeads();
	  public void deleteLeadById(long id);
	  public Lead getOneLead(long id);
}