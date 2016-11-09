package again;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class viewR
 */
@WebServlet("/viewR")
public class viewR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private menuDb menuDbutil;
	private restaurantDb restaurantDbutil;
	
	@Resource(name="jdbc/web_student_tracker")
	 private DataSource dataSource;
	@Override
	public void init() throws ServletException {
		super.init();
		//create our student db util ... and pass in the conn pool / datasource
		try{
			menuDbutil=new menuDb(dataSource);
			restaurantDbutil=new restaurantDb(dataSource);
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String thecommand=request.getParameter("command");
		try{
		listmenu(request,response);
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}
	private void listmenu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		String username=request.getParameter("user");
		String ide=request.getParameter("restaurantId");
		int id=Integer.parseInt(ide);
		List<menu> m=menuDbutil.listMenu(id,username);
		List<restaurant> r=restaurantDbutil.search(id);
		request.setAttribute("name", username);
		request.setAttribute("nm", username);
		request.setAttribute("MENU", m);
		request.setAttribute("rest", r);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/menu.jsp");
		dispatcher.forward(request, response);
	}

}
