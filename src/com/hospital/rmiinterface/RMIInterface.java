package com.hospital.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RMIInterface extends Remote{
//	public String echo(String i) throws RemoteException;
	
//	public String viewAns() throws RemoteException;
	
	public String que1(String q1) throws RemoteException;
	
	public String que2(String q2) throws RemoteException;
	
	public String que3(String q3) throws RemoteException;
	
	public String que4(String q4) throws RemoteException;
	
	public String que5(String q5) throws RemoteException;
	
	public String que6(String q6) throws RemoteException;
	
	public String que7(String q7) throws RemoteException;
	
	public String que8(String q8) throws RemoteException;
	
	//update que jlabel
	public String que8SQL(int no) throws RemoteException;
	
	public boolean login(String userName, String pw) throws RemoteException;
	
	public void UpdateQue( int queID, String que) throws SQLException;
	
	public String Email(int questionID) throws RemoteException;
	
	public int[] BarChart(int no) throws Exception;
	
	public String graph(int no) throws Exception;
	
	
}
