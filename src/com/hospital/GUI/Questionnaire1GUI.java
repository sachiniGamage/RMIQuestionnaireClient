package com.hospital.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


import com.hospital.DB.DBConnection;
import com.hospital.rmiinterface.RMIInterface;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Questionnaire1GUI {

	private JFrame frame;
	String Question1="";
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questionnaire1GUI window = new Questionnaire1GUI();
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
	public Questionnaire1GUI() {
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
		
		JLabel lblNewLabel = new JLabel("Questionnaire");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(170, 32, 138, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		//get the question and set it to the jlabel
		String output = null;
		try {
			RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
			
			output = RMIInterface.que8SQL(1);
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
		lblNewLabel_1.setBounds(22, 76, 263, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JRadioButton rdoVerySatisfied = new JRadioButton("Very satisfied");
		rdoVerySatisfied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Question1 = "Very satisfied";
				
			}
		});
		rdoVerySatisfied.setForeground(Color.WHITE);
		rdoVerySatisfied.setBackground(Color.DARK_GRAY);
		rdoVerySatisfied.setBounds(115, 97, 109, 23);
		frame.getContentPane().add(rdoVerySatisfied);
		
		final JRadioButton rdoSatisfied = new JRadioButton("Satisfied");
		rdoSatisfied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question1 = "Satisfied";
			}
		});
		rdoSatisfied.setBackground(Color.DARK_GRAY);
		rdoSatisfied.setForeground(Color.WHITE);
		rdoSatisfied.setBounds(115, 123, 109, 23);
		frame.getContentPane().add(rdoSatisfied);
		
		final JRadioButton rdoNeutral = new JRadioButton("Neutral");
		rdoNeutral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question1 = "Neutral";
			}
		});
		rdoNeutral.setBackground(Color.DARK_GRAY);
		rdoNeutral.setForeground(Color.WHITE);
		rdoNeutral.setBounds(115, 149, 109, 23);
		frame.getContentPane().add(rdoNeutral);
		
		final JRadioButton rdoUnsatisfied = new JRadioButton("Unsatisfied");
		rdoUnsatisfied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question1 = "Unsatisfied";
			}
		});
		rdoUnsatisfied.setBackground(Color.DARK_GRAY);
		rdoUnsatisfied.setForeground(Color.WHITE);
		rdoUnsatisfied.setBounds(115, 175, 109, 23);
		frame.getContentPane().add(rdoUnsatisfied);
		
		final JRadioButton rdoVeryUnsatisfied = new JRadioButton("Very unsatisfied");
		rdoVeryUnsatisfied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question1 = "Very unsatisfied";
			}
		});
		rdoVeryUnsatisfied.setBackground(Color.DARK_GRAY);
		rdoVeryUnsatisfied.setForeground(Color.WHITE);
		rdoVeryUnsatisfied.setBounds(115, 201, 109, 23);
		frame.getContentPane().add(rdoVeryUnsatisfied);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				Statement statement = null;
				String ans = null;
				
				try {
					RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
					String output = RMIInterface.que1(Question1);
				
				if(rdoVerySatisfied.isSelected()){
					ans = rdoVerySatisfied.getText();
					
					 
						frame.dispose();
						Questionnaire2 q1 = new Questionnaire2();
						q1.main2();
						frame.dispose();
						
						
					
					
				}
				else if(rdoSatisfied.isSelected()){
					ans = rdoVerySatisfied.getText();
					
					
						frame.dispose();
						Questionnaire2 q1 = new Questionnaire2();
						q1.main2();
						frame.dispose();
						
						
				}
				else if(rdoNeutral.isSelected()){
					ans = rdoVerySatisfied.getText();
					
					
						frame.dispose();
						Questionnaire2 q1 = new Questionnaire2();
						q1.main2();
						frame.dispose();
						
						
				}
				else if(rdoUnsatisfied.isSelected()){
					ans = rdoVerySatisfied.getText();
					
					
						frame.dispose();
						Questionnaire2 q1 = new Questionnaire2();
						q1.main2();
						frame.dispose();
						
						
				}
				else if(rdoVeryUnsatisfied.isSelected()){
					ans = rdoVerySatisfied.getText();
					
					
						frame.dispose();
						Questionnaire2 q1 = new Questionnaire2();
						q1.main2();
						frame.dispose();
						
						
				}
				else {
					JOptionPane.showMessageDialog(null, "please select ");
				}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Internal error, Server is not available", " ",JOptionPane.WARNING_MESSAGE);
				}

				
				
			}
		});
		btnNewButton.setBounds(313, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		//back button
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				IndexGUI q1 = new IndexGUI();
				q1.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 41, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
