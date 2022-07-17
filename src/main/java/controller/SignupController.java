package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;

public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("tst");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		UserDao userDao = new UserDao();

		UserBean user = new UserBean();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);
		user.setQuestion(question);
		user.setAnswer(answer);

		if (userDao.adduser(user)) {
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("test");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}

}
