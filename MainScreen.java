package kletech;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;

import javax.swing.SwingConstants;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	final String connect1="oracle.jdbc.driver.OracleDriver";
	final String connect2="jdbc:oracle:thin:@localhost:1521/orcl"+","+"system"+","+"9448497388Vk";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewEntry = new JButton("NEW ENTRY");
		btnNewEntry.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewEntry.setBounds(10, 117, 151, 69);
		contentPane.add(btnNewEntry);
		
		JButton btnConfiguration = new JButton("CONFIGURATION");
		btnConfiguration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelectConfiguration frame = new SelectConfiguration();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		
		btnConfiguration.setBounds(452, 117, 157, 69);
		contentPane.add(btnConfiguration);
		
		JButton btnReport = new JButton("REPORT");
		btnReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportSearch frame = new ReportSearch();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnReport.setBounds(10, 364, 151, 69);
		contentPane.add(btnReport);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.setBounds(452, 364, 157, 69);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/10.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(10, 63, 611, 359);
		contentPane.add(label);
		
		JLabel lblWelcomeToShree = new JLabel("WELCOME TO SHREE GODACHCI VEERABHADRESHWARA INDUSTRY ");
		lblWelcomeToShree.setBackground(Color.GRAY);
		lblWelcomeToShree.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToShree.setForeground(Color.BLACK);
		lblWelcomeToShree.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblWelcomeToShree.setBounds(10, 0, 599, 101);
		contentPane.add(lblWelcomeToShree);
	}

}
