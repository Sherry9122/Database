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
 * Servlet implementation class addressControl
 */
@WebServlet("/addressControl")
public class addressControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private addressDb addressDbutil;
	
	@Resource(name="jdbc/web_student_tracker")
	 private DataSource dataSource;
	@Override
	public void init() throws ServletException {
		super.init();
		//create our student db util ... and pass in the conn pool / datasource
		try{
			addressDbutil=new addressDb(dataSource);
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String theCommand=request.getParameter("command");
		if (theCommand==null){
			theCommand="LIST";
		}
		try {
			switch(theCommand){
				case "LIST":
					listAddress(request,response);
					break;
				case "SELECT":
					selectAddress(request,response);
					break;
				default:
					listAddress(request,response);
			}
			} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void selectAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String city=request.getParameter("country");
			List<address> caddress=addressDbutil.selectCity(city);
			request.setAttribute("ADDRESS",caddress);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);		
	}


	private void listAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
			List<address> laddresss=addressDbutil.get_address();
			request.setAttribute("ADDRESS",laddresss);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);		
	}

}
