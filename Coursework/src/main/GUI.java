package main;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 
public class GUI extends JPanel implements ActionListener{
	
	MenuItems name;
	JButton getName;
	

    public GUI() {
    	
        super(new BorderLayout()); 
      
        JTabbedPane tabbedPane = new JTabbedPane();
 
        JPanel buttonRow1 = new JPanel();
        buttonRow1.setPreferredSize(new Dimension(450, 200));
        buttonRow1.add(createButtonRow1());
        tabbedPane.addTab("Drinks", buttonRow1);
 
        JPanel buttonRow2 = new JPanel();
        buttonRow2.add(createButtonRow2());
        tabbedPane.addTab("Meals", buttonRow2);
 
        JPanel buttonRow3 = new JPanel();
        buttonRow3.add(createButtonRow3());
        tabbedPane.addTab("Snacks", buttonRow3);
 
        add(tabbedPane, BorderLayout.CENTER);
    }
    
   

    protected JPanel createButtonRow1() {
    	
    	getName = new JButton("Item");
        getName.addActionListener(this);
    	
        JButton button1 = new JButton("Americano", createImageIcon(""));
        button1.addActionListener(this); 
        button1.setVerticalTextPosition(AbstractButton.BOTTOM);
        button1.setHorizontalTextPosition(AbstractButton.CENTER);

        JButton button2 = new JButton("Latte",createImageIcon(""));
        button2.setVerticalTextPosition(AbstractButton.BOTTOM);
        button2.setHorizontalTextPosition(AbstractButton.CENTER);
        
        JPanel pane = new JPanel();
           pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
           pane.add(button1);
           pane.add(button2);
           
           return pane;
       }
        
    protected JPanel createButtonRow2() {
        JButton button1 = new JButton("Muffin", createImageIcon(""));
        button1.setVerticalTextPosition(AbstractButton.BOTTOM);
        button1.setHorizontalTextPosition(AbstractButton.CENTER);
        JButton button2 = new JButton("Cake",createImageIcon(""));
        button2.setVerticalTextPosition(AbstractButton.BOTTOM);
        button2.setHorizontalTextPosition(AbstractButton.CENTER);
        
        JPanel pane = new JPanel();
           pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
           pane.add(button1);
           pane.add(button2);
           return pane;
       }
    
    protected JPanel createButtonRow3() {
        JButton button1 = new JButton("Sandwich", createImageIcon(""));
        button1.setVerticalTextPosition(AbstractButton.BOTTOM);
        button1.setHorizontalTextPosition(AbstractButton.CENTER);
        JButton button2 = new JButton("Soup",createImageIcon(""));
        button2.setVerticalTextPosition(AbstractButton.BOTTOM);
        button2.setHorizontalTextPosition(AbstractButton.CENTER);
        
        JPanel pane = new JPanel();
           pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
           pane.add(button1);
           pane.add(button2);
           return pane;
       }
    
    
 
    

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            return null;
        }
    }
 
   
    static void initGUI() {
     
        JFrame frame = new JFrame("Order Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        GUI newContentPane = new GUI();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
 
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
       
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initGUI();
            }
        });
    }


	
	
	public void actionPerformed(ActionEvent e) {
		 { 
		    	if (e.getSource() == getName) {
		    		
		    	}
		    	
		    }
      

	

	
	
} }