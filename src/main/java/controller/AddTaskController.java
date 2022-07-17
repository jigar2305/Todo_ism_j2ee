package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TaskBean;
import dao.TaskDao;

public class AddTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String fdate = request.getParameter("fdate");
		String priority = request.getParameter("priority");
	

		boolean isError = false;

		if (name == null || name.trim().length() == 0) {
			isError = true;
			request.setAttribute("nameError", "please enter Title");
		} else {
			request.setAttribute("namevalue", name);
		}
		if (description == null || description.trim().length() == 0) {
			isError = true;
			request.setAttribute("descriptionError", "please enter description");
		} else {
			request.setAttribute("descriptionvalue", description);
		}
		if (fdate == null || fdate.trim().length() == 0) {
			isError = true;
			request.setAttribute("fdateError", "please enter final date");
		} else {
			request.setAttribute("fdatevalue", fdate);
		}

		if (priority == null || priority.trim().length() == 0) {
			isError = true;
			request.setAttribute("priorityError", "please select task priority");
		} else {
			request.setAttribute("priorityvalue", priority);
		}

		if (isError) {
			request.getRequestDispatcher("addtodo.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession(false);
			int userid = (int) session.getAttribute("userid");
			TaskBean taskBean = new TaskBean();
			
			taskBean.setF_date(fdate);
			taskBean.setName(name);
			taskBean.setDescription(description);
			taskBean.setPriority(priority);
			TaskDao taskDao = new TaskDao();
			if (taskDao.addtask(taskBean, userid)) {
				response.sendRedirect("TodolistController");
				
			} else {
				request.getRequestDispatcher("addtodo.jsp").forward(request, response);
			}

		}

	}

}
