package com.capg.paymentwallet.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.bean.DepositBean;
import com.capg.paymentwallet.bean.FundTransferBean;
import com.capg.paymentwallet.bean.WithdrawBean;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.exception.CustomerExceptionMessage;
import com.capg.paymentwallet.service.CustomerServiceImpl;

public class CustomerDaoImpl implements ICustomerDao {
	
//	 CustomerDaoImpl customerDao = new CustomerDaoImpl();
     ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
     static ArrayList<String> printList = new ArrayList<String>();
///     private static final SimpleDateFormat time = new SimpleDateFormat("HH.mm.ss");
//     private static final SimpleDateFormat date = new SimpleDateFormat("yyyy.mm.dd");
     CustomerBean customerbean = new CustomerBean();

     
     @Override
	public boolean createAccount(CustomerBean customerbean) {
	
		return list.add(customerbean);
	}

	
     @Override
	public double showBalance(BigInteger phoneNo) throws Exception {
        if(phoneNo == customerbean.getPhoneNo())
        {
        	double amt = customerbean.getBalance();
        	System.out.println("the total balance in your account is:"+amt);
        }
        return customerbean.getBalance();
	}


   
     @Override
    public double deposit(BigInteger phoneNo,double rupees) throws Exception {
    	 DepositBean depositBean = new DepositBean();
    	 if(phoneNo == customerbean.getPhoneNo())
         {
    		 double amt = customerbean.getBalance()+rupees;
    		 depositBean.setDepositAmt(amt);
    		 LocalDate date =  LocalDate.now();
    		 depositBean.setDate(date);
    		 LocalTime time = LocalTime.now();
    		 depositBean.setTime(time);
    		 customerbean.setBalance(amt);
    		 String msg = "deposited" ;
    		 
    	}
    	 return depositBean.getBalance();
    }



	@Override
	public double withdraw(BigInteger phoneNo, double rupees) throws Exception {
		WithdrawBean withdrawBean = new WithdrawBean();
		 if(phoneNo == customerbean.getPhoneNo())
         {
			 if( customerbean.getBalance() > rupees )
			 {
				 
    		 double amt = customerbean.getBalance()-rupees;
    		 withdrawBean.setWithdrawAmt(amt);
    		 LocalDate date =  LocalDate.now();
    		 withdrawBean.setDate(date);
    		 LocalTime time = LocalTime.now();
    		 withdrawBean.setTime(time);
    		 customerbean.setBalance(amt);

			 }
			 else{
				 System.out.println("insufficient balance");
			 }
			
    	}
		return customerbean.getBalance();
	 
				
	}

	

	@Override
	public boolean fundTransfer(BigInteger phoneNum,double balance,BigInteger anotherphoneNum) throws Exception {
		
		FundTransferBean fundTransferBean = new FundTransferBean();
		boolean isValid = false; 
		if(phoneNum == customerbean.getPhoneNo())
        {
			 isValid = true;
			 BigInteger anotherPhnNum = anotherphoneNum;
			 fundTransferBean.setFundtransferAmt(balance);
//			 customerDao.withdraw(anotherphoneNum, balance);
			 
		 }
		return  isValid;
		
	}

	@Override
    public ArrayList<String> addTransaction(double amount,String msg,LocalDate date,LocalTime time) {
           // TODO Auto-generated method stub
           
                
           String p= date+"   "+time+"    "+amount+"  "+msg;
           printList.add(p);
           
           return printList;
           
    }
    @Override
    public ArrayList<String> printTransaction(ArrayList printList) {
           
//         System.out.println(list);
           Iterator<String> iterator = printList.iterator();
           System.out.println("Date       "+"Time        "+"Amount   "+" Operation   ");
           while(iterator.hasNext())
           {
                  System.out.println(iterator.next());
           }
           return printList;
    }

	}


