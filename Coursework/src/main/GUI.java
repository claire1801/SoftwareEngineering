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

public class GUI extends JFrame implements ActionListener {
	int CustomerID = 0;
	

	private JTextArea details;
	private JPanel southPanel = new JPanel();
	private JScrollPane scrollPane;
    private JList list;
    private JButton button;
    private JButton finish;
    private JButton exit;
    private JButton addID;
    private JTextField enteredID;
    private TreeMap<String, MenuItems> menulist = new TreeMap<>();
    ArrayList<String> basket = new ArrayList<String>();
    String[] ID ;
    int nextOrderID = 10;
    public GUI() {
    	 
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
        
        menulist = Manager.menuList.getMenuList();
        int size = menulist.size();
        String[] data = new String[size];
        ID= new String[size];
        int i = 0;
        for(MenuItems entry: menulist.values()) {
        	data[i] = entry.name;
        	ID[i] = entry.uniqueID;
        	i++;
        }
 
      //  Object[] data = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };
        //setUpPanel();
        scrollPane = new JScrollPane();
        list = new JList(data);
        scrollPane.setViewportView(list);
        button = new JButton("Add");
        addID = new JButton("Add Customer ID");
        finish = new JButton("Checkout");
        exit = new JButton("Exit");
        
        enteredID = new JTextField(5);
        enteredID.setText("Enter Customer ID (001-999)");
        
        details= new JTextArea(3,3);     
        details.setEditable(false);
        
        addID.addActionListener(this);
        button.addActionListener(this);
        finish.addActionListener(this);
        exit.addActionListener(this);
 
        // add list to frame
        southPanel.setLayout(new GridLayout(2,2));
        southPanel.add(scrollPane);
        southPanel.add(enteredID);
        southPanel.add(addID);
        southPanel.add(button);
        southPanel.add(finish);
        southPanel.add(exit);
        southPanel.add(details);
        add(southPanel);
   
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            int index = list.getSelectedIndex();
            String uniquID = ID[index];
            Manager.basket.addItemToUnconfirmedOrder(Manager.menuList.getItem(uniquID));
            
            basket.add(uniquID);
            System.out.println(basket);
        }
        if (e.getActionCommand().equals("Exit")) {
            Manager.progExit();
        }
        if (e.getActionCommand().equals("Checkout")) {
        	
        	if(CustomerID == 0) {
        		details.setText("please enter customer ID");
        	}else  {
        	
        
        		Gui2 checkout = new Gui2();
        		checkout.setUpGUI(); 
        	}

  
        }
        if (e.getActionCommand().equals("Add Customer ID")) {
        	String IDnumber = enteredID.getText().trim();
        	int ID = 0;
			try{
				ID = Integer.parseInt(IDnumber);
				CustomerID = ID;
				details.setText("\"" + IDnumber + "\" is set");
				Manager.basket.setCurrentCustomerID(CustomerID);
			}catch(NumberFormatException e1) {
				details.setText("\"" + IDnumber + "\" is not a correct format for ID (001-999)");
			}
        }
    }
    
    
	
}