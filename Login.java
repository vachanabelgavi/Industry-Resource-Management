package kletech;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  Login extends JFrame implements ActionListener
{
	    static JFrame frame;
    private String username;
    private String password;
    private static JFrame loginFrame;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private JButton loginBtn;
    private JButton exitBtn;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
    String dialogmessage;
    String dialogs;
    private JLabel userLbl;
    private JLabel passwordLbl;
    private static JTextField userTxt;
  
    private static JPasswordField passwordTxt;
    public String loginname;
    public String loginpass;
   
        
    	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
    
    	Login()
	{

		
		panel1 = new JPanel();
    
   panel2 = new JPanel();
   userLbl = new JLabel("Username :");
   userLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
   userLbl.setBounds(96, 5, 122, 60);
   userTxt = new JTextField(20);
   userTxt.setBounds(283, 19, 273, 36);
  
   passwordLbl = new JLabel("Password :");
   passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
   passwordLbl.setBounds(96, 76, 113, 48);
//   passwordTxt = new JTextField(20);
   passwordTxt = new JPasswordField(20);
   passwordTxt.setBounds(283, 84, 273, 36);
   // passwordTxt.setEchoChar('?');
   
   panel3 = new JPanel();
   
   loginBtn = new JButton("Login", new ImageIcon("images/key.gif"));
   loginBtn.setBounds(211, 5, 81, 23);
   
   loginBtn.addActionListener(this);
   exitBtn = new JButton("Exit", new ImageIcon("images/Keys.gif"));
   exitBtn.setBounds(297, 5, 81, 23);
   
   exitBtn.addActionListener(this);
	panel1.setLayout(null);
	panel1.setOpaque(true);
    panel2.setLayout(null);
    panel2.add(userLbl);
	panel2.add(userTxt);
	panel2.add(passwordLbl);
	panel2.add(passwordTxt);
	panel2.setOpaque(true);
   	panel3.setLayout(null);
   	panel3.add(loginBtn);
	panel3.add(exitBtn);
	panel3.setOpaque(true);
	frame = new JFrame("SHREE GODACHI VEEREABADRESHWARA INDUSTRY");
	frame.setAutoRequestFocus(false);
       frame.setSize(619,500);
        
	Container pane = frame.getContentPane();   
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    //pane.setLayout(new GridLayout(3,1));
	pane.add(panel1);
	pane.add(panel2);
	pane.add(panel3);
	frame.setLocation((screen.width - 500)/2,((screen.height-350)/2));	
    frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

	}


			public void actionPerformed(ActionEvent event)
				{
				
					
					Object source = event.getSource(); 
        if(source.equals(loginBtn))
        {
           //login();
           String loginname,loginpass;
           loginname = userTxt.getText().trim();
           	loginpass = passwordTxt.getText().trim();
           	 if(loginname.equals("a") && loginpass.equals("a"))
					{	
           		 	
					/*dialogmessage = "Welcome - " +loginname;
                    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    userTxt.setText("");
						//new SelectWindow();
                    */
           		 	MainScreen fr = new MainScreen();
					fr.setVisible(true);
					frame.setVisible(false);
				}
				else{
						JOptionPane.showMessageDialog(null,"Invaild User name and password" , "WARNING!!!",JOptionPane.INFORMATION_MESSAGE);
						userTxt.setText("");
                        passwordTxt.setText("");
					}
						
           
        } 
        else if(source.equals(exitBtn))
        {
            		System.exit(0);
        }
}

      
	public static void main(String[] args)
	{
		Login frame = new Login();
		frame.setVisible(true);
	}
}
