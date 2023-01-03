package jp.co.masquerade.servlet;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.masquerade.form.UsersForm;

/**
 * 会員登録確認画面
 * Servlet implementation class loginInitServlet
 */
@WebServlet("/public/RegisterConfirmation")
public class RegisterConfirmation extends AbstractUsersServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 会員登録確認画面へ遷移する
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersForm form = super.getForm(request);
		super.initForm(form);

		for (SimpleEntry<String, String> entry : form.getRegionList()) {
			if (entry.getKey().equals(form.getRegion())) {
				form.setRegionName(entry.getValue());
				break;
			}
		}

		//会員登録確認画面（JSP）に登録画面の入力データを渡す
		request.setAttribute("usersForm", form);

		request.setCharacterEncoding("UTF-8");

		//■入力チェック
		List<String> messageList = super.validate(form);

		if (messageList.isEmpty()) {
			//会員登録確認画面へ遷移する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registerConfirmation.jsp");
			dispatcher.forward(request, response);
			return;
		} else {
			//会員登録入力画面へ遷移する
			request.setAttribute("messageList", messageList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
}
