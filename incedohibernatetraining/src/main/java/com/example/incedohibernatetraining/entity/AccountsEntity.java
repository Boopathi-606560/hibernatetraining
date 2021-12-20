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
@Table(name = "accounts_detail_tble")
public class AccountsEntity {
	
	  @Id
	  @Column(name = "contact_no")
	  private int contactNo;
	 
	 @Column(name = "custmer_id")
		private String customerid;
	 
	  @Column(name = "account_no")
	    private String accountno;

	  @Column(name = "bank_name")
	 private String bankName;

		public int getContactNo() {
			return contactNo;
		}

		public void setContactNo(int contactNo) {
			this.contactNo = contactNo;
		}

		public String getCustomerid() {
			return customerid;
		}

		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}

		public String getAccountno() {
			return accountno;
		}

		public void setAccountno(String accountno) {
			this.accountno = accountno;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

	    
		

}
