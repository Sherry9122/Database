package again;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class restaurantDb {

private DataSource dataSource;
	
	public restaurantDb(DataSource theDataSource){
		dataSource = theDataSource;
	}
	public List<restaurant> get_restaurant(String username) throws Exception{
		List<restaurant> lrestaurant=new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Restaurant";
			myStmt=myConn.createStatement();
			myRs=myStmt.executeQuery(sql);
			while(myRs.next()){
				int id=myRs.getInt("id");
				String name=myRs.getString("name");
				int averagePrice=myRs.getInt("averagePrice");
				String phoneNumber=myRs.getString("phoneNumber");
				String openingHour=myRs.getString("openingHour");
				String type=myRs.getString("type");
				restaurant a= new restaurant(id,name,averagePrice,phoneNumber,openingHour,type,username);
				lrestaurant.add(a);
			}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		myConn.close();
		myStmt.close();
		myRs.close();
		return lrestaurant;
	}
	public List<restaurant> search_restaurant(String type,String username) {
		List<restaurant> lrestaur=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		Statement my=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Restaurant where type=?";
			myStmt=myConn.prepareStatement(sql);
			my=myConn.createStatement();
			//myRs=my.executeQuery(sql1);
			myStmt.setString(1, type);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int id=myRs.getInt("id");
				String name=myRs.getString("name");
				int averagePrice=myRs.getInt("averagePrice");
				String phoneNumber=myRs.getString("phoneNumber");
				String openingHour=myRs.getString("openingHour");
				String type1=myRs.getString("type");
				restaurant w=new restaurant(id,name,averagePrice,phoneNumber,openingHour,type1,username);
				lrestaur.add(w);
			}
			myConn.close();
			myStmt.close();
			myRs.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return lrestaur;
	}
	public List<restaurant> search(int id) {
		List<restaurant> lrestaur=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Restaurant where id=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int idw=myRs.getInt("id");
				String name=myRs.getString("name");
				int averagePrice=myRs.getInt("averagePrice");
				String phoneNumber=myRs.getString("phoneNumber");
				String openingHour=myRs.getString("openingHour");
				String type1=myRs.getString("type");
				restaurant w=new restaurant(idw,name,averagePrice,phoneNumber,openingHour,type1);
				lrestaur.add(w);
			}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return lrestaur;
	}
	public List<restaurant> name_restaurant(String name, String username) {
		List<restaurant> lrestaur=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Restaurant r where r.name like ?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, "%"+name+"%");
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int id=myRs.getInt("id");
				String name1=myRs.getString("name");
				int averagePrice=myRs.getInt("averagePrice");
				String phoneNumber=myRs.getString("phoneNumber");
				String openingHour=myRs.getString("openingHour");
				String type1=myRs.getString("type");
				restaurant w=new restaurant(id,name1,averagePrice,phoneNumber,openingHour,type1,username);
				lrestaur.add(w);
			}
			myConn.close();
			myStmt.close();
			myRs.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return lrestaur;
	}
}
