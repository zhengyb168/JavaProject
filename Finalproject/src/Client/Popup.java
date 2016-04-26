package Client;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class Popup implements ActionListener{
 
	Font font =  new Font("Times new Roman", Font.BOLD, 20);
		JDialog jDialog2=null; 
	    Popup(JFrame jFrame, int Ok){
	       jDialog2=new JDialog(jFrame,"Notice",true);
	       JTextArea jt2 = new JTextArea();
	       String[] textinfo = {"      Please enter your name and ID!","      Successfully Booked!","      Successfully Canceled!",
	    		   				"      IDnum must be 8 digits!","       Name or ID wrong!","       Find your information!"};
	       for (int i = 0; i < 6; i++){
	    	   if(Ok == i){
	    		   jt2 = new JTextArea(textinfo[i]);
	    	   }
	       }
	       jt2.setFont(font);
	       JButton jButton1=new JButton("close");
	       jButton1.addActionListener(this);
	       jDialog2.getContentPane().add(BorderLayout.SOUTH,jButton1);
	       jDialog2.getContentPane().add(jt2);
	       jDialog2.setSize(360,100);
	       jDialog2.setLocationRelativeTo(null);
	       jDialog2.setVisible(true);
	       jDialog2.setResizable(false);
	    }
	     public void actionPerformed(ActionEvent e){
	        if(e.getActionCommand().equals("close")){
	               jDialog2.dispose();
	        }
	     }	
	}

