package com.hospital.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.hospital.DB.*;
import com.hospital.DB.DBConnection;
import com.hospital.rmiinterface.RMIInterface;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class AdminLoginGUI {
	/**
	 * Constructor	
	 */

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void mainLogin(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginGUI window = new AdminLoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(179, 34, 106, 14);
		frame.getContentPane().add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("UserName:");
		lblNewLabel_1.setBounds(65, 97, 65, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(65, 136, 65, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(179, 94, 158, 20);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 133, 158, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1
				String userName = txtUserName.getText();
				String pw  = passwordField.getText();
  
				//validation - password
				if(txtUserName.getText().equals("")|| !txtUserName.getText().matches("[a-zA-Z_]+") || passwordField.getText().equals("") 
						|| !passwordField.getText().matches("[0-9]+") || passwordField.getText().length() != 4 ) {
					JOptionPane.showMessageDialog(null,"Invalid name and the password ");
				}else {
					try {
						RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
						System.out.println("1");
						if(RMIInterface.login(userName.toString(), pw.toString())) {

								txtUserName.setText(userName);
								passwordField.setText(pw);
							frame.dispose();
							S_Dashboard q8 = new S_Dashboard();
							q8.main(null);
							frame.setVisible(true);
							frame.dispose();
							
							
						}
						
					}catch (Exception e1) {
						// TODO: handle exception
						System.out.println(e1);
					}
//				
				}
			}
		});
		btnNewButton.setBounds(169, 193, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		//back button
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				IndexGUI q8 = new IndexGUI();
				q8.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 46, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
