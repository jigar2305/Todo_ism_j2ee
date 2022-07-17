package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class GetQuestionController
 */
public class GetQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		UserDao userDao = new UserDao();
		if(userDao.duplicate(email)) {
			String question = userDao.getQuestion(email);
			request.setAttribute("question", question);	
			
			request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
		}else {
			request.setAttribute("emailmsg", "you are not registered,please register.");
			request.getRequestDispatcher("email.jsp").forward(request, response);

		}
	}


}
