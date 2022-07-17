package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;

/**
 * Servlet implementation class SqueController
 */
public class SqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String answer = request.getParameter("answer");
		String email = request.getParameter("email");
		String question = request.getParameter("question");
		request.setAttribute("email", email);
		request.setAttribute("question", question);
		UserDao userDao = new UserDao();
		UserBean user = userDao.searchemail(email, answer);
		if (user == null) {
			request.setAttribute("msg", "Security answer is not correct");
			request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("forgot.jsp").forward(request, response);
		}

	}

}
