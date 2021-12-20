package com.example.incedohibernatetraining.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * Author : boopathi ramasamy 
 * Incedo hibernate training project
 * 
 */

@Entity
@Data
@Table(name = "customer_detail_tble")
public class CustomerEntity {
	
	    @Id
	    @Column(name = "contact_no")
		private int contactNo;
	    
	    @Column(name = "bank_name")
		private String bankName;
		
		

		
}
