package com.example.incedohibernatetraining.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.incedohibernatetraining.dao.IncedoHibernateTrainingRepository;
import com.example.incedohibernatetraining.entity.AccountsEntity;
import com.example.incedohibernatetraining.exception.AccountNotFoundException;
import com.example.incedohibernatetraining.model.AccountInfo;
import com.example.incedohibernatetraining.service.IncedoHibernateTrainingService;

/*
 * Author : boopathi ramasamy 
 * Incedo hibernate training project
 * 
 */


@Component
public class IncedoHibernateTrainingServiceImpl implements IncedoHibernateTrainingService {
	
	@Autowired
	private IncedoHibernateTrainingRepository incedoHibernateTrainingRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
/*
 * registerCustomerDtls method is used to create record
 */
	@Transactional
	public boolean registerCustomerDtls(AccountInfo accountInfo) {
		
		try {
		System.out.println("Entering into the service...");
		System.out.println("Account Info..........." + accountInfo.toString());
		AccountsEntity accountsEntity = new AccountsEntity();
		accountsEntity.setContactNo(Integer.parseInt(accountInfo.getContactno()));
		accountsEntity.setAccountno(accountInfo.getAccountno());
		accountsEntity.setBankName(accountInfo.getBankName());
		accountsEntity.setCustomerid(accountInfo.getCustomerid());
		incedoHibernateTrainingRepository.save(accountsEntity);
		return true;
		}
		 catch (Exception e) {
			 System.out.println("Something went wrong.");
			 return false;
			 
		 }
		}
	
	/*
	 * getCustomerAccountdtls is used to fetch all account information
	 */
	
	public List<AccountsEntity> getCustomerAccountdtls() 
	{  
	List<AccountsEntity> accounts = new ArrayList<AccountsEntity>();  
	incedoHibernateTrainingRepository.findAll().
	forEach(account -> accounts.add(account));  
	return accounts;  
	} 
	
	/*
	 * saveOrUpdate is ued to update the record
	 */
	
	@Transactional
    public boolean saveOrUpdate(AccountInfo accountInfo) throws AccountNotFoundException {
		
		try {
		AccountsEntity accountsEntity = new AccountsEntity();
		Optional<AccountsEntity> optionaccountsEntity = incedoHibernateTrainingRepository.findById(Integer.parseInt(accountInfo.getContactno()));
		if(optionaccountsEntity.isPresent()) {
		accountsEntity= optionaccountsEntity.get();
		accountsEntity.setAccountno(accountInfo.getAccountno());
		accountsEntity.setBankName(accountInfo.getBankName());
		accountsEntity.setCustomerid(accountInfo.getCustomerid());
		entityManager.persist(accountsEntity);
		return true;
		}
		}
	
		 catch (Exception e) {
			 System.out.println(e.getMessage());
			 return false;
			 
		 }
		return false;
		}


	/*
	 * deleteCustomerAccount is used to delete the record
	 */
	@Transactional
	public boolean deleteCustomerAccount( Integer contactno) throws AccountNotFoundException {
		Optional<AccountsEntity> optionaccountsEntity = incedoHibernateTrainingRepository.findById(contactno);
		if(optionaccountsEntity.isPresent()) {
	   incedoHibernateTrainingRepository.deleteById(contactno);
	    return true;
		}
		
		else {
			throw new AccountNotFoundException("Account not found in database");
		}
		
		
	}
	

	
	
	


}
