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
 * Secondary gui interface for checkout.
 * @author 
 *
 */
public class CheckoutGUI extends JFrame implements ActionListener{
	
	
	
	  //GUI components
    JTextArea details;
    
    JButton BillPaid = new JButton("Pay Bill");

  
    double cost;
    double discount;
    
	public CheckoutGUI() {
		
		discount = Manager.basket.getTotalDiscount();
		cost = Manager.basket.getFinalBill();

		
		
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
		STHpanel();

        //pack and set visible
        this.pack();
        this.setVisible(true);
        this.setLocation(50, 50);
	}

	private void STHpanel() {
		//this panel will add a search function.

        JPanel STHpanel = new JPanel();
        STHpanel.setLayout(new GridLayout(3,3));
        //add text enter field
        STHpanel.add(new JLabel("Basket"));   
        
        //add search button
        //Find = new JButton("Find");  
        STHpanel.add(BillPaid);    
   
        BillPaid.addActionListener(this) ;

        
        //results area
        details= new JTextArea(3,3);     
        details.setEditable(false);
        details.setText(String.format("cost: �%,.2f\n discount : �%,.2f\n", cost, discount));
        //combine all panels
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,2));
        southPanel.add(STHpanel);
        southPanel.add(details);
      
        //add panel to the content pane
        this.add(southPanel, BorderLayout.CENTER);   	
    }
	
	
	
	
	public void actionPerformed(ActionEvent e) { 
    	if (e.getSource() == BillPaid) {
    		Manager.basket.confirmedAndPaid();
    		setVisible(false);
    		
    		
    		
    	}
    }
	


}

	

	


    
   
