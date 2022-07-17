package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserDao;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userdao = new UserDao();

		UserBean user = userdao.loginuser(email, password);
		
		if (user == null) {
			request.setAttribute("msg", "user not available please signup first");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			if(user.getActivate().equals("activate")) {
				
			request.setAttribute("firstnamevalue", user.getFirstname());
				HttpSession session = request.getSession();
				session.setAttribute("userid", user.getUserid());
				session.setAttribute("firstname", user.getFirstname());
				session.setAttribute("email", user.getEmail());
				session.setMaxInactiveInterval(1 * 60);
				Cookie c = new Cookie("username", (String) session.getAttribute("firstname"));
				c.setMaxAge(1* 60);
				response.addCookie(c);
			
			response.sendRedirect("TodolistController");
		}else {
			request.setAttribute("msg", "your account is deactivate, please contect admin. ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		}
	
	}

}
