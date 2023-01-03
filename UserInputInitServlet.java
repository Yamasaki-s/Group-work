package jp.co.masquerade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.masquerade.form.UsersForm;

/**
 * Servlet implementation class loginInitServlet
 */
@WebServlet("/public/UserInputInitServlet")
public class UserInputInitServlet extends AbstractUsersServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ログイン画面へ遷移する
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersForm form = new UsersForm();
		super.initForm(form);

		//会員情報をリクエストスコープに保存する
		request.setAttribute("usersForm", form);

		//ログイン画面へ遷移する
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
