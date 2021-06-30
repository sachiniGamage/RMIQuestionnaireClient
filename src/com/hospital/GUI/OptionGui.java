package com.hospital.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.hospital.DB.DBConnection;
import com.hospital.rmiinterface.RMIInterface;

//import com.hospital.server.DBConnection;

import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

public class OptionGui {

	private JFrame frame;
	private JTextField textField;
	PreparedStatement pst;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionGui window = new OptionGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection con ;
private JTextField textField_1;
	/**
	 * Create the application.
	 */
	public OptionGui() {
		initialize();
		con = DBConnection.dBConnector();
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
		
		JLabel lblNewLabel = new JLabel("Options");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(193, 11, 91, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edit questions");
		lblNewLabel_1.setBounds(22, 38, 114, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(133, 98, 229, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Question:");
		lblNewLabel_2.setBounds(45, 101, 63, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Question ID");
		lblNewLabel_4.setBounds(45, 76, 91, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 73, 229, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		//edit button
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        ResultSet rs = null;
		        String ans = null;
		        
		        String que = textField.getText(); 
		        
		        int queID = Integer.parseInt(textField_1.getText());
		        
		        try {
		        
		        	RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
					System.out.println("1");
					
					
					RMIInterface.UpdateQue(queID, que);
					
					JOptionPane.showMessageDialog(null, "Updated");

		        	
		        	
		        }catch(Exception e1) {
		        	System.out.println( e1);
		        }
			}
			
		});
		btnNewButton.setBounds(294, 165, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		//back button
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				S_Dashboard q8 = new S_Dashboard();
				q8.main(null);
				frame.dispose();
			}
			
		});
		btnNewButton_1.setBounds(10, 8, 46, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		//clear button
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton_2.setBounds(84, 165, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
	}
}
