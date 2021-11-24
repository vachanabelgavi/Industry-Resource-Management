package kletech;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class SelectConfiguration extends JFrame {

	private JPanel contentPane;

	
	public SelectConfiguration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 488);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSupplier = new JButton("SUPPLIER");
		btnSupplier.setForeground(Color.CYAN);
		btnSupplier.setBackground(Color.BLACK);
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SearchSupplier frame = new SearchSupplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnSupplier.setBounds(214, 225, 170, 80);
		contentPane.add(btnSupplier);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setForeground(Color.CYAN);
		btnCustomer.setBackground(Color.BLACK);
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SearchCustomer frame = new SearchCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnCustomer.setBounds(0, 221, 170, 89);
		contentPane.add(btnCustomer);
		
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setForeground(Color.CYAN);
		btnEmployee.setBackground(Color.BLACK);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SearchEmployee frame = new SearchEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnEmployee.setBounds(417, 225, 170, 80);
		contentPane.add(btnEmployee);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.CYAN);
		Image img= new ImageIcon(this.getClass().getResource("/sky.jpg")).getImage();
		
		JButton btnSelectTheTable = new JButton("SELECT THE TABLE");
		btnSelectTheTable.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnSelectTheTable.setForeground(Color.BLACK);
		btnSelectTheTable.setBounds(157, 150, 320, 47);
		contentPane.add(btnSelectTheTable);
		
		JLabel lblConfiguration = new JLabel("CONFIGURATION");
		lblConfiguration.setForeground(new Color(153, 0, 102));
		lblConfiguration.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblConfiguration.setBounds(157, 34, 387, 80);
		contentPane.add(lblConfiguration);
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 603, 432);
		contentPane.add(label);
	}
}
