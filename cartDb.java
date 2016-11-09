package again;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class cartDb {

private DataSource dataSource;
	
	public cartDb(DataSource theDataSource){
		dataSource = theDataSource;
	}
	
	public List<cart> listCart(String user) {
		List<cart> car=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select m.id,m.menu,o.customer,m.name,o.quantity,m.picture ,m.price,r.name as restaurant,m.course,m.description from Menu m,Orders o,Restaurant r where exists(select * from Customer c where c.name=? and c.id=o.customer and m.id=o.menu and m.menu=r.id)";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, user);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int id=myRs.getInt("id");
				int menu=myRs.getInt("menu");
				int customer=myRs.getInt("customer");
				String name=myRs.getString("name");
				int quantity=myRs.getInt("quantity");
				int price=myRs.getInt("price");
				String course=myRs.getString("course");
				String description=myRs.getString("description");
				String restaurant=myRs.getString("restaurant");
				String picture=myRs.getString("picture");
				cart cs=new cart(menu,customer,quantity,name,id,price,course,description,user,restaurant,picture);
				car.add(cs);
			}
			myConn.close();
			myStmt.close();
			myRs.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return car;
		
	}

	public void add(int userId, int id) {
		List<cart> car=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="INSERT INTO `project`.`Orders` (`menu`, `customer`, `quantity`) VALUES (?, ?, '1')";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myStmt.setInt(2, userId);
			myStmt.execute();
			myConn.close();
			myStmt.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}

	public List<cart> listCart(int userId) {

		List<cart> re= new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Menu m,Orders o where customer=? and o.menu=m.id";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, userId);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int id=myRs.getInt("id");
				String name=myRs.getString("name");
				int price=myRs.getInt("price");
				String course=myRs.getString("course");
				String description=myRs.getString("description");
				int quantity=myRs.getShort("quantity");
				cart o=new cart(quantity,name,id,price,course,description);
				re.add(o);
				
			}
			myConn.close();
			myStmt.close();
			myRs.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return re;
	}

	public void update(int id, int userId, int quantity) {

		Connection myConn=null;
		PreparedStatement myStmt=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="update Orders set quantity=? where menu=? and customer=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, quantity);
			myStmt.setInt(2, id);
			myStmt.setInt(3, userId);
			myStmt.execute();
			myConn.close();
			myStmt.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}

	public void deleteOrder(int menu_id, int userId) {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="delete from Orders where menu=? and customer=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, menu_id);
			myStmt.setInt(2, userId);
			myStmt.execute();
			myConn.close();
			myStmt.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}

	public List<cart> getCart(String user) {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		List<cart> edr=new ArrayList<>();
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select m.name,m.price,m.course,m.description,m.picture,o.quantity from Menu m,Orders o, Customer c where c.name=? and c.id=o.customer and o.menu=m.id";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, user);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				String name=myRs.getString("name");
				int price=myRs.getInt("price");
				String course=myRs.getString("course");
				String description=myRs.getString("description");
				String picture=myRs.getString("picture");
				int quantity=myRs.getInt("quantity");
				cart o=new cart(quantity,name,price,course,description,picture);
				edr.add(o);
			}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return edr;
	}
}
