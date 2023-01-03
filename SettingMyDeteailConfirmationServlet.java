package jp.co.masquerade.servlet;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.masquerade.constant.Constant;
import jp.co.masquerade.entity.LoginEntity;
import jp.co.masquerade.form.UsersForm;

/**
 * 会員登録確認画面
 * Servlet implementation class loginInitServlet
 */
@WebServlet("/SettingMyDeteailConfirmationServlet")
public class SettingMyDeteailConfirmationServlet extends AbstractUsersServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 会員登録確認画面へ遷移する
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//セッションスコープに保存したEntityを取り出す
				HttpSession session = request.getSession();
				LoginEntity loginEntity = (LoginEntity)session.getAttribute(Constant.SESSION_KEY_LOGIN_USER);
				Integer seqId = loginEntity.getSeqId() ;
				String seqId2 = Integer.toString(seqId);
				
		UsersForm form = super.getForm(request);
		super.initForm(form);
		
		for (SimpleEntry<String, String> entry : form.getRegionList()) {
			if(entry.getKey().equals(form.getRegion())) {
				form.setRegionName(entry.getValue());
				break;
			}
		}
		
		//会員情報変更確認画面（JSP）に変更画面の入力データを渡す
		request.setAttribute("usersForm", form);
		request.setCharacterEncoding("UTF-8");
		
		//画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/settingMyDeteailConfirmation.jsp");
		dispatcher.forward(request, response);
		
	}
}
