package kletech;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SearchCustomer extends JFrame implements ActionListener {
	Connection con=null;
	ResultSet rs=null;
	java.sql.Statement stmt=null; 
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	
	public SearchCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblShriGodachiVeerabhadreshwar = new JLabel("SHRI GODACHI VEERABHADRESHWAR INDUSTRY");
		lblShriGodachiVeerabhadreshwar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblShriGodachiVeerabhadreshwar.setBounds(20, 11, 392, 40);
		contentPane.add(lblShriGodachiVeerabhadreshwar);
		
		JLabel lblEmployeeId = new JLabel("Customer ID :");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeId.setBounds(20, 110, 99, 23);
		contentPane.add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(129, 112, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelectConfiguration frame = new SelectConfiguration();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(30, 214, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(225, 213, 120, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","9448497388Vk");  
					PreparedStatement st=con.prepareStatement("select count(*) from customer");
					//System.out.println(id);
					ResultSet rs=st.executeQuery();  
					if(rs.next()){
						int x=rs.getInt(1);
							
					try {
						CustomerDetails frame = new CustomerDetails(x+1);
							frame.setVisible(true);
						}
					catch (Exception e) {
							e.printStackTrace();
					}
					
					setVisible(false);
					con.close();
					
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});

		
		
		
		JButton btnNext = new JButton("UPDATE");
		btnNext.setBounds(237, 110, 108, 23);
		contentPane.add(btnNext);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(374, 115, 351, 308);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRefe = new JButton("VEIW ALL");
		btnRefe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
							String query= "select * from customer";
							Class.forName("oracle.jdbc.driver.OracleDriver"); 
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","9448497388Vk");  
							PreparedStatement pst = con.prepareStatement(query);
							rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}catch(Exception ae){
						JOptionPane.showMessageDialog(null, ae);
					}
				
			}
		});
		btnRefe.setBounds(581, 80, 89, 23);
		contentPane.add(btnRefe);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					String s=textField_1.getText();
					String query= "select * from customer where lower(fname) like lower('"+s+"%')";
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","9448497388Vk");  
					PreparedStatement pst = con.prepareStatement(query);
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception ae){
				JOptionPane.showMessageDialog(null, ae);
			}
		
			}
		});
		textField_1.setBounds(428, 84, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				
				try{
					String id=(textField.getText());
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","9448497388Vk");  
					PreparedStatement st=con.prepareStatement("select * from customer where cust_id=?");
					st.setString(1,id);	
					//System.out.println(id);
					ResultSet rs=st.executeQuery();  
					if(rs.next()){
						String Id=rs.getString(1);
						String fname=rs.getString(2);
						String lname=rs.getString(3);
						String cmp=rs.getString(4);
						String tin=rs.getString(5);
						String ph=rs.getString(6);
						String addr=rs.getString(7);
						try {
									CustomerDetails frame = new CustomerDetails(Id,fname,lname,cmp,tin,ph,addr);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
					
						setVisible(false);
					
					}
					else{
						JOptionPane.showMessageDialog(null,"ID NOT FOUND");
					}
					con.close();
				
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCustomer frame = new SearchCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	

	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}