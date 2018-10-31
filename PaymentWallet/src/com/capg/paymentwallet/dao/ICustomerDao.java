package com.capg.paymentwallet.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.capg.paymentwallet.bean.CustomerBean;

public interface ICustomerDao {


    public boolean createAccount(CustomerBean customerbean);
    public double showBalance(BigInteger phoneNo) throws Exception;
    public double deposit(BigInteger phoneNo,double rupees) throws Exception;
    public double withdraw(BigInteger phoneNo, double rupees) throws Exception;
    public boolean fundTransfer(BigInteger phoneNo,double balance,BigInteger anotherPhnNum) throws Exception;
    public ArrayList<String> addTransaction(double amount,String msg,LocalDate date,LocalTime time);
    public ArrayList<String> printTransaction(ArrayList printList);
	 
    
}
