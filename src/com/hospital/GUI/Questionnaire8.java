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

public class Questionnaire8 {

	private JFrame frame;
	String Question8="";
	/**
	 * Launch the application.
	 */
	public static void main8() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questionnaire8 window = new Questionnaire8();
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
	public Questionnaire8() {
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
		lblNewLabel.setBounds(170, 32, 153, 14);
		frame.getContentPane().add(lblNewLabel);
		
		//get the question and set it to the jlabel
		String output = null;
		try {
			RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
			output = RMIInterface.que8SQL(8);
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
		
		final JLabel lblNewLabel_1 = new JLabel(output);
		lblNewLabel_1.setBounds(22, 76, 390, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question8="Yes";
			}
		});
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton.setBounds(115, 97, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question8="No";
			}
		});
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setBounds(115, 123, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ans = null;
				
				try {
					RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
					String output1 = RMIInterface.que8(Question8);
					if(rdbtnNewRadioButton.isSelected()){
						ans = rdbtnNewRadioButton.getText();
						
						int dialogButton = JOptionPane.OK_OPTION;
						JOptionPane.showMessageDialog(null, "Thank You! go to index page? ");
						frame.dispose();
						IndexGUI q8 = new IndexGUI();
						q8.main(null);
						frame.setVisible(true);
						frame.dispose();
					}else if(rdbtnNewRadioButton_1.isSelected()){
						ans = rdbtnNewRadioButton_1.getText();
						
						int dialogButton = JOptionPane.OK_OPTION;
						JOptionPane.showMessageDialog(null, "Thank You! go to index page? ");
						frame.dispose();
						IndexGUI q8 = new IndexGUI();
						q8.main(null);
						frame.setVisible(true);
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "please select ");
					}
				
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Please Run the Server", " ",JOptionPane.WARNING_MESSAGE);
				}
				
					
			}
				
		}
	);
		btnNewButton.setBounds(313, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Questionnaire7 q8 = new Questionnaire7();
				q8.main7();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 41, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
