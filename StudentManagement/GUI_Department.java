

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI_Department extends JFrame implements ActionListener, KeyListener  {
	// GUI
	final static Font mainFront = new Font("Segoe print", Font.BOLD, 20);
	//JFrame frame;
	JLabel labelWelcome, labelWelcome2, lbUser = new JLabel("USERNAME"), lbPass = new JLabel("PASSWORD");
	ImageIcon image, image2;
	JTextField tfUser = new JTextField();
	JPasswordField tfPass = new JPasswordField();
	//JPanel formPanel;`
	JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
	JButton registerButton = new JButton("REGISTER");
	JCheckBox showPassword = new JCheckBox("Show Password");

	Container container = getContentPane();
	
    
    

	public void welcomePage() {
		this.setTitle("Technology Department");
	    this.setResizable(false);
		/*
		 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit out of
		 * application, hide = kill the application //this.setResizable(false);//
		 * prevent this from being resized this.setSize(490, 490);
		 * this.setVisible(true);
		 */
		try {
			image = new ImageIcon("images\\alexlogo.png");// create img
																										// icon
			image2 = new ImageIcon(
					new ImageIcon("images\\welcomelogo.jpg").getImage()
							.getScaledInstance(300, 200, Image.SCALE_DEFAULT));

			this.setIconImage(image.getImage());// change icon of this
			//this.setIconImage(image2.getImage());
			

			this.getContentPane().setBackground(new Color(255, 255, 255));// change color
		} catch (Exception e) {
			System.out.println("Image cannot be found!");
		}

		labelWelcome = new JLabel();
		labelWelcome.setText("Welcome to our department!");
		labelWelcome.setSize(70, 30);
		labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		//labelWelcome.setIcon(image);
		labelWelcome2 = new JLabel(image2, JLabel.CENTER);
		labelWelcome2.setIcon(image2);
		
		
		labelWelcome2.setHorizontalTextPosition(JLabel.RIGHT);
		//labelWelcome2.setVerticalTextPosition(JLabel.BOTTOM);
		
		labelWelcome2.setForeground(new Color(0x00FF00));

		// Flowlayout

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		//JLabel stuff 
		
		lbUser.setFont(mainFront);

		tfUser.setFont(mainFront);

		lbPass.setFont(mainFront);

		tfPass.setFont(mainFront);

		
		
		this.add(labelWelcome);
		this.add(labelWelcome2);
		this.add(lbUser);
		this.add(lbPass);
		this.add(tfUser);
		this.add(tfPass);
		this.add(showPassword);
		this.add(loginButton);
		this.add(resetButton);
		this.add(registerButton);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit out of application, hide = kill the application
		// this.setResizable(false);// prevent this from being resized
		this.setSize(460, 540);
		//this.setBounds(450, 190, 1014, 597 ); //450, 190, 1014, 597 //10, 10, 370, 600
		this.setVisible(true);

		
		
	}

	public void UserLogin(){
		setLayoutManager();
		setLocationAndSize();
		addActionEvent();//calling addActionEvent() method
	}

	public void setLayoutManager()
	{
		container.setLayout(null);
	}

	public void setLocationAndSize()
	{
		//Setting location and Size of each components using setBounds() method.
		lbUser.setBounds(50,250,150,30);
		lbPass.setBounds(50,320,150,30);
		tfUser.setBounds(180,250,150,30);
		tfPass.setBounds(180,320,150,30);
		showPassword.setBounds(180,345,150,30);
		loginButton.setBounds(50,400,100,30);
		resetButton.setBounds(200,400,100,30);
		registerButton.setBounds(125, 450, 100, 30);
  
	}

	public void addActionEvent()
	{
		//adding Action listener to components
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
		registerButton.addActionListener(this);

		loginButton.addKeyListener(this);
		tfUser.addKeyListener(this);
		tfPass.addKeyListener(this);
		resetButton.addKeyListener(this);
		registerButton.addKeyListener(this);
	}
	public void actionPerformed(ActionEvent e){

		//Coding Login button
		if((e.getSource() == loginButton))
		{
			String userText;
			String pwdText;
            userText = tfUser.getText();
            pwdText = tfPass.getText();

            // if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {

			UserInfo ui = new UserInfo(tfUser.getText() , tfPass.getText());
			if(new MainDepartment().login(ui)){
		
                JOptionPane.showMessageDialog(this, "Login Successful");

				//container.setVisible(false);
				this.setVisible(false);
				MainPage mp = new MainPage();
				mp.MangagePage();

			// loginButton.addActionListener(new ActionListener(){

			// 	@Override
			// 	public void actionPerformed(ActionEvent e) {
			// 		// TODO Auto-generated method stub
				
			// 	}

			// });	
            } else if(userText.trim().equals("")){
				JOptionPane.showMessageDialog(this, "Enter Your Username to Login", "Empty Username", 2);
			} else if(pwdText.trim().equals( "")){
				JOptionPane.showMessageDialog(this,"Enter Your Password to Login", "Empty Password", 2);
			} else{
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
			
		}

		//Coding Part of RESET button 
        if (e.getSource() == resetButton) {
            tfUser.setText("");
            tfPass.setText("");
        }

       //Coding showPassword JCheckBox
		if(e.getSource() == showPassword)
		{
			if(showPassword.isSelected())
			{
				tfPass.setEchoChar((char) 0);
			} else{
				tfPass.setEchoChar('*');
			}
		}

		//Coding REGISTER button

		if(e.getSource() == registerButton){
			this.setVisible(false);
			MainDepartment ur = new MainDepartment();
			ur.registerUser();
		}
	}

	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			if(e.getSource() == resetButton){
				resetButton.doClick();
			}else{
				loginButton.doClick();
			}

		  }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
