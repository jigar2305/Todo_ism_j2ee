package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.UserDao;

public class Signupfilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		UserDao userDao = new UserDao();
		boolean isError = false;

		if (firstname == null || firstname.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstnameError", "please enter firstname");
		} else {
			request.setAttribute("firstnamevalue", firstname);
		}
		if (lastname == null || lastname.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastnameError", "please enter lastname");
		} else {
			request.setAttribute("lastnamevalue", lastname);
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "please enter password");
		} else {
			request.setAttribute("passwordvalue", password);
		}
		if (gender == null || gender.trim().length() == 0) {
			isError = true;
			request.setAttribute("genderError", "please select gender");
		} else {
			request.setAttribute("gendervalue", gender);
		}
		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "please enter email");
		}else if(userDao.duplicate(email)) {
			isError = true;
			request.setAttribute("emailError", "you have already account, please login");
		}else {
			request.setAttribute("emailvalue", email);
		}
		if (question == null || question.trim().length() == 0) {
			isError = true;
			request.setAttribute("questionError", "please enter Security question");
		}  else {
			request.setAttribute("questionvalue", question);
		}
		if (answer == null || answer.trim().length() == 0) {
			isError = true;
			request.setAttribute("answerError", "please enter Security answer");
		}  else {
			request.setAttribute("answervalue", answer);
		}
		
		if (isError) {
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
