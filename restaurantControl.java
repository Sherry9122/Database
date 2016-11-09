package again;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class restaurantControl
 */
@WebServlet("/restaurantControl")
public class restaurantControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private restaurantDb restaurantDbutil;
	private customerDb customerDbutil;
	
	@Resource(name="jdbc/web_student_tracker")
	 private DataSource dataSource;
	@Override
	public void init() throws ServletException {
		super.init();
		//create our student db util ... and pass in the conn pool / datasource
		try{
			restaurantDbutil=new restaurantDb(dataSource);
			customerDbutil=new customerDb(dataSource);
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		String thecommand=request.getParameter("command");
		if (thecommand==null){
			thecommand="LIST";
		}
		switch (thecommand){
		case "LIST":
			listAddress(request,response);
			break;
		case "LIST1":
			list1Address(request,response);
		case "SEARCH":
			searchAddress(request,response);
			break;
		case "NAME":
			nameR(request,response);
			break;
		default:
			listAddress(request,response);
		}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
		
	}


	private void list1Address(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<restaurant> re=new ArrayList<>();
		String username=request.getParameter("ame");
		re=restaurantDbutil.get_restaurant(username);
		request.setAttribute("RESTAURANT", re);
		request.setAttribute("nam", username);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/restaurant.jsp");
		dispatcher.forward(request, response);
		
	}


	private void nameR(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<restaurant> rw=new ArrayList<>();
		String name=request.getParameter("name");
		String username=request.getParameter("ame");
		rw=restaurantDbutil.name_restaurant(name,username);
		request.setAttribute("RESTAURANT", rw);
		request.setAttribute("nam", username);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/restaurant.jsp");
		dispatcher.forward(request,response);
	}


	private void searchAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<restaurant> rw=new ArrayList<>();
		String type=request.getParameter("type");
		String username=request.getParameter("ame");
		rw=restaurantDbutil.search_restaurant(type,username);
		request.setAttribute("RESTAURANT", rw);
		request.setAttribute("nam",username);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/restaurant.jsp");
		dispatcher.forward(request, response);
	}


	private void listAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<restaurant> re=new ArrayList<>();
		String username=request.getParameter("user");
		re=restaurantDbutil.get_restaurant(username);
		request.setAttribute("RESTAURANT", re);
		request.setAttribute("nam", username);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/restaurant.jsp");
		dispatcher.forward(request, response);
	}

}
