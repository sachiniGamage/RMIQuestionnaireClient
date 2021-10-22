package com.hospital.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.hospital.rmiinterface.RMIInterface;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class S_Dashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S_Dashboard window = new S_Dashboard();
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
	public S_Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int questionId = 1;
		frame = new JFrame();
		frame.setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(157, 11, 93, 14);
		frame.getContentPane().add(lblNewLabel);
		
		//back -button
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLoginGUI q8 = new AdminLoginGUI();
				q8.mainLogin(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 52, 23);
		frame.getContentPane().add(btnNewButton);
		
		//option button
		JButton btnNewButton_1 = new JButton("Option");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				OptionGui option = new OptionGui();
				option.main(null);
				frame.dispose();
			}
		});

		btnNewButton_1.setBounds(335, 8, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Que1", "Que2", "Que3", "Que4", "Que5", "Que6", "Que7", "Que8"}));
		comboBox.setBounds(96, 94, 89, 22);
		frame.getContentPane().add(comboBox);
		
		//analyze button
		JButton btnNewButton_2 = new JButton("Analyze");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String que = comboBox.getSelectedItem().toString();
				try {
					RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
					
					if(que == "Que1") {
						System.out.println("barChart");
						int[] arr = RMIInterface.BarChart(1);
//						bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
						dataset .setValue(arr[0], "", "Very satisfied");
						dataset .setValue(arr[1], "", "Satisfied");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image 
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						frame.setSize(300,300);
						
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
						
					}else if(que == "Que2") {
						
						int[] arr = RMIInterface.BarChart(2);
						//bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					
						dataset .setValue(arr[0], "", "Very satisfied");
						dataset .setValue(arr[1], "", "Satisfied");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						
						frame.setSize(300,300);
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
					}else if(que == "Que3") {
						
						int[] arr = RMIInterface.BarChart(3);
						//bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
						dataset .setValue(arr[0], "", "Very satisfied");
						dataset .setValue(arr[1], "", "Satisfied");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						frame.setSize(300,300);
						
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
					}else if(que == "Que4") {
						
						int[] arr = RMIInterface.BarChart(4);
						//bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					
						dataset .setValue(arr[0], "", "Very satisfied");
						dataset .setValue(arr[1], "", "Satisfied");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						frame.setSize(300,300);
						
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
					}else if(que == "Que5") {
						
						int[] arr = RMIInterface.BarChart(5);
						//bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
						dataset .setValue(arr[0], "", "Very satisfied");
						dataset .setValue(arr[1], "", "Satisfied");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						frame.setSize(300,300);
						
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
					}else if(que == "Que6") {

						int[] arr = RMIInterface.BarChart(6);
						//bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				
						dataset .setValue(arr[0], "", "Very satisfied");
						dataset .setValue(arr[1], "", "Satisfied");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						frame.setSize(300,300);
						
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
					}else if(que == "Que7") {
						
						int[] arr = RMIInterface.BarChart(7);
						//bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
						dataset .setValue(arr[0], "", "Very satisfied");
						dataset .setValue(arr[1], "", "Satisfied");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						frame.setSize(300,300);
						
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
					}else if(que == "Que8") {
						
						int[] arr = RMIInterface.BarChart(8);
						//bar chart
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
						dataset .setValue(arr[0], "", "Yes");
						dataset .setValue(arr[1], "", "No");
						dataset .setValue(arr[2], "", "Neutral");
						dataset .setValue(arr[3], "", "Unsatisfied");
						dataset .setValue(arr[4], "", "Very unsatisfied");
						
						System.out.println("barChart2");
						
						JFreeChart chart = ChartFactory.createBarChart("FeedBack", "Satisfaction", "Count", dataset, PlotOrientation.VERTICAL, false, true, false); 
						
						System.out.println("barChart3");
						//image
						chart.setBackgroundPaint(Color.black);
						chart.getTitle().setPaint(Color.white);
						CategoryPlot p = chart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.red);
						ChartFrame frame = new ChartFrame("FeedBack Count", chart);
						frame.setVisible(true);
						frame.setSize(300,300);
						
						int width = 640;    /* Width of the image */
					    int height = 480;   /* Height of the image */ 
					    File BarChart = new File("BarChart.jpeg");
					    ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
					    System.out.println("Image created");
					    
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Run Server First", "ALERT",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(212, 94, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		//email
		
		JButton btnNewButton_3 = new JButton("Email");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RMIInterface RMIInterface = (RMIInterface)Naming.lookup("rmi://localhost:5099/hello");
					String que = comboBox.getSelectedItem().toString();
					int questionId = Integer.parseInt(String.valueOf(que.charAt(que.length()-1)));
					RMIInterface.Email(questionId);
					System.out.println("Email sent!");
				}catch(Exception e1) {
					System.out.println(e1);
					System.out.println("error-Email");
				}
			}
		});
		btnNewButton_3.setBounds(335, 34, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
	}
}
