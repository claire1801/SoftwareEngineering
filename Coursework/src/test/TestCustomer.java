package test;


import org.junit.Before;
import org.junit.Test;

import main.Customer;
//import main.CustomerList;
import main.MembershipType;

import static org.junit.Assert.*;

import java.util.Hashtable;

public class TestCustomer {

	private Customer newCustomer;

    // method will be called before EVERY test.
    // ensures we have a new B for every test
    @Before
    public void setUp() throws Exception {
    	Hashtable<Integer, Customer> list = new Hashtable<>();
    	
    	 newCustomer = new Customer(1,MembershipType.MEMBER,1,"sam");

    }

    @Test
    public void test_getID() {
        // the message (1st parameter is optional)
    	
    	assertEquals(1,newCustomer.getCustomerId());
    }
    @Test
    public void test_set_id() {
        // the message (1st parameter is optional)
    	newCustomer.setCustomerId(2);
    	assertEquals(2,newCustomer.getCustomerId());
    }
    @Test
    public void test_get_coffee() {
        // the message (1st parameter is optional)
    	
    	assertEquals(1,newCustomer.getNumberPreviousCoffees());
    }
    @Test
    public void test_set_coffee() {
        // the message (1st parameter is optional)
    	newCustomer.setNumberPreviousCoffees(4);
    	assertEquals(4,newCustomer.getNumberPreviousCoffees());
    }



 
}