package main;
import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Secondary gui interface for Adding new customer.
 * @author 
 *
 */
public class AddCustomerGUI extends JFrame implements ActionListener{
	
	
	
	  //GUI components
    JTextArea details;
    
    JButton AddCustomer = new JButton("Add Customer");
    private JTextField name;
    private JTextField ID;
    private JTextField member;
    
   

 
    
	public AddCustomerGUI() {
		

		
	}
	/*
	 * set up window
	 */
	
	public void setUpGUI() {
		
		//set up window title
        this.setTitle("Find Competitor");
        //disable standard close button
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		//call panels here
		panel();

        //pack and set visible
        this.pack();
        this.setVisible(true);
        this.setLocation(50, 50);
	}

	private void panel() {
		//this panel will add a search function.
		name = new JTextField(5);
		name.setText("Enter Customer name");
		ID = new JTextField(5);
		ID.setText("Enter ID");
		member = new JTextField(5);
		member.setText("membership type (m/s/e)");

        JPanel STHpanel = new JPanel();
        STHpanel.setLayout(new GridLayout(3,3));
        //add text enter field
        STHpanel.add(new JLabel("Add Customer"));   
        
        //add search button
        //Find = new JButton("Find"); 
        STHpanel.add(name);  
        STHpanel.add(ID);  
        STHpanel.add(member);  
        STHpanel.add(AddCustomer);    
   
        AddCustomer.addActionListener(this) ;

        
        //results area
        details= new JTextArea(3,3);     
        details.setEditable(false);
        //combine all panels
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,2));
        southPanel.add(STHpanel);
        southPanel.add(details);
      
        //add panel to the content pane
        this.add(southPanel, BorderLayout.CENTER);   	
    }
	
	
	
	
	public void actionPerformed(ActionEvent e) { 
    	if (e.getSource() == AddCustomer) {
    		//Manager.basket.confirmedAndPaid();
    		
    		String IDnumber = ID.getText().trim();
    		String Customername = name.getText().trim();
    		String CustomerMember = member.getText().trim();
    		int ID = Integer.parseInt(IDnumber);
    		if(Manager.customerList.customerExists(ID) == false) {
    			MembershipType memType;

    			if(CustomerMember.charAt(0) == 'M'||CustomerMember.charAt(0) == 'm') {
    				memType = MembershipType.MEMBER;
    			}else if(CustomerMember.charAt(0) == 'S'||CustomerMember.charAt(0) == 's') {
    				memType = MembershipType.STUDENT;
    			}else  {
    				memType = MembershipType.EMPLOYEE;
    			}
    		
    			Customer newCustomer= new Customer(ID,memType,0,Customername);
    			Manager.customerList.addCustomer(ID, newCustomer);
    			setVisible(false);
    		}else {
    			details.setText("this ID \"" + IDnumber + "\" allready exists");
    		}
    		
    		
    		
    		
    		
    		
    	}
    }
	


}

	

	


    
   
