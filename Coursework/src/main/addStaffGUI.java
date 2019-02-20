package main;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class addStaffGUI extends JFrame implements ActionListener{
	
	//CompetitorList competitorList;
	
	  //GUI components
    JTextArea details;
    JTextField enteredID;
    JButton Find = new JButton("Find");
    JButton FindSTH = new JButton("Find STH Competitor");
    JButton FindCC = new JButton("Find CC Competitor");
    JButton FindAN = new JButton("Find AN Competitor");
    JButton FindKP = new JButton("Find Kabaddi Player");
  
    
    
	public addStaffGUI() {
		//competitorList = list;
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
        STHpanel.add(new JLabel("Find a Competitor"));   
        enteredID = new JTextField(5);
        enteredID.setText("Enter ID (001-999)");
        STHpanel.add(enteredID);   
        //add search button
        //Find = new JButton("Find");  
        STHpanel.add(Find);    
        STHpanel.add(FindSTH);   
        STHpanel.add(FindCC);   
        STHpanel.add(FindAN);
        STHpanel.add(FindKP);   
        Find.addActionListener(this) ;
        FindSTH.addActionListener(this) ;
        FindCC.addActionListener(this) ;
        FindAN.addActionListener(this) ;
        FindKP.addActionListener(this) ;
        
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
	
	
	public void actionPerformed(ActionEvent e) 
    { 
    	if (e.getSource() == Find || e.getSource() == FindSTH || e.getSource() == FindCC || e.getSource() == FindAN || e.getSource() == FindKP) {
    		
    		String IDnumber = enteredID.getText().trim();
    		if(IDnumber.length() > 0) {
    			String compDetails = "";
    			String competitorType ="competitor";
    			int ID = 0;
    			try{
    				ID = Integer.parseInt(IDnumber);
    			}catch(NumberFormatException e1) {
    				details.setText("\"" + IDnumber + "\" is not a correct format for ID (001-999)");
    			}
    			if(e.getSource() == Find) {
    				 //compDetails = competitorList.getDetails(ID);
    			}
    			else if(e.getSource() == FindSTH) {
    				competitorType = "STH Competitor";
    				//compDetails = competitorList.getDetails(competitorType, ID);
    			}
    			else if(e.getSource() == FindCC) {
    				competitorType = "CC Competitor";
    				//compDetails = competitorList.getDetails(competitorType, ID);
    			}
    			else if(e.getSource() == FindAN) {
    				competitorType = "AN Player";
    				//compDetails = competitorList.getDetails(competitorType, ID);
    			}
    			else if(e.getSource() == FindKP) {
    				competitorType = "Kabaddi Player";
    				//compDetails = competitorList.getDetails(competitorType, ID);
    			}
    			if (compDetails != "") {
    			details.setText(compDetails);
    			}
    			else {
    				details.setText("Cant find a " + competitorType + " with that ID");
    			}
    		}
    		else {
    			details.setText("No ID entered!");
    		}
	}
    }
		

}

	

	


    
   
