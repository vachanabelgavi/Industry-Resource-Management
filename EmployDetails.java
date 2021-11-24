package kletech;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployDetails extends JFrame implements ActionListener{
	Connection con=null;
	ResultSet rs=null;
	java.sql.Statement stmt=null; 
	
		private JPanel contentPane;
		private JTextField textField_id;
		private JTextField textField_1_fn;
		private JTextField textField_2_gd;
		private JTextField textField_3_adr;
		private JTextField textField_4_ph;
		private JTextField textField_5_tno;
		private JTextField textField_7_ln;

		/**
		 * @wbp.parser.constructor
		 */
		EmployDetails(String id,String fname,String lname,String addr,String phone,String gen,String days){
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
			
			JLabel lblEmployeeDetails = new JLabel("Employee Details:");
			lblEmployeeDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEmployeeDetails.setBounds(73, 76, 131, 27);
			contentPane.add(lblEmployeeDetails);
			
			JLabel lblEmployeeName = new JLabel("First Name");
			lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeName.setBounds(122, 145, 97, 14);
			contentPane.add(lblEmployeeName);
			
			JLabel lblEmployeeId = new JLabel("Employee ID");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeId.setBounds(122, 114, 97, 14);
			contentPane.add(lblEmployeeId);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAddress.setBounds(122, 245, 46, 14);
			contentPane.add(lblAddress);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPhoneNumber.setBounds(122, 272, 97, 18);
			contentPane.add(lblPhoneNumber);
			
			 textField_id = new JTextField();
			textField_id.setBounds(308, 112, 86, 20);
			contentPane.add(textField_id);
			textField_id.setColumns(10);
			textField_id.setEditable(false);
			
			textField_1_fn = new JTextField();
			textField_1_fn.setBounds(308, 143, 86, 20);
			contentPane.add(textField_1_fn);
			textField_1_fn.setColumns(10);
			
			textField_2_gd = new JTextField();
			textField_2_gd.setBounds(308, 215, 86, 20);
			contentPane.add(textField_2_gd);
			textField_2_gd.setColumns(10);
			
			textField_3_adr = new JTextField();
			textField_3_adr.setBounds(308, 243, 86, 20);
			contentPane.add(textField_3_adr);
			textField_3_adr.setColumns(10);
			
			textField_4_ph = new JTextField();
			textField_4_ph.setBounds(308, 272, 86, 20);
			contentPane.add(textField_4_ph);
			textField_4_ph.setColumns(10);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblGender.setBounds(122, 214, 46, 20);
			contentPane.add(lblGender);
			
			JLabel lblTotalNoOf = new JLabel("Total No Of Working Days");
			lblTotalNoOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTotalNoOf.setBounds(122, 330, 156, 14);
			contentPane.add(lblTotalNoOf);
			
			textField_5_tno = new JTextField();
			textField_5_tno.setBounds(308, 328, 86, 20);
			contentPane.add(textField_5_tno);
			textField_5_tno.setColumns(10);
			
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLastName.setBounds(122, 178, 72, 14);
			contentPane.add(lblLastName);
			
			textField_7_ln = new JTextField();
			textField_7_ln.setBounds(308, 173, 86, 20);
			contentPane.add(textField_7_ln);
			textField_7_ln.setColumns(10);
			
			JButton button = new JButton("BACK");
			button.setBounds(12, 364, 127, 35);
			contentPane.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						SearchEmployee frame = new SearchEmployee();
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
			textField_2_gd.setText(gen);
			textField_3_adr.setText(addr);
			textField_4_ph.setText(phone);
			textField_5_tno.setText(days);
			
			JButton btnDone = new JButton("Update Details");
			btnDone.setBounds(395, 364, 127, 35);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						String f_name=textField_1_fn.getText();
						String l_name=textField_7_ln.getText();
						String gn=textField_2_gd.getText();
						String addr=textField_3_adr.getText();
						String ph=textField_4_ph.getText();
						String tno=textField_5_tno.getText();
						
						String id=(textField_id.getText());
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","9448497388Vk");  
						PreparedStatement st=con.prepareStatement("update employee set first_name=?,last_name=?,address=?,ph_no=?,total_working_days=?,gender=? where emp_id=?");
						st.setString(7, id);
						st.setString(1, f_name);
						st.setString(2, l_name);						
						st.setString(3, addr);
						st.setString(4,ph);
						st.setString(5, tno);
						st.setString(6, gn);
						
						ResultSet rs=st.executeQuery();
						con.close();
						SearchEmployee frame = new SearchEmployee();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
		}
		
		EmployDetails(int x){
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
			
			JLabel lblEmployeeDetails = new JLabel("Employee Details:");
			lblEmployeeDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEmployeeDetails.setBounds(73, 76, 131, 27);
			contentPane.add(lblEmployeeDetails);
			
			JLabel lblEmployeeName = new JLabel("First Name");
			lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeName.setBounds(122, 145, 97, 14);
			contentPane.add(lblEmployeeName);
			
			JLabel lblEmployeeId = new JLabel("Employee ID");
			lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeId.setBounds(122, 114, 97, 14);
			contentPane.add(lblEmployeeId);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAddress.setBounds(122, 245, 46, 14);
			contentPane.add(lblAddress);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPhoneNumber.setBounds(122, 272, 97, 18);
			contentPane.add(lblPhoneNumber);
			
			 textField_id = new JTextField();
			textField_id.setBounds(308, 112, 86, 20);
			contentPane.add(textField_id);
			textField_id.setColumns(10);
			textField_id.setEditable(false);
			
			textField_1_fn = new JTextField();
			textField_1_fn.setBounds(308, 143, 86, 20);
			contentPane.add(textField_1_fn);
			textField_1_fn.setColumns(10);
			
			textField_2_gd = new JTextField();
			textField_2_gd.setBounds(308, 215, 86, 20);
			contentPane.add(textField_2_gd);
			textField_2_gd.setColumns(10);
			
			textField_3_adr = new JTextField();
			textField_3_adr.setBounds(308, 243, 86, 20);
			contentPane.add(textField_3_adr);
			textField_3_adr.setColumns(10);
			
			textField_4_ph = new JTextField();
			textField_4_ph.setBounds(308, 272, 86, 20);
			contentPane.add(textField_4_ph);
			textField_4_ph.setColumns(10);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblGender.setBounds(122, 214, 46, 20);
			contentPane.add(lblGender);
			
			JLabel lblTotalNoOf = new JLabel("Total No Of Working Days");
			lblTotalNoOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTotalNoOf.setBounds(122, 330, 156, 14);
			contentPane.add(lblTotalNoOf);
			
			textField_5_tno = new JTextField();
			textField_5_tno.setBounds(308, 328, 86, 20);
			contentPane.add(textField_5_tno);
			textField_5_tno.setColumns(10);
			
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLastName.setBounds(122, 178, 72, 14);
			contentPane.add(lblLastName);
			
			textField_7_ln = new JTextField();
			textField_7_ln.setBounds(308, 173, 86, 20);
			contentPane.add(textField_7_ln);
			textField_7_ln.setColumns(10);
			
			JButton button = new JButton("BACK");
			button.setBounds(12, 364, 127, 35);
			contentPane.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						SearchEmployee frame = new SearchEmployee();
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
						String id=(textField_id.getText());
						String f_name=textField_1_fn.getText();
						String l_name=textField_7_ln.getText();
						String addr=textField_3_adr.getText();
						String ph=textField_4_ph.getText();
						String gn=textField_2_gd.getText();
						String tno=textField_5_tno.getText();
						
						
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","9448497388Vk");  
						PreparedStatement st=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)" );
						st.setString(1, id);
						st.setString(2, f_name);
						st.setString(3, l_name);						
						st.setString(4, addr);
						st.setString(5,ph);
						st.setString(5,gn);
						st.setString(5,tno);
						st.executeQuery();
						
						con.close();
					
						SearchSupplier frame = new SearchSupplier();
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