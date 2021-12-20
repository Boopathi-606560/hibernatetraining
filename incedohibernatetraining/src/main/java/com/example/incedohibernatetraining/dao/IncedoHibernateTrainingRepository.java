package com.example.incedohibernatetraining.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.incedohibernatetraining.entity.AccountsEntity;

/*
 * Author : boopathi ramasamy 
 * Incedo hibernate training project
 * 
 */

public interface IncedoHibernateTrainingRepository  extends 
JpaRepository<AccountsEntity,Integer>{
	

}
