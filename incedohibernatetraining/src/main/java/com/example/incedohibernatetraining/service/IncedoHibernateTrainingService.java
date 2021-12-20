package com.example.incedohibernatetraining.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.incedohibernatetraining.entity.AccountsEntity;
import com.example.incedohibernatetraining.exception.AccountNotFoundException;
import com.example.incedohibernatetraining.model.AccountInfo;


/*
 * Author : boopathi ramasamy 
 * Incedo hibernate training project
 * 
 */

@Service
public interface IncedoHibernateTrainingService {
	
	public boolean registerCustomerDtls(AccountInfo accountInfo) ;
	
	public List<AccountsEntity> getCustomerAccountdtls() ;  
	
	public boolean saveOrUpdate(AccountInfo accountInfo) throws AccountNotFoundException ;
	
	public boolean deleteCustomerAccount(Integer contactno) throws AccountNotFoundException ;
	

}
