package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFrame;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.security.Timestamp;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Date;
import java.util.Hashtable;
//import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

public class MainGUI extends JFrame implements ActionListener {
	int CustomerID = 0;
	

	private JTextArea details;
	private JPanel southPanel = new JPanel();
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
    private JList list;
    private JButton button;
    private JButton AddCustomer;
    private JButton finish;
    private JButton exit;
    private JButton addID;
    private JTextField enteredID;

    String[] ID ;


    
    public MainGUI() {
    	 
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
        
      
        int size = Manager.menuList.getNumberofMenuItemsInList();
        String[] data = new String[size];
        ID = new String[size];
        int i = 0;
        for(MenuItems entry: Manager.menuList.getAllMenuItems()) {
        	data[i] = entry.name;
        	ID[i] = entry.uniqueID;
        	i++;
        }
 

        scrollPane = new JScrollPane();
        scrollPane2 = new JScrollPane();
        list = new JList(data);
        scrollPane.setViewportView(list);
        button = new JButton("Add to Basket");
        AddCustomer = new JButton("Add New Customer");
        addID = new JButton("Add Customer ID");
        finish = new JButton("Checkout");
        exit = new JButton("Exit and Write Report");
        
        enteredID = new JTextField(5);
        enteredID.setText("Enter Customer ID (Integer)");
        
        details = new JTextArea(3,3);     
        details.setEditable(false);
        scrollPane2.setViewportView(details);
        addID.addActionListener(this);
        button.addActionListener(this);
        finish.addActionListener(this);
        exit.addActionListener(this);
        AddCustomer.addActionListener(this);
 
        // add list to frame
        southPanel.setLayout(new GridLayout(2,2));
        southPanel.add(scrollPane);
        southPanel.add(enteredID);
        southPanel.add(addID);
        southPanel.add(button);
        southPanel.add(finish);
        southPanel.add(exit);
        southPanel.add(scrollPane2);
        southPanel.add(AddCustomer);
        
        add(southPanel);
   
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add to Basket")) {
            int index = list.getSelectedIndex();
            String uniquID = ID[index];

            
            Manager.basket.addItemToUnconfirmedOrder(Manager.menuList.getItem(uniquID));

            Iterable<MenuItems> basketList = Manager.basket.getItemsInBasket();
            String output = "";
            for(MenuItems item : basketList) {
            	output += String.format("%s\n", item.uniqueID);
            }
            details.setText(output);
        }
        if (e.getActionCommand().equals("Exit and Write Report")) {
            Manager.progExit();
        }
        if (e.getActionCommand().equals("Checkout")) {
        	
        	if(CustomerID == 0) {
        		details.setText("please enter customer ID");
        	}else  {
        	
        		details.setText("");
         		CheckoutGUI checkout = new CheckoutGUI();
        		
        		checkout.setUpGUI(); 
        	}

  
        }
        if (e.getActionCommand().equals("Add New Customer")) {
        	
        	
        		AddCustomerGUI addCustomer = new AddCustomerGUI();
        		addCustomer.setUpGUI(); 
        	

  
        }
        if (e.getActionCommand().equals("Add Customer ID")) {
        	String IDnumber = enteredID.getText().trim();
        	int ID = 0;
			try{
				ID = Integer.parseInt(IDnumber);
				if(Manager.customerList.customerExists(ID)) {
					CustomerID = ID;
					details.setText("\"" + IDnumber + "\" is set");
					Manager.basket.setCurrentCustomerID(CustomerID);
				} else {
					details.setText("There is no customer with ID:\"" + IDnumber + "\" ");
				}
				
				
				
			}catch(NumberFormatException e1) {
				details.setText("\"" + IDnumber + "\" is not a correct format for ID (001)");
			}
        }
    }
    


	
}
