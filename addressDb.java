package again;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.sql.DataSource;

public class addressDb {

	private DataSource dataSource;
	
	public addressDb(DataSource theDataSource){
		dataSource = theDataSource;
	}
	public List<address> get_address() throws Exception{
		List<address> laddress=new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Address";
			myStmt=myConn.createStatement();
			myRs=myStmt.executeQuery(sql);
			while(myRs.next()){
				int id=myRs.getInt("id");
				String state=myRs.getString("state");
				String city=myRs.getString("city");
				String zipcode=myRs.getString("zipcode");
				String street=myRs.getString("street");
				String number=myRs.getString("number");
				int addressOfRestaurant=myRs.getInt("addressOfRestaurant");
				int addressOfCustomer=myRs.getInt("addressOfCustomer");
				address a= new address(id,state,city,zipcode,street,number,addressOfRestaurant,addressOfCustomer);
				laddress.add(a);
			}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		myConn.close();
		myStmt.close();
		myRs.close();
		return laddress;
	}
	public List<address> selectCity(String city) throws Exception{
		List<address> baddress=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Address where city=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, city);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int id=myRs.getInt("id");
				String state=myRs.getString("state");
				String cityo=myRs.getString("city");
				String zipcode=myRs.getString("zipcode");
				String street=myRs.getString("street");
				String number=myRs.getString("number");
				int addressOfRestaurant=myRs.getInt("addressOfRestaurant");
				int addressOfCustomer=myRs.getInt("addressOfCustomer");
				address a= new address(id,state,cityo,zipcode,street,number,addressOfRestaurant,addressOfCustomer);
				baddress.add(a);
			}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return baddress;
	}
	public void addAddress(address a,int id) {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="insert into Address(state,city,zipcode,street,number,addressOfCustomer) values(?,?,?,?,?,?)";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1,a.getState());
			myStmt.setString(2,a.getCity());
			myStmt.setString(3,a.getZipcode());
			myStmt.setString(4,a.getStreet());
			myStmt.setString(5, a.getNumber());
			myStmt.setInt(6, id);
			myStmt.executeUpdate();
			myConn.close();
			myStmt.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}
	public void addaddress(address a) {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="insert into Address (state,city,zipcode,street,number) values(?,?,?,?,?)";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, a.getState());
			myStmt.setString(2, a.getCity());
			myStmt.setString(3, a.getZipcode());
			myStmt.setString(4, a.getStreet());
			myStmt.setString(5, a.getNumber());
			myStmt.execute();
			myConn.close();
			myStmt.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}
}
