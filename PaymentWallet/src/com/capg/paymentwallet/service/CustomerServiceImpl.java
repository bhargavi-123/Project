package com.capg.paymentwallet.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.dao.CustomerDaoImpl;
import com.capg.paymentwallet.dao.ICustomerDao;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.exception.CustomerExceptionMessage;

public class CustomerServiceImpl implements ICustomerService {
    ICustomerDao dao = new CustomerDaoImpl();
//    CustomerBean customerbean = new CustomerBean();
	@Override
	public boolean createAccount(CustomerBean customerbean) {
		// TODO Auto-generated method stub
		return dao.createAccount(customerbean);
	}

	@Override
	public double showBalance(BigInteger phoneNo) throws Exception {
		// TODO Auto-generated method stub
		return dao.showBalance(phoneNo);
	}

	@Override
	public double deposit(BigInteger phoneNo,double rupees ) throws Exception {
		// TODO Auto-generated method stub
		return dao.deposit(phoneNo, rupees);
	}

	@Override
	public double withdraw(BigInteger phoneNo, double rupees) throws Exception {
		// TODO Auto-generated method stub
		return dao.withdraw(phoneNo, rupees);
	}

	@Override
	public boolean fundTransfer(BigInteger phoneNo,double balance,BigInteger phnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.fundTransfer(phoneNo,balance,phnum);
	}

	@Override
	public ArrayList<String> addTransaction(double amount, String msg,LocalDate date,LocalTime time) {
		// TODO Auto-generated method stub
		return dao.addTransaction(amount, msg,date,time);
	}

	@Override
	public ArrayList<String> printTransaction(ArrayList printList) {
		// TODO Auto-generated method stub
		return dao.printTransaction(printList);
	}

	
	
	public boolean validateCustomer(CustomerBean customer) throws CustomerException {
		boolean isValid=true;
		
	if(!( customer.getFirstName().matches("[a-z A-Z]{4,}")))
	{
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR1);
	}
	if(!( customer.getLastName().matches("[a-z A-Z]{4,}")))
	{
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR2);
	}
	if(!(customer.getPhoneNo().bitLength()==10)){
		
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR5);
	}
	if((customer.getEmailId()== null || !(customer.getEmailId().matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+")))){

		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR3);
	}
	if((customer.getPanNum()==null) || !(customer.getPanNum().matches("[A-Z][0-9]{10}"))){
		
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR4);
	}
	if((customer.getAddress()==null)||!(customer.getAddress().matches("[A-Z][0-9]{10,50}")))
	{
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR7);
	}
	if(customer.getBalance()==0||!(customer.getBalance()>0)){
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR6);
 
	}
	
		return isValid;
	}



	
	
    

		
		
			
	
}

