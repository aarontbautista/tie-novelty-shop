package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbhelper.DBUtilities;
import model.User;

/**
 * Servlet implementation class CreateProductManager
 */
@WebServlet("/CreateProductManager")
public class CreateProductManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("currentpage", "CreateProductManager");
		RequestDispatcher rd = request.getRequestDispatcher("createproductmanager.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBUtilities db = new DBUtilities();
		HttpSession session = request.getSession();
		
		User u = new User(request.getParameter("username").toString(), request.getParameter("email").toString(), request.getParameter("password").toString(), "Product Manager");
		
		try {
			if(!(u.getUsername() == "" || u.getUsername() == null))	{
				db.addUser(u);
				response.getWriter().write("<script type=\"text/javascript\">");
				response.getWriter().write("alert('Product Manager successfully created');");
				response.getWriter().write("location='AdminControls'");
				response.getWriter().write("</script>");
			} else
				response.getWriter().write("<script type=\"text/javascript\">");
			response.getWriter().write("alert('Username already taken');");
			response.getWriter().write("location='" + session.getAttribute("currentpage") + "'");
			response.getWriter().write("</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/tie-novelty-shop/Home");
		}
	}

}
