package kletech;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierDetails extends JFrame implements ActionListener{
	Connection con=null;
	ResultSet rs=null;
	java.sql.Statement stmt=null; 
	
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;


		/*SupplierDetails(String id,String fname,String lname,String phone,String place){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblShriGodachiVeerabhadreshwar = new JLabel("SHRI GODACHI VEERABHADRESHWAR INDUSTRY ");
			lblShriGodachiVeerabhadreshwar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblShriGodachiVeerabhadreshwar.setBounds(63, 11, 379, 44);
			contentPane.add(lblShriGodachiVeerabhadreshwar);
			
			JLabel lblSupplierId = new JLabel("Supplier ID");
			lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSupplierId.setBounds(122, 114, 97, 14);
			contentPane.add(lblSupplierId);
			
			JLabel lblSupplierName = new JLabel("First Name");
			lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSupplierName.setBounds(122, 154, 97, 14);
			contentPane.add(lblSupplierName);
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLastName.setBounds(122, 199, 97, 14);
			contentPane.add(lblLastName);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPhoneNumber.setBounds(122, 238, 97, 14);
			contentPane.add(lblPhoneNumber);
			
			JLabel lblPlace = new JLabel("Place");
			lblPlace.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPlace.setBounds(122, 288, 97, 14);
			contentPane.add(lblPlace);
			
			
			
			
			textField = new JTextField();
			textField.setBounds(308, 112, 134, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setEditable(false);
			
			textField_1 = new JTextField();
			textField_1.setBounds(308, 155, 134, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setEditable(false);
						
			textField_2 = new JTextField();
			textField_2.setBounds(308, 197, 134, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			textField_2.setEditable(false);
			
			textField_3 = new JTextField();
			textField_3.setBounds(308, 239, 134, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			textField_3.setEditable(false);
			
			textField_4 = new JTextField();
			textField_4.setBounds(308, 286, 134, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			textField_4.setEditable(false);
			
			JButton button = new JButton("BACK");
			button.setBounds(12, 364, 127, 35);
			contentPane.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						SearchSupplier frame = new SearchSupplier();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
			
			textField.setText(id);
			textField_1.setText(fname);
			textField_2.setText(lname);
			textField_3.setText(phone);
			textField_4.setText(place);
			
			JButton btnDone = new JButton("Update Details");
			btnDone.setBounds(395, 364, 127, 35);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						String id=textField.getText();
						String fname=textField_1.getText();
						String lname=textField_2.getText();
						String ph=textField_3.getText();
						String addr=textField_4.getText();
						SupplierDetails frame = new SupplierDetails(id,fname,lname,ph,addr,"edit");
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
			
		}*/
		
		SupplierDetails(String id,String fname,String lname,String phone,String place){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblShriGodachiVeerabhadreshwar = new JLabel("SHRI GODACHI VEERABHADRESHWAR INDUSTRY ");
			lblShriGodachiVeerabhadreshwar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblShriGodachiVeerabhadreshwar.setBounds(63, 11, 379, 44);
			contentPane.add(lblShriGodachiVeerabhadreshwar);
			
			JLabel lblSupplierId = new JLabel("Supplier ID");
			lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSupplierId.setBounds(122, 114, 97, 14);
			contentPane.add(lblSupplierId);
			
			JLabel lblSupplierName = new JLabel("First Name");
			lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSupplierName.setBounds(122, 154, 97, 14);
			contentPane.add(lblSupplierName);
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLastName.setBounds(122, 199, 97, 14);
			contentPane.add(lblLastName);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPhoneNumber.setBounds(122, 238, 97, 14);
			contentPane.add(lblPhoneNumber);
			
			JLabel lblPlace = new JLabel("Place");
			lblPlace.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPlace.setBounds(122, 288, 97, 14);
			contentPane.add(lblPlace);
			
			
			
			
			textField = new JTextField();
			textField.setBounds(308, 112, 134, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setEditable(false);
			
			textField_1 = new JTextField();
			textField_1.setBounds(308, 155, 134, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		
						
			textField_2 = new JTextField();
			textField_2.setBounds(308, 197, 134, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
						
			textField_3 = new JTextField();
			textField_3.setBounds(308, 239, 134, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			
			textField_4 = new JTextField();
			textField_4.setBounds(308, 286, 134, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			
			JButton button = new JButton("BACK");
			button.setBounds(12, 364, 127, 35);
			contentPane.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						SearchSupplier frame = new SearchSupplier();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
			
			
			textField.setText(id);
			textField_1.setText(fname);
			textField_2.setText(lname);
			textField_3.setText(phone);
			textField_4.setText(place);
			
			JButton btnDone = new JButton("Update Details");
			btnDone.setBounds(395, 364, 127, 35);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						String f_name=textField_1.getText();
						String l_name=textField_2.getText();
						String phno=textField_3.getText();
						String addr=textField_4.getText();
						
						
						String id=(textField.getText());
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","9448497388Vk");  
						PreparedStatement st=con.prepareStatement("update Supplier set fname=?,lname=?,phone_no=?,place=? where supl_id=?");
						st.setString(5, id);
						st.setString(1, f_name);
						st.setString(2, l_name);						
						st.setString(3, phno);
						st.setString(4,addr);
						
						ResultSet rs=st.executeQuery();
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
		
		SupplierDetails(int x){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblShriGodachiVeerabhadreshwar = new JLabel("SHRI GODACHI VEERABHADRESHWAR INDUSTRY ");
			lblShriGodachiVeerabhadreshwar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblShriGodachiVeerabhadreshwar.setBounds(63, 11, 379, 44);
			contentPane.add(lblShriGodachiVeerabhadreshwar);
			
			JLabel lblSupplierId = new JLabel("Supplier ID");
			lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSupplierId.setBounds(122, 114, 97, 14);
			contentPane.add(lblSupplierId);
			
			JLabel lblSupplierName = new JLabel("First Name");
			lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSupplierName.setBounds(122, 154, 97, 14);
			contentPane.add(lblSupplierName);
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLastName.setBounds(122, 199, 97, 14);
			contentPane.add(lblLastName);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPhoneNumber.setBounds(122, 238, 97, 14);
			contentPane.add(lblPhoneNumber);
			
			JLabel lblPlace = new JLabel("Place");
			lblPlace.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPlace.setBounds(122, 288, 97, 14);
			contentPane.add(lblPlace);
			
			
			
			
			textField = new JTextField();
			textField.setBounds(308, 112, 134, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setEditable(false);
			
			textField_1 = new JTextField();
			textField_1.setBounds(308, 155, 134, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
						
			textField_2 = new JTextField();
			textField_2.setBounds(308, 197, 134, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			
			textField_3 = new JTextField();
			textField_3.setBounds(308, 239, 134, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			
			textField_4 = new JTextField();
			textField_4.setBounds(308, 286, 134, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			
			
			JButton button = new JButton("BACK");
			button.setBounds(12, 364, 127, 35);
			contentPane.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						SearchSupplier frame = new SearchSupplier();
						frame.setVisible(true);
					}catch(Exception e){
						e.printStackTrace();
					}

					setVisible(false);
				}
			});
			String y=String.valueOf(x);
			textField.setText(y);
					
			JButton btnDone = new JButton("ADD");
			btnDone.setBounds(395, 364, 127, 35);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						String id=(textField.getText());
						String f_name=textField_1.getText();
						String l_name=textField_2.getText();
						String phno=textField_3.getText();
						String addr=textField_4.getText();
						
						
						
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","9448497388Vk");  
						PreparedStatement st=con.prepareStatement("insert into Supplier values(?,?,?,?,?)" );
						st.setString(1, id);
						st.setString(2, f_name);
						st.setString(3, l_name);						
						st.setString(4, phno);
						st.setString(5,addr);
						
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