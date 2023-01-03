package jp.co.masquerade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.masquerade.dto.UsersDto;
import jp.co.masquerade.form.UsersForm;
import jp.co.masquerade.service.UserService;

/**
 * 会員登録完了画面
 * Servlet implementation class loginInitServlet
 */
@WebServlet("/public/RegisterCompleteServlet")
public class RegisterCompleteServlet extends AbstractUsersServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 会員登録完了画面へ遷移する
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UsersForm form = super.getForm(request);
		super.initForm(form);
		
		String id = request.getParameter("id");	
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender	 = request.getParameter("gender");
		String region = request.getParameter("region");
		String  birthday = request.getParameter("birthday");
		String introduction = request.getParameter("introduction");
		String activity = request.getParameter("activity");
		
		
		request.setAttribute("usersForm", form);
		
		String action = request.getParameter("action");
		if (action.equals("back")) {
			//会員登録画面へ遷移する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (action.equals("register")) {
			System.out.println("form => " + form);
			System.out.println("会員情報を登録しました。");
			
			UsersDto usersDto = new UsersDto();
			usersDto.setId(id);
			usersDto.setName(name);
			usersDto.setPassword(password);
			usersDto.setGender(gender);
			usersDto.setRegionCode(region);
			usersDto.setBirthday(birthday);
			usersDto.setIntroduction(introduction);
			usersDto.setActivity(activity);
			UserService userService  = new UserService();
			userService.create(usersDto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registerComplete.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
