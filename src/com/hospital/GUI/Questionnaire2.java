package com.hospital.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;

import com.hospital.rmiinterface.RMIInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Questionnaire2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main2
	() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questionnaire2 window = new Questionnaire2();
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
	public Questionnaire2() {
		initialize();
	}
String Question2 = "";
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Questionnaire");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(159, 26, 122, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		//get the question and set it to the jlabel
		String output = null;
		try {
			RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
			
			output = RMIInterface.que8SQL(2);
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(output);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel(output);
		lblNewLabel_1.setBounds(22, 76, 224, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Very satisfied");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question2 = "Very satisfied";
			}
		});
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(115, 97, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Satisfied");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question2 = "Satisfied";
			}
		});
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(115, 123, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Neutral");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question2 = "Neutral";
			}
		});
		rdbtnNewRadioButton_2.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(115, 149, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Unsatisfied");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question2 = "Unsatisfied";
			}
		});
		rdbtnNewRadioButton_3.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_3.setForeground(Color.WHITE);
		rdbtnNewRadioButton_3.setBounds(115, 175, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		final JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Very unsatisfied");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question2 = "Very unsatisfied";
			}
		});
		rdbtnNewRadioButton_4.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_4.setForeground(Color.WHITE);
		rdbtnNewRadioButton_4.setBounds(115, 201, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans = null;
				if(rdbtnNewRadioButton.isSelected()){
					ans = rdbtnNewRadioButton.getText();
					
					try {
						RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
						String output = RMIInterface.que2(Question2);
						frame.dispose();
						Questionnaire3 q2 = new Questionnaire3();
						q2.main3();
						frame.dispose();
						
						}catch (Exception e1) {
							JOptionPane.showMessageDialog(null,"Internal error, Server is not available", " ",JOptionPane.WARNING_MESSAGE);
						}
				}
				else if(rdbtnNewRadioButton_1.isSelected()){
					ans = rdbtnNewRadioButton_1.getText();
					
					try {
						RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
						String output = RMIInterface.que2(Question2);
						frame.dispose();
						Questionnaire3 q2 = new Questionnaire3();
						q2.main3();
						frame.dispose();
						
						}catch (Exception e1) {
							JOptionPane.showMessageDialog(null,"Internal error, Server is not available", " ",JOptionPane.WARNING_MESSAGE);
						}
				}
				else if(rdbtnNewRadioButton_2.isSelected()){
					ans = rdbtnNewRadioButton_2.getText();
					
					try {
						RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
						String output = RMIInterface.que2(Question2);
						frame.dispose();
						Questionnaire3 q2 = new Questionnaire3();
						q2.main3();
						frame.dispose();
						
						}catch (Exception e1) {
							JOptionPane.showMessageDialog(null,"Internal error, Server is not available", " ",JOptionPane.WARNING_MESSAGE);
						}
				}
				else if(rdbtnNewRadioButton_3.isSelected()){
					ans = rdbtnNewRadioButton_3.getText();
					
					try {
						RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
						String output = RMIInterface.que2(Question2);
						frame.dispose();
						Questionnaire3 q2 = new Questionnaire3();
						q2.main3();
						frame.dispose();
						
						}catch (Exception e1) {
							JOptionPane.showMessageDialog(null,"Internal error, Server is not available", " ",JOptionPane.WARNING_MESSAGE);
						}
				}
				else if(rdbtnNewRadioButton_4.isSelected()){
					ans = rdbtnNewRadioButton_4.getText();
					
					try {
						RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
						String output = RMIInterface.que2(Question2);
						frame.dispose();
						Questionnaire3 q2 = new Questionnaire3();
						q2.main3();
						frame.dispose();
						
						}catch (Exception e1) {
							JOptionPane.showMessageDialog(null,"Internal error, Server is not available", " ",JOptionPane.WARNING_MESSAGE);
						}
				}
				else {
					JOptionPane.showMessageDialog(null, "please select ");
				}
				
				
				
			}
		});
		btnNewButton.setBounds(313, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Questionnaire1GUI q2 = new Questionnaire1GUI();
				q2.main1();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 41, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
