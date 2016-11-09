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
 * Servlet implementation class cartControl
 */
@WebServlet("/cartControl")
public class cartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private cartDb cartDbutil;
	private restaurantDb restaurantDbutil;
	private menuDb menuDbutil;
	
	@Resource(name="jdbc/web_student_tracker")
	 private DataSource dataSource;
	@Override
	public void init() throws ServletException {
		super.init();
		//create our student db util ... and pass in the conn pool / datasource
		try{
			cartDbutil=new cartDb(dataSource);
			restaurantDbutil=new restaurantDb(dataSource);
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
	
		String thecommand=request.getParameter("command");
		try{
		switch(thecommand){
		case "ADD":
			addCart(request,response);
			break;
		case "CHECK":
			check(request,response);
			break;
		case "Qadd":
			quantityAdd(request,response);
			break;
		case "Qreduce":
			quantityReduce(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "sub":
			submit(request,response);
			break;
		default:
			check(request,response);
		}
		}
		catch(Exception exc){
			exc.getStackTrace();
		}
	}
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user=request.getParameter("user");
		List<cart> ed=cartDbutil.getCart(user);
		request.setAttribute("fina", ed);
		request.setAttribute("username", user);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/final.jsp");
		dispatcher.forward(request, response);		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String men=request.getParameter("id");
		int menu_id=Integer.parseInt(men);
		String user=request.getParameter("user");
		String re=request.getParameter("restaurant");
		int re_id=Integer.parseInt(re);
		String us=request.getParameter("userId");
		int userId=Integer.parseInt(us);
		String ide=request.getParameter("id");
		cartDbutil.deleteOrder(menu_id,userId);
		List<menu> r=menuDbutil.listMenu(re_id, user);
		List<restaurant> res=restaurantDbutil.search(re_id);
		request.setAttribute("name", user);
		request.setAttribute("MENU", r);
		request.setAttribute("rest", res);
		List<cart> red=cartDbutil.listCart(user);
		request.setAttribute("ORDER", red);
		request.setAttribute("oi", user);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response);
		
	}
	private void quantityReduce(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String men=request.getParameter("id");
		int menu_id=Integer.parseInt(men);
		String user=request.getParameter("user");
		String re=request.getParameter("restaurant");
		int re_id=Integer.parseInt(re);
		String us=request.getParameter("userId");
		int userId=Integer.parseInt(us);
		String ide=request.getParameter("id");
		String quantit=request.getParameter("quantity");
		int quantity=Integer.parseInt(quantit);
		quantity--;
		cartDbutil.update(menu_id,userId,quantity);
		List<menu> r=menuDbutil.listMenu(re_id, user);
		List<restaurant> res=restaurantDbutil.search(re_id);
		request.setAttribute("name", user);
		request.setAttribute("MENU", r);
		request.setAttribute("rest", res);
		List<cart> red=cartDbutil.listCart(user);
		request.setAttribute("ORDER", red);
		request.setAttribute("oi", user);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response);			
	}
	private void quantityAdd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String men=request.getParameter("id");
		int menu_id=Integer.parseInt(men);
		String user=request.getParameter("user");
		String re=request.getParameter("restaurant");
		int re_id=Integer.parseInt(re);
		String us=request.getParameter("userId");
		int userId=Integer.parseInt(us);
		String ide=request.getParameter("id");
		String quantit=request.getParameter("quantity");
		int quantity=Integer.parseInt(quantit);
		quantity++;
		cartDbutil.update(menu_id,userId,quantity);
		List<menu> r=menuDbutil.listMenu(re_id, user);
		List<restaurant> res=restaurantDbutil.search(re_id);
		request.setAttribute("name", user);
		request.setAttribute("MENU", r);
		request.setAttribute("rest", res);
		List<cart> red=cartDbutil.listCart(user);
		request.setAttribute("ORDER", red);
		request.setAttribute("oi", user);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response);		
	}
	private void check(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String restaurant=request.getParameter("restaurant");
		int idr=Integer.parseInt(restaurant);
		String username=request.getParameter("user");
		List<menu> r=menuDbutil.listMenu(idr,username);
		List<restaurant> res=restaurantDbutil.search(idr);
		request.setAttribute("name", username);
		request.setAttribute("MENU", r);
		request.setAttribute("rest", res);
		List<cart> red=cartDbutil.listCart(username);
		request.setAttribute("ORDER", red);
		request.setAttribute("oi", username);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response);
	}
	private void addCart(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user=request.getParameter("userId");
		String ide=request.getParameter("id");
		int id=Integer.parseInt(ide);
		int userId=Integer.parseInt(user);
		String restaurant=request.getParameter("restaurant");
		int idr=Integer.parseInt(restaurant);
		cartDbutil.add(userId,id);
		String username=request.getParameter("user");
		List<menu> r=menuDbutil.listMenu(idr,username);
		List<restaurant> res=restaurantDbutil.search(idr);
		request.setAttribute("name", username);
		request.setAttribute("MENU", r);
		request.setAttribute("rest", res);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/menu.jsp");
		dispatcher.forward(request, response);
	}

}
