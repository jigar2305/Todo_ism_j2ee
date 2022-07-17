package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;

/**
 * Servlet implementation class DeletetaskController
 */
public class DeletetaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int taskid = Integer.parseInt(request.getParameter("taskid"));
		TaskDao taskDao = new TaskDao();
		if(taskDao.delete(taskid)) {
			response.sendRedirect("TodolistController");
		}else {
			request.setAttribute("delmsg", "something went wrong");
			request.getRequestDispatcher("TodolistController").forward(request, response);
		}
	}

	

}
