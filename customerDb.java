package again;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.sql.DataSource;

public class customerDb {

	private DataSource dataSource;
	
	public customerDb(DataSource theDataSource){
		dataSource = theDataSource;
	}
	public List<customer> conform(customer Customer) throws Exception{
		List<customer> lcustomer=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Customer where name=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, Customer.getName());
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int id=myRs.getInt("id");
				String name=myRs.getString("name");
				String email=myRs.getString("email");
				String phoneNumber=myRs.getString("phoneNumber");
				String account=myRs.getString("account");
				String password=myRs.getString("password");
				customer c=new customer(id,name,email,phoneNumber,account,password);
				lcustomer.add(c);
			}
			myConn.close();
			myStmt.close();
			myRs.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return lcustomer;
	}
	public int addcustomer(customer c) throws Exception {
		List<customer> acstomer=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		PreparedStatement myS=null;
		ResultSet myRs=null;
		int id=0;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="insert into Customer (name,email,phoneNumber,account,password) values(?,?,?,?,?)";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, c.getName());
			myStmt.setString(2, c.getEmail());
			myStmt.setString(3, c.getPhoneNumber());
			myStmt.setString(4, c.getAccount());
			myStmt.setString(5, c.getPassword());
			myStmt.execute();
			String sql1="select * from Customer where name=?";
			myS=myConn.prepareStatement(sql1);
			myS.setString(1, c.getName());
			myRs=myS.executeQuery();
			while(myRs.next()){
				id=myRs.getInt("id");
				String name=myRs.getString("name");
				String email=myRs.getString("email");
				String phoneNumber=myRs.getString("phoneNumber");
				String account=myRs.getString("account");
				customer cu=new customer(id,name,email,phoneNumber,account);
				acstomer.add(cu);
			}
			myConn.close();
			myStmt.close();
			myRs.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return id;
	}
	public int test(String name, String password) {
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		int te = 0;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			List<customer> c=new ArrayList<>();
			String sql="select * from Customer where password=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, password);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				String id=myRs.getString("id");
				te++;
			}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		
		return te;
	}
	public List<customer> getId(String username) {

		List<customer> cd=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement mySmt=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Customer where name=?";
			mySmt=myConn.prepareStatement(sql) ;
			mySmt.setString(1,username);
			myRs=mySmt.executeQuery();
			while(myRs.next()){
				int id=myRs.getInt("id");
				customer o=new customer(id,username);
				cd.add(o);
			}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return cd;
	}
}
