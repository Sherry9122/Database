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
 * Servlet implementation class picture
 */
@WebServlet("/picture")
public class picture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
private menuDb menuDbutil;
	
	@Resource(name="jdbc/web_student_tracker")
	 private DataSource dataSource;
	@Override
	public void init() throws ServletException {
		super.init();
		//create our student db util ... and pass in the conn pool / datasource
		try{
			menuDbutil=new menuDb(dataSource);
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
		listew(request,response);
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}
	private void listew(HttpServletRequest request, HttpServletResponse response) throws Exception{

		List<menu> p=menuDbutil.che();
		request.setAttribute("picture",p);

		RequestDispatcher dispatcher =request.getRequestDispatcher("/picture.jsp");
		dispatcher.forward(request, response);	
	}

}
