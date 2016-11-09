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
 * Servlet implementation class customerController
 */
@WebServlet("/customerController")
public class customerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private customerDb customerDbutil;
	private addressDb addressDbutil;
	private restaurantDb restaurantDbutil;
	
	@Resource(name="jdbc/web_student_tracker")
	 private DataSource dataSource;
	@Override
	public void init() throws ServletException {
		super.init();
		//create our student db util ... and pass in the conn pool / datasource
		try{
			customerDbutil=new customerDb(dataSource);
			addressDbutil=new addressDb(dataSource);
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
		try{
		String theCommand=request.getParameter("command");
		switch(theCommand){
		case "REGISTER":
			registerCustomer(request,response);
			break;
		case "LOGIN":
			login(request,response);
			break;
		default:
			wrong(request,response);
		}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		int test1=customerDbutil.test(name,password);
		switch(test1){
		case 0:
			wrong(request,response);
			break;
		default:
			right(request,response);
		}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}
		
	private void right(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username=request.getParameter("name");
		List<restaurant> re=restaurantDbutil.get_restaurant(username);
		request.setAttribute("nam", username);
		request.setAttribute("res", re);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/restaurant.jsp");
		dispatcher.forward(request, response);		
	}
	private void wrong(HttpServletRequest request, HttpServletResponse response) throws Exception{

		RequestDispatcher dispatcher =request.getRequestDispatcher("/wrong.jsp");
		dispatcher.forward(request, response);		
	}
	private void registerCustomer(HttpServletRequest request, HttpServletResponse response) {
		List<customerAddress> ca=new ArrayList<>();
		List<customer> cus=new ArrayList<>();
		int id=0,i=0;
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String passwordConform=request.getParameter("password confirm");
		String phoneNumber=request.getParameter("cellphone");
		String email=request.getParameter("email");
		String account=request.getParameter("account");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String zipcode=request.getParameter("zipcode");
		String number=request.getParameter("number");
		String street=request.getParameter("street");
		try{
		address a=new address(state,city,zipcode,street,number);
		customer c=new customer(name,email,phoneNumber,account,password);
		id=customerDbutil.addcustomer(c);
		addressDbutil.addAddress(a,id);
		customerAddress cae=new customerAddress(name,email,phoneNumber,account,state,city,zipcode,street,number);
		ca.add(cae);
		request.setAttribute("information", ca);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/conform.jsp");
		dispatcher.forward(request, response);
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}

}
