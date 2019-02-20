package test;


import org.junit.Before;
import org.junit.Test;

import main.Customer;
import main.CustomerList;
import main.MembershipType;

import static org.junit.Assert.*;

import java.util.Hashtable;

public class TestCustomerList {

    private CustomerList b;

    // method will be called before EVERY test.
    // ensures we have a new B for every test
    @Before
    public void setUp() throws Exception {
    	//Hashtable<Integer, Customer> list = new Hashtable<>();
    	
    	Customer newCustomer = new Customer(1,MembershipType.MEMBER,1,"sam");
    	//list.put(1, newCustomer);
        b = new CustomerList();
        b.addCustomer(1, newCustomer);
    }

    @Test
    public void test_report() {
        // the message (1st parameter is optional)
    	
    	String Report = b.writeReport();
    	Report = Report.substring(0, 14);
        assertEquals("sam/1/1/MEMBER", Report);
    }
    
    @Test
    public void test_get_customer() {
        // the message (1st parameter is optional)
    	Customer newCustomer = new Customer(2,MembershipType.MEMBER,2,"Bob");
    	b.addCustomer(2, newCustomer);
    	
        assertEquals(newCustomer, b.getCustomer(2));
    }
    @Test
    public void test_get_customer2() {
        // the message (1st parameter is optional)
    	Customer newCustomer = new Customer(2,MembershipType.MEMBER,2,"Bob");
    	b.addCustomer(2, newCustomer);
    	//System.out.println(b.getCustomer(3));
        assertEquals(null, b.getCustomer(3));
    }
    
    @Test
    public void test_Remove_customer() {
        // the message (1st parameter is optional)
    	Customer newCustomer = new Customer(2,MembershipType.MEMBER,2,"Bob");
    	b.addCustomer(2, newCustomer);
    	b.removeCustomer(2);
    	//System.out.println(b.getCustomer(3));
        assertEquals(null, b.getCustomer(2));
    }

 
}