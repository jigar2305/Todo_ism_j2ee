package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;

/**
 * Servlet implementation class UpdatestatusController
 */
public class UpdatestatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int taskid = Integer.parseInt(request.getParameter("taskid"));
		String status = request.getParameter("status");
		TaskDao taskDao = new TaskDao();
		if (status.equals("pending")) {
			String s = "done";
			if (taskDao.updatestatus(taskid, s)) {
				response.sendRedirect("TodolistController");
			} else {
				request.setAttribute("msgstatus", "something went wrong");
				request.getRequestDispatcher("TodolistController").forward(request, response);
			}

		} else {
			response.sendRedirect("TodolistController");
		}
	}

}
