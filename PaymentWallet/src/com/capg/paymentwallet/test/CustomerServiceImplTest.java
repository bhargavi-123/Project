package com.capg.paymentwallet.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.CustomerServiceImpl;
import com.capg.paymentwallet.service.ICustomerService;

public class CustomerServiceImplTest {

		private static CustomerServiceImpl service = null;

		@BeforeClass
		public static void createInstance() {
			service = new CustomerServiceImpl();
		}
		

		@Test(expected=CustomerException.class)
		public void testFirstNameNull() throws CustomerException {
			CustomerBean customer = new CustomerBean();
			customer.setFirstName(" ");// null
			customer.setLastName("ajayutyuy");
            customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
			
			//assertEquals("suma","suma");
		}

		@Test(expected = CustomerException.class)
		public void testFirstNameForLength() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kk");// (>4)
			customer.setLastName("ajay");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testFirstNameOnlyForAlphabets() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("123");// should be characters
			customer.setLastName("ajay");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testfirstName3() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");// valid
			customer.setLastName("ajay");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testlastName() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("");// null
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testlastName1() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("aj");// (>4)
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("7454637645"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testlastName2() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("456");// should be characters

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testlastName3() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");// valid

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testphno() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963"));// should be 10 digits
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = NullPointerException.class)
		public void testphno1() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			// customer.setAge(21);
			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(null);// should not be null
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testphno2() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("0000000000"));// should be valid number
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testphno3() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("XYZ"));// should be digits
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testphno4() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));// valid
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testemailid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("");// should not be null
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testemailid1() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId(".com@fhgfhf");// should be valid
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testemailid2() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");// valid
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));		
			customer.setBalance(1000);
			
			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNum() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");// valid
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNum1() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH90");// should be of length 10
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNum2() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			;
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("");// should not be null
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNum3() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("GHSDJ@75$");// should not contain special symbols
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNum4() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("9966332211");// should be alphanumeric
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}
	
		
		  
		@Test(expected = CustomerException.class)
		public void testbalance() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			// customer.setAge(18);// valid
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(-777);// should be valid

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testbalance1() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			// customer.setAge(18);// valid
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(0);// valid

			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testbalance2() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			// customer.setAge(18);// valid
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);// valid

			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testaddress() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");// valid
			// customer.setAge(18);// valid
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);
			boolean result = service.validateCustomer(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testaddress1() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("456");
			customer.setLastName("ajay");

			customer.setAddress(null);// should not be null
			// customer.setAge(18);// valid
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result = service.validateCustomer(customer);
			assertFalse(result);
		}

	}


