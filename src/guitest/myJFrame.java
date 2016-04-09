package guitest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Victor on 09/04/2016.
 */
public class myJFrame extends JFrame {

    public myJFrame() {
    	
    	JTextField field = new JTextField();
    	field.setColumns(10);
    	field.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				if(field.getText().length() >= 10)
					
					e.consume();
			}
    		
    	});
    	
    	JTextField field2 = new JTextField();
    	field2.setColumns(10);
    	field2.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				if(field2.getText().length() >= 10)
					
					e.consume();
			}
    		
    	});
    	        	
    	JButton boutton = new JButton("Start simulation");
    	    	    	
    	JRadioButton b1 = new JRadioButton("Always change");
    	JRadioButton b2 = new JRadioButton("Always keep");
    	
    	ButtonGroup group = new ButtonGroup();
    	
    	group.add(b1);
    	group.add(b2);
    	
    	Container contentPane = this.getContentPane();
    	contentPane.setLayout(new GridLayout(2,0));
    	
    	JPanel enHaut = new JPanel(new FlowLayout());
    	JPanel enBas = new JPanel(new FlowLayout());
    	
    	enHaut.add(b1);
    	enHaut.add(field);
    	enHaut.setBackground(Color.BLUE);
    	enHaut.setMaximumSize(enHaut.getComponent(0).getPreferredSize());
    	enBas.add(b2);
    	enBas.add(field2);
    	enBas.add(boutton);
    	
    	contentPane.add(enHaut);
    	contentPane.add(enBas);
    	
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	
    	int height = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
    	int width =  (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
    	
    	this.setSize(width,height);
    	
    	
    }


}
