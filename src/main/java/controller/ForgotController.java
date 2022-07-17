package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class ForgotController
 */
public class ForgotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	if(password == null || password.trim().length() == 0) {
		request.setAttribute("msg", "please enter password");
		request.getRequestDispatcher("forgot.jsp").forward(request, response);
	}
	UserDao userDao = new  UserDao();
	if(userDao.forgotpassword(email,password)) {
		response.sendRedirect("login.jsp");
	}else {
		request.getRequestDispatcher("forgot.jsp").forward(request, response);
	}
	}

}
