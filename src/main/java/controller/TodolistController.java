package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TaskBean;
import dao.TaskDao;




public class TodolistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDao taskDao = new  TaskDao();
		HttpSession session =  request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		ArrayList<TaskBean> tasks = taskDao.listtask(userid);
		request.setAttribute("tasks", tasks);
		int per = taskDao.persentage(userid);
		request.setAttribute("persentage", per);
		request.getRequestDispatcher("index.jsp").forward(request, response);		
	}
}
