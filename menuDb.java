package again;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class menuDb {

private DataSource dataSource;
	
	public menuDb(DataSource theDataSource){
		dataSource = theDataSource;
	}
	public List<menu> listMenu(int id,String username) throws Exception{
		List<menu> lmenu=new ArrayList<>();
		Connection myConn=null;
		PreparedStatement myStmt=null;
		PreparedStatement my=null;
		ResultSet myRs=null;
		ResultSet m=null;
		int id1=0;
		try{
			myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
			String sql="select * from Menu where menu=?";
			String sql1="select * from Customer where name=?";
			my=myConn.prepareStatement(sql1);
			my.setString(1, username);
			m=my.executeQuery();
			while(m.next()){
				id1=m.getInt("id");
			}
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myRs=myStmt.executeQuery();
			while(myRs.next()){
				int ide=myRs.getInt("id");
				String name=myRs.getString("name");
				int price=myRs.getInt("price");
				String course=myRs.getString("course");
				String description=myRs.getString("description");
				String picture=myRs.getString("picture");
				menu c=new menu(ide,name,price,course,description,id,username,id1,picture);
				lmenu.add(c);
			}
			myConn.close();
			myStmt.close();
			myRs.close();
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		return lmenu;
	}
	public List<menu> che() throws Exception{
		{
			List<menu> i=new ArrayList<>();
			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRs=null;
			try{
				myConn=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
				String sql="select * from Menu where id=21";
				myStmt=myConn.prepareStatement(sql);
				myRs=myStmt.executeQuery();
				while(myRs.next()){
					String picture=myRs.getString("picture");
					menu o=new menu(picture);
					i.add(o);
				}
			}
			catch(Exception exc){
				exc.getStackTrace();
			}
			return i;
		}
	}
}
