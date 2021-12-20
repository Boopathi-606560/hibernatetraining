package com.example.incedohibernatetraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.incedohibernatetraining.entity.AccountsEntity;
import com.example.incedohibernatetraining.exception.AccountNotFoundException;
import com.example.incedohibernatetraining.model.AccountInfo;
import com.example.incedohibernatetraining.service.IncedoHibernateTrainingService;

/*
 * Author : boopathi ramasamy 
 * Incedo hibernate training project
 * 
 */

@RestController
public class IncedoHibernateTraningController {
	
	@Autowired
	private IncedoHibernateTrainingService incedoHibernateTrainingService;
	
	/*
	 * registerCustomerDtls method is used to register account information
	 */
	@PostMapping("/registerCustomerDtls")
	public ResponseEntity<String>  registerCustomerDtls( @RequestBody AccountInfo accountInfo) {

		boolean isCreated = incedoHibernateTrainingService.registerCustomerDtls(accountInfo);
		    return isCreated ? ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered" )
		    		           :ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Registeration Failed" );
	}
	
	/*
	 * getCustomerAccountdtls method is used to get account information
	 */
	
	@GetMapping("/getCustomerAccountdtls")
	public ResponseEntity<String> getCustomerAccountdtls() {
		
	 List<AccountsEntity> accounts = incedoHibernateTrainingService.getCustomerAccountdtls() ;  
	 return ResponseEntity.status(HttpStatus.OK)
     .body("Account Details" + accounts );
	 
	}
	
	/*
	 *updateCustomerAccount  method is used to update the account information 
	 */
	@PutMapping("/updateCustomerAccount")
	public ResponseEntity<String> updateCustomerAccount(@RequestBody AccountInfo accountInfo ) throws AccountNotFoundException {
		boolean isUpdated =false;
		String errMsg= null;
		try {
		 isUpdated = incedoHibernateTrainingService.saveOrUpdate(accountInfo) ;
		}
		
		catch ( AccountNotFoundException ex) {
			errMsg=ex.getMessage();
		}
		 return isUpdated ? ResponseEntity.status(HttpStatus.OK)
		        .body(" Updated Successfully " ):
		        	ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
			        .body("Update Failed due to " + errMsg );
	}
	
	/*
	 * deleteCustomerAccount method is used to delete the account information
	 */
	
	@DeleteMapping("/deleteCustomerAccount/{contactno}")
	public ResponseEntity<String> deleteCustomerAccount(@PathVariable("contactno") Integer contactno ) throws AccountNotFoundException {
		
		boolean isDeleted =false;
		String errMsg= null;
		try {
		 isDeleted = incedoHibernateTrainingService.deleteCustomerAccount(contactno);
		}
		catch ( AccountNotFoundException ex) {
			errMsg=ex.getMessage();
		}
		return isDeleted ? ResponseEntity.status(HttpStatus.OK)
		        .body(" Deleted Successfully " + contactno ):
		        	ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
			        .body("Delete Failed due to " + errMsg );
		
	}

}
