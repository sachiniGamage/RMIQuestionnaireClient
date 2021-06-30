package com.hospital.DB;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hospital.rmiinterface.RMIInterface;

public class DBConnection  {
	Connection con = null;
	ResultSet rs;
	Statement st;	
		public static Connection dBConnector()
		{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionnaire", "root", "");
			System.out.print("Connected database ");
			
			return con;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			return null;
		}

	}
}

//	@Override
//	public String echo(String i) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}

