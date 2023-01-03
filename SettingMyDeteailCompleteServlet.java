package jp.co.masquerade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.masquerade.constant.Constant;
import jp.co.masquerade.dto.AccountDto;
import jp.co.masquerade.entity.LoginEntity;
import jp.co.masquerade.form.UsersForm;
import jp.co.masquerade.service.AccountService;

/**
 * 会員情報変更完了画面
 * Servlet implementation class loginInitServlet
 */
@WebServlet("/SettingMyDeteailCompleteServlet")
public class SettingMyDeteailCompleteServlet extends AbstractUsersServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 会員情報変更完了画面へ遷移する
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UsersForm form = super.getForm(request);
		super.initForm(form);
		
		HttpSession session = request.getSession();
		LoginEntity loginEntity = (LoginEntity)session.getAttribute(Constant.SESSION_KEY_LOGIN_USER);
		Integer seqId = loginEntity.getSeqId() ;
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender	 = request.getParameter("gender");
		String region = request.getParameter("region");
		String introduction = request.getParameter("introduction");
		String activity = request.getParameter("activity");
		
		
		request.setAttribute("usersForm", form);
		
		String action = request.getParameter("action");
		if (action.equals("back")) {
			//会員情報変更画面へ遷移する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/settingMyDeteail.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (action.equals("register")) {
			AccountDto accountDto = new AccountDto();
			accountDto.setName(name);
			accountDto.setGenderCode(gender);
			accountDto.setRegionCode(region);
			accountDto.setIntroduction(introduction);
			accountDto.setActivity(activity);
			accountDto.setSeqId(seqId);
			
			AccountService accountService  = new AccountService();
			accountService.create(accountDto);
			//会員情報変更完了画面へ遷移する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/myDeteailComplete.jsp");
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
