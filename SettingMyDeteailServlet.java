package jp.co.masquerade.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
 * Servlet implementation class loginInitServlet
 */
@WebServlet("/SettingMyDeteailServlet")
public class SettingMyDeteailServlet extends AbstractUsersServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会員情報変更画面へ遷移する
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	//データベースの情報呼び出しコード
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "jdbc:postgresql://localhost:5432/masq";
		String user = "postgres";
		String password = "root";
		
		//アカウント情報を格納するList
		//LoginEntity account = null;
		//リクエストスコープへオブジェクトを設定する
		UsersForm form = new UsersForm();
		super.initForm(form);

		//セッションスコープに保存したEntityを取り出す
		HttpSession session = request.getSession();
		LoginEntity loginEntity = (LoginEntity)session.getAttribute(Constant.SESSION_KEY_LOGIN_USER);
		Integer seqId = loginEntity.getSeqId() ;
		String seqId2 = Integer.toString(seqId);
		System.out.println(seqId2);
		//データベースに接続する
		try {
			Class.forName("org.postgresql.Driver");
			try (Connection connection = DriverManager.getConnection(url,user,password);
					Statement statement = connection.createStatement();){
				
				//SQLを実行して、テーブルからアカウントの情報を取得する
				ResultSet resultSet = statement.executeQuery("SELECT seq_id, id, name, gender_code, region_code,  introduction, activity  FROM account WHERE  seq_id=" + seqId2);
				//取得した件数分繰り返す
				if(resultSet.next()) {
					//リストにアカウントの詳細を追加
					form.setId(resultSet.getString("id"));
					form.setName(resultSet.getString("name"));
					form.setGender(resultSet.getString("gender_code"));
					form.setRegion(resultSet.getString("region_code"));
					form.setIntroduction(resultSet.getString("introduction"));
					form.setActivity(resultSet.getString("activity"));
					
				}
				
				resultSet.close();
				statement.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		request.setAttribute("usersForm", form);
		
		//画面遷移
	 request.getRequestDispatcher("/WEB-INF/settingMyDeteail.jsp").forward(request, response);
	 System.out.println("account");
	}
		
		
			@Override
				protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					doPost(request, response);
				}
		}
