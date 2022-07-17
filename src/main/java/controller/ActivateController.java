package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;


public class ActivateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		UserDao userDao = new UserDao();
		int bool =userDao.statususer(userid);
		if(bool==1) {
			request.setAttribute("activate", "your account is deactivate");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("TodolistController").forward(request, response);

		}	
	}
}
