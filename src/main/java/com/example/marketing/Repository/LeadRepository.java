package com.example.marketing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marketing.entites.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
