package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;


public class UpdatelowpriorityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int taskid = Integer.parseInt(request.getParameter("taskid"));
		String priority = request.getParameter("priority");
		TaskDao taskDao = new TaskDao();
		if (priority.equals("high")) {
			String p = "medium";
			if (taskDao.updatepriority(taskid, p)) {
				response.sendRedirect("TodolistController");
			} else {
				request.setAttribute("msgpriority", "something went wrong");
				request.getRequestDispatcher("TodolistController").forward(request, response);
			}

		} else if(priority.equals("medium")) {
			String p = "low";
			if (taskDao.updatepriority(taskid, p)) {
				response.sendRedirect("TodolistController");
			} else {
				request.setAttribute("msgpriority", "something went wrong");
				request.getRequestDispatcher("TodolistController").forward(request, response);
			}
		} 
		else {
			response.sendRedirect("TodolistController");
		}
	}

}
