package com.example.incedohibernatetraining.model;

import lombok.AllArgsConstructor;
import lombok.Data;


/*
 * Author : boopathi ramasamy 
 * Incedo hibernate training project
 * 
 */

@Data
@AllArgsConstructor
public class AccountInfo {

	
	    private String contactno;
		private String customerid;
	    private String accountno;
		private String bankName;
		public String getContactno() {
			return contactno;
		}
		public void setContactno(String contactno) {
			this.contactno = contactno;
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
		@Override
		public String toString() {
			return "AccountInfo [contactno=" + contactno + ", customerid=" + customerid + ", accountno=" + accountno
					+ ", bankName=" + bankName + "]";
		}
		

}
