package kletech;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDetails extends JFrame implements ActionListener{
	Connection con=null;
	ResultSet rs=null;
	java.sql.Statement stmt=null; 
	
		private JPanel contentPane;
		private JTextField textField_id;
		private JTextField textField_1_fn;
		private JTextField textField_2_cmp;
		private JTextField textField_3_tin;
		private JTextField textField_4_ph;
		private JTextField textField_5_addr;
		private JTextField textField_7_ln;

		/**
		 * @wbp.parser.constructor
		 */
		CustomerDetails(String id,String fname,String lname,String cmp,String tin,String phone,String addr){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblShriGodachiVeerabhadreshwar = new JLabel("SHRI GODACHI VEERABHADRESHWAR INDUSTRY");
			lblShriGodachiVeerabhadreshwar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblShriGodachiVeerabhadreshwar.setBounds(63, 11, 379, 44);
			contentPane.add(lblShriGodachiVeerabhadreshwar);
			
			JLabel lblEmployeeDetails = new JLabel("Customer Details:");
			lblEmployeeDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEmployeeDetails.setBounds(73, 76, 131, 27);
			contentPane.add(lblEmployeeDetails);
			
			JLabel lblEmployeeName = new JLabel("First Name");
			lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeName.setBounds(122, 145, 144, 14);
			contentPane.add(lblEmployeeName);
			
			JLabel lblEmployeeId = new JLabel("Customer ID");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeId.setBounds(122, 114, 144, 14);
			contentPane.add(lblEmployeeId);
			
			JLabel lblAddress = new JLabel("Tin Number");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAddress.setBounds(122, 245, 144, 14);
			contentPane.add(lblAddress);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPhoneNumber.setBounds(122, 272, 144, 14);
			contentPane.add(lblPhoneNumber);
			
			 textField_id = new JTextField();
			textField_id.setBounds(239, 112, 285, 20);
			contentPane.add(textField_id);
			textField_id.setColumns(10);
			textField_id.setEditable(false);
			
			textField_1_fn = new JTextField();
			textField_1_fn.setBounds(239, 145, 285, 20);
			contentPane.add(textField_1_fn);
			textField_1_fn.setColumns(10);
			
			textField_2_cmp = new JTextField();
			textField_2_cmp.setBounds(239, 214, 285, 20);
			contentPane.add(textField_2_cmp);
			textField_2_cmp.setColumns(10);
			
			textField_3_tin = new JTextField();
			textField_3_tin.setBounds(239, 245, 285, 20);
			contentPane.add(textField_3_tin);
			textField_3_tin.setColumns(10);
			
			textField_4_ph = new JTextField();
			textField_4_ph.setBounds(239, 274, 285, 20);
			contentPane.add(textField_4_ph);
			textField_4_ph.setColumns(10);
			
			JLabel lblGender = new JLabel("Company Name");
			lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblGender.setBounds(122, 214, 144, 14);
			contentPane.add(lblGender);
			
			JLabel lblTotalNoOf = new JLabel("Address");
			lblTotalNoOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTotalNoOf.setBounds(122, 309, 144, 14);
			contentPane.add(lblTotalNoOf);
			
			textField_5_addr = new JTextField();
			textField_5_addr.setBounds(239, 305, 285, 50);
			contentPane.add(textField_5_addr);
			textField_5_addr.setColumns(10);
			
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLastName.setBounds(122, 178, 144, 14);
			contentPane.add(lblLastName);
			
			textField_7_ln = new JTextField();
			textField_7_ln.setBounds(239, 175, 285, 20);
			contentPane.add(textField_7_ln);
			textField_7_ln.setColumns(10);
			
			JButton button = new JButton("BACK");
			button.setBounds(12, 364, 127, 35);
			contentPane.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						SearchCustomer frame = new SearchCustomer();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
			
			
			textField_id.setText(id);
			textField_1_fn.setText(fname);
			textField_7_ln.setText(lname);
			textField_2_cmp.setText(cmp);
			textField_3_tin.setText(tin);
			textField_4_ph.setText(phone);
			textField_5_addr.setText(addr);
			
			JButton btnDone = new JButton("Update Details");
			btnDone.setBounds(395, 364, 127, 35);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						String f_name=textField_1_fn.getText();
						String l_name=textField_7_ln.getText();
						String cmp=textField_2_cmp.getText();
						String s=textField_3_tin.getText();
					
						String ph=textField_4_ph.getText();
						String addr=textField_5_addr.getText();
						float tin=Float.parseFloat(s);
						
						String id=(textField_id.getText());
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","9448497388Vk");  
						PreparedStatement st=con.prepareStatement("update customer set fname=?,lname=?,comp_name=?,Tin_no=?,phone_no=?,address=? where cust_id=?");
						st.setString(7, id);
						st.setString(1, f_name);
						st.setString(2, l_name);						
						st.setString(3, cmp);
						st.setFloat(4,tin);
						st.setString(5, ph);
						st.setString(6, addr);
						
						ResultSet rs=st.executeQuery();
						con.close();
						SearchCustomer frame = new SearchCustomer();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
		}
		
		CustomerDetails(int x){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblShriGodachiVeerabhadreshwar = new JLabel("SHRI GODACHI VEERABHADRESHWAR INDUSTRY");
			lblShriGodachiVeerabhadreshwar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblShriGodachiVeerabhadreshwar.setBounds(63, 11, 379, 44);
			contentPane.add(lblShriGodachiVeerabhadreshwar);
			
			JLabel lblEmployeeDetails = new JLabel("Customer Details:");
			lblEmployeeDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEmployeeDetails.setBounds(73, 76, 131, 27);
			contentPane.add(lblEmployeeDetails);
			
			JLabel lblEmployeeName = new JLabel("First Name");
			lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeName.setBounds(122, 145, 144, 14);
			contentPane.add(lblEmployeeName);
			
			JLabel lblEmployeeId = new JLabel("Customer ID");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeId.setBounds(122, 114, 144, 14);
			contentPane.add(lblEmployeeId);
			
			JLabel lblAddress = new JLabel("Tin Number");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAddress.setBounds(122, 245, 144, 14);
			contentPane.add(lblAddress);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPhoneNumber.setBounds(122, 272, 144, 14);
			contentPane.add(lblPhoneNumber);
			
			 textField_id = new JTextField();
			textField_id.setBounds(239, 112, 285, 20);
			contentPane.add(textField_id);
			textField_id.setColumns(10);
			textField_id.setEditable(false);
			
			textField_1_fn = new JTextField();
			textField_1_fn.setBounds(239, 145, 285, 20);
			contentPane.add(textField_1_fn);
			textField_1_fn.setColumns(10);
			
			textField_2_cmp = new JTextField();
			textField_2_cmp.setBounds(239, 214, 285, 20);
			contentPane.add(textField_2_cmp);
			textField_2_cmp.setColumns(10);
			
			textField_3_tin = new JTextField();
			textField_3_tin.setBounds(239, 245, 285, 20);
			contentPane.add(textField_3_tin);
			textField_3_tin.setColumns(10);
			
			textField_4_ph = new JTextField();
			textField_4_ph.setBounds(239, 274, 285, 20);
			contentPane.add(textField_4_ph);
			textField_4_ph.setColumns(10);
			
			JLabel lblGender = new JLabel("Company Name");
			lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblGender.setBounds(122, 214, 144, 14);
			contentPane.add(lblGender);
			
			JLabel lblTotalNoOf = new JLabel("Address");
			lblTotalNoOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTotalNoOf.setBounds(122, 309, 144, 14);
			contentPane.add(lblTotalNoOf);
			
			textField_5_addr = new JTextField();
			textField_5_addr.setBounds(239, 305, 285, 50);
			contentPane.add(textField_5_addr);
			textField_5_addr.setColumns(10);
			
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLastName.setBounds(122, 178, 144, 14);
			contentPane.add(lblLastName);
			
			textField_7_ln = new JTextField();
			textField_7_ln.setBounds(239, 175, 285, 20);
			contentPane.add(textField_7_ln);
			textField_7_ln.setColumns(10);
			
			JButton button = new JButton("BACK");
			button.setBounds(12, 364, 127, 35);
			contentPane.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						SearchCustomer frame = new SearchCustomer();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
			String y=String.valueOf(x);
			textField_id.setText(y);
					
			JButton btnDone = new JButton("ADD");
			btnDone.setBounds(395, 364, 127, 35);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						String id=textField_id.getText();
						String f_name=textField_1_fn.getText();
						String l_name=textField_7_ln.getText();
						String cmp=textField_2_cmp.getText();
						String tin=textField_3_tin.getText();
						String ph=textField_4_ph.getText();
						String addr=textField_5_addr.getText();
						
						
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","9448497388Vk");  
						PreparedStatement st=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)" );
						st.setString(1, id);
						st.setString(2, f_name);
						st.setString(3, l_name);						
						st.setString(4, cmp);
						st.setString(5,tin);
						st.setString(6, ph);
						st.setString(7, addr);
						
						st.executeQuery();
						
						con.close();
					
						SearchCustomer frame = new SearchCustomer();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
			
		}

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}