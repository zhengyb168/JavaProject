package  Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;  
import java.util.Date;
import java.util.Random;
import java.util.Timer;  
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.swing.*;


public class Register extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Roominfo rr = new Roominfo();
	Manager mm = new Manager();
	Booking bb = new Booking();
	JButton[] button5 = new JButton[4];
	JButton[] button9 = new JButton[3];
	JLabel[] label1 = new JLabel[3];
	JLabel[] label5 = new JLabel[5];
	JLabel[] label9 = new JLabel[8];   //////
	JTextArea[] ta5 = new JTextArea[3];
	JTextArea[] ta9 = new JTextArea[9];   /////////
	JComboBox[] jcb = new JComboBox[6];
	JTable table = new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	String[] buttonString5 = {"Confirm","Clear","Search"};
	String[] buttonString9 = {"Register", "Clear","Send"};
	String[] labelString2 = {"Booking"};
	String[] labelString5 = {"Please Enter Your ","E-mail: ","password: ","Paid-up: "};
	String[] labelString9 = {"E-mail: ","Name: ","ID: ","Password: ","Verification code: "};
	
	Font font =  new Font("Times new Roman", Font.BOLD, 20);
	Font font1 =  new Font("Times new Roman", Font.BOLD, 34);
	Font font2 =  new Font("Times new Roman", Font.BOLD, 14);
	Font font3 =  new Font("Calibri", Font.PLAIN, 14);
	Font font4 =  new Font("Calibri", Font.PLAIN, 64);
	Font font5 =  new Font("Calibri", Font.PLAIN, 28);
	JLabel timeLabel;  
    JLabel displayArea;  
    String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  
    String time;  
    int ONE_SECOND = 1000;
    JPanel p3 = new JPanel(); 
	JPanel p4 = new JPanel(); 
	JPanel p5 = new JPanel();
	JPanel p7 = new JPanel(); 
	JPanel p8 = new JPanel(); 
	JPanel p9 = new JPanel(); 
	
	public Register() {
		setTitle("Hotel Order System");
		Container c = getContentPane();
		c.setLayout(new FlowLayout(3,10,10));

		/////////////////////(Booking Part)//////////////////////////////

		for(int i = 0; i < 3; i++) {
		    button9[i] = new JButton();
		    button9[i].setText(buttonString9[i]);
		    button9[i].setFont(font2);
		    button9[i].setContentAreaFilled(false);
		    button9[i].setBorder(BorderFactory.createRaisedBevelBorder());
		    button9[i].addActionListener(this);
		}
		for(int i = 0; i < 5; i++) {
		    label9[i] = new JLabel();
		    label9[i].setText(labelString9[i]);
		    label9[i].setFont(font);
		    
		}
		for(int i = 0; i < 9; i++) {
		    ta9[i] = new JTextArea();
		    ta9[i].setFont(font);
		    ta9[i].setBorder(BorderFactory.createLoweredBevelBorder());
		}
		
		
		p9.setLayout(null);
		button9[0].setBounds(320,220,100,40);
		button9[1].setBounds(490,220,100,40);
		button9[2].setBounds(440,20,50,30);
		label9[0].setBounds(90,10,160,50);
		label9[1].setBounds(90,70,80,50);
		label9[2].setBounds(90,140,80,50);
		
		label9[3].setBounds(490,70,180,50);
		label9[4].setBounds(490,140,180,50);
		
		ta9[1].setBounds(170,80,250,30);
		ta9[2].setBounds(170,150,250,30);
		ta9[0].setBounds(170,20,250,30);
		ta9[3].setBounds(660,80,250,30);
		ta9[4].setBounds(660,150,250,30);
		for(int i = 0; i < 3; i++){
	    	p9.add(button9[i]);
		}
		for(int i = 0; i < 5; i++) 
			p9.add(label9[i]);
		for(int i = 0; i < 9; i++) 
			p9.add(ta9[i]);
		
		p9.setOpaque(false);
		//show detail panel
		p3.setPreferredSize(new Dimension(610,255));
		p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p3.setOpaque(false);
		// ******for Panel4(standard time Part)******
		timeLabel = new JLabel("CurrentTime: ");  
        displayArea = new JLabel();  
        timeLabel.setFont(font);
        displayArea.setFont(font);
        p4.setLayout(null);
        timeLabel.setBounds(120,60,140,50);
        displayArea.setBounds(100,130,180,50);
        configTimeArea();
		p4.add(timeLabel);
		p4.add(displayArea);
		p4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p4.setPreferredSize(new Dimension(380, 255));
		p4.setOpaque(false);
		
		// ******for Panel5(Cancel Part)******
		for(int i = 0; i < 2; i++) {
		    button5[i] = new JButton();
		    button5[i].setText(buttonString5[i]);
		    button5[i].setFont(font2);
		    button5[i].setContentAreaFilled(false);
		    button5[i].setBorder(BorderFactory.createRaisedBevelBorder());
		    button5[i].addActionListener(this);
		}
		for(int i = 0; i < 3; i++) {
		    label5[i] = new JLabel();
		    label5[i].setText(labelString5[i]);
		    label5[i].setFont(font);
		    if (i==0)
		    	label5[i].setFont(font1);
		}
		for(int i = 0; i < 2; i++) {
		    ta5[i] = new JTextArea();
		    ta5[i].setFont(font);
		    ta5[i].setBorder(BorderFactory.createLoweredBevelBorder());
		}
		p5.setLayout(null);
		button5[0].setBounds(210,220,100,40);
		button5[1].setBounds(370,220,100,40);
		
		label5[0].setBounds(190,10,300,50);
		label5[1].setBounds(190,70,80,50);
		label5[2].setBounds(190,140,100,50);
		ta5[0].setBounds(290,80,250,30);
		ta5[1].setBounds(290,150,250,30);
		for(int i = 0; i < 2; i++)
			p5.add(button5[i]);
		for(int i = 0; i < 3; i++) 
			p5.add(label5[i]);
		for(int i = 0; i < 2; i++) 
			p5.add(ta5[i]);
		p5.setOpaque(false);

		// for Panel7 (logo)
		JLabel label = new JLabel("Welcome To Java810 Hotel");
		p7.setLayout(null);
		label.setFont(font4);
		label.setBounds(140,5,720,100);
		p7.add(label);
		p7.setOpaque(false);
	    p7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p7.setPreferredSize(new Dimension(1000, 100));
		
		// for Panel8
		UIManager.put("TabbedPane.contentOpaque", false);
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Register",p9);
	    jtp.addTab("Log in", p5);
	    jtp.setFont(font5);
	    jtp.setBackground(new Color(0,0,0,0));
	    jtp.setOpaque(false);
	    jtp.setTabPlacement(JTabbedPane.TOP);
	    jtp.setOpaque(false);
	    p8.setLayout(null);
	    jtp.setBounds(5,10,985,315);
		p8.add(jtp);
		p8.setOpaque(false);
	    p8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p8.setPreferredSize(new Dimension(1000, 335));
		
		// add all of Panel to Container c
		c.add(p7);
		c.add(p8);
		c.add(p4);
		c.add(p3);
		
		((JComponent) c).setOpaque(false);
		ImageIcon img = new ImageIcon("lib/3.jpg");  //add background picture
	    JLabel hy = new JLabel(img);
	    getLayeredPane().add(hy, new Integer(Integer.MIN_VALUE));
	    hy.setBounds(0,0,img.getIconWidth(),img.getIconHeight()); 
		setSize(1025,760);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static String vcode="";
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == button5[0]){
			boolean tmp=mm.searchregister(ta5[0].getText(),ta5[1].getText()); 
			if(tmp){
				String []t=mm.getnameidemail(ta5[0].getText(),ta5[1].getText());
				dispose();
				new testclass3(t[0],t[1],t[2]);      
				
				cancel(2);
				
				
			
			}else{
				new Popup(this,5);
			}
			
		}
		if(ae.getSource() == button5[1]){
			cancel(2);
        }
		
        if(ae.getSource() == button9[2]) {
        	Random r= new Random();
			for(int i=0;i<6;i++)
			vcode+=""+r.nextInt(10);
			new Popup(this,6);
        	try {
				
        		mm.VerificationEmail(ta9[0].getText(),vcode);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // show the current room status
        	
        }
        if(ae.getSource() == button9[0]) {
        	
			if(ta9[4].getText().equals(vcode)){
				TextArea text=p3();
        	mm.createANewRegisterUser(ta9[1].getText(),ta9[2].getText(),ta9[0].getText(),ta9[3].getText());
    		text.setText("This is your Register information: \n\n"+"Email: "+ta9[0].getText()+"\n"+"Name: "+ta9[1].getText()+"\n"+"ID: "+ta9[2].getText()+"\n"+"password: "+ta9[3].getText()+"\n");
    		p3.add(text);
    		
    		new Popup(this,2);
        	//cancel(1);
        	//Table tt = new Table(4,table);
        }
			else{
				new Popup(this,4);
			}
        }
        
        if(ae.getSource() == button9[1]) {
        	cancel(1);
        }
        
	}
	
	public void cancel(int Can) {
		
		if(Can == 1){
			ta9[8].setText("");
			for(int i = 0; i < 2; i++)
				ta9[i].setText("");	
		}
		if(Can == 2){
			for(int i = 0; i < 2; i++)
				ta5[i].setText("");
		}
	}
	public TextArea p3(){
		TextArea text=new TextArea();
		text.setPreferredSize(new Dimension(590,240));
		text.setEditable(false);
		text.setFont(font);

		return text;
	}
	// for current time
	
	public void configTimeArea() {  
        Timer tmr = new Timer();  
        tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);  
    }  
  
    public class JLabelTimerTask extends TimerTask {  
        SimpleDateFormat dateFormatter = new SimpleDateFormat(  
                DEFAULT_TIME_FORMAT);  
  
        @Override  
        public void run() {  
            time = dateFormatter.format(Calendar.getInstance().getTime());  
            displayArea.setText(time);  
        }  
    } 
	
	public static void main(String[] args){
		new Register();
	}

}


