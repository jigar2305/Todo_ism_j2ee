package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskDao;


public class PerController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		int userid = (int) session.getAttribute("userid");
		TaskDao taskDao = new TaskDao();
		int per = taskDao.persentage(userid);
		req.setAttribute("persentage", per);
		req.getRequestDispatcher("persentage.jsp").forward(req, resp);
	
	}
}
