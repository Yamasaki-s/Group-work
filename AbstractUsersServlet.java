package jp.co.masquerade.servlet;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jp.co.masquerade.form.UsersForm;

public class AbstractUsersServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * リクエストパラメータから会員情報フォームを生成する
	 * @param request リクエストオブジェクト
	 * @return 会員情報フォーム
	 */
	protected UsersForm getForm(HttpServletRequest request) {
				//リクエストパラメータをフォームに詰め替える
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String gender = request.getParameter("gender");
				String region = request.getParameter("region");
				String birthday = request.getParameter("birthday");
				String introduction = request.getParameter("introduction");
				String activity = request.getParameter("activity");
				
				UsersForm form = new UsersForm();
				form.setId(id);
				form.setName(name);
				form.setPassword(password);
				form.setGender(gender);
				form.setRegion(region);
				form.setBirthday(birthday);
				form.setIntroduction(introduction);
				form.setActivity(activity);
		return form;
	}
	
	/**
	 * 会員登録入力チェック処理
	 * @param form 会員情報フォーム
	 * @return エラーメッセージリスト
	 */
	protected List<String> validate(UsersForm form) {
		List<String> messageList = new ArrayList<>();
		//■ユーザーID
		//　必須チェック
		if (form.getId() == null || form.getId().trim().length() == 0) {
			messageList.add("ユーザーIDを入力してください。");
		}
		
		if (form.getName() == null || form.getName().trim().length() == 0) {
			messageList.add("ニックネームを入力してください。");
		}
		
		if (form.getGender() == null || form.getGender().trim().length() == 0) {
			messageList.add("性別を選択してください。");
		}
		
		if (form.getRegion() == null || form.getRegion().trim().length() == 0) {
			messageList.add("居住地を選択してください。");
		}
		
		if (form.getActivity() == null || form.getActivity().trim().length() == 0) {
			messageList.add("アクティビティを選択してください。");
		}
		return messageList;
	}
	
	/**
	 * 画面の初期データをフォームに設定する
	 * @param form 会員情報フォーム
	 */
	protected void initForm(UsersForm form) {
		//性別
		List<SimpleEntry<String, String>> genderList = new ArrayList<>();
		genderList.add(new SimpleEntry<String, String>("G001", "男性"));
		genderList.add(new SimpleEntry<String, String>("G002", "女性"));
		genderList.add(new SimpleEntry<String, String>("G003", "どちらでもない"));
		form.setGenderList(genderList);
		
		//アクティビティ
		List<SimpleEntry<String, String>> activtyList = new ArrayList<>();
		activtyList.add(new SimpleEntry<String, String>("A001", "インドア"));
		activtyList.add(new SimpleEntry<String, String>("A002", "アウトドア"));
		activtyList.add(new SimpleEntry<String, String>("A003", "どちらも"));
		form.setActivityList(activtyList);
		
		//居住地
		List<SimpleEntry<String, String>> regionList = new ArrayList<>();
		regionList.add(new SimpleEntry<String, String>("R101","北海道"));
		regionList.add(new SimpleEntry<String, String>("R202","青森県"));
		regionList.add(new SimpleEntry<String, String>("R203","岩手県"));
		regionList.add(new SimpleEntry<String, String>("R204","宮城県"));
		regionList.add(new SimpleEntry<String, String>("R205","秋田県"));
		regionList.add(new SimpleEntry<String, String>("R206","山形県"));
		regionList.add(new SimpleEntry<String, String>("R207","福島県"));
		regionList.add(new SimpleEntry<String, String>("R308","茨城県"));
		regionList.add(new SimpleEntry<String, String>("R309","栃木県"));
		regionList.add(new SimpleEntry<String, String>("R310","群馬県"));
		regionList.add(new SimpleEntry<String, String>("R311","埼玉県"));
		regionList.add(new SimpleEntry<String, String>("R312","千葉県"));
		regionList.add(new SimpleEntry<String, String>("R313","東京都"));
		regionList.add(new SimpleEntry<String, String>("R314","神奈川県"));
		regionList.add(new SimpleEntry<String, String>("R415","新潟県"));
		regionList.add(new SimpleEntry<String, String>("R416","富山県"));
		regionList.add(new SimpleEntry<String, String>("R417","石川県"));
		regionList.add(new SimpleEntry<String, String>("R418","福井県"));
		regionList.add(new SimpleEntry<String, String>("R419","山梨県"));
		regionList.add(new SimpleEntry<String, String>("R420","長野県"));
		regionList.add(new SimpleEntry<String, String>("R421","岐阜県"));
		regionList.add(new SimpleEntry<String, String>("R422","静岡県"));
		regionList.add(new SimpleEntry<String, String>("R423","愛知県"));
		regionList.add(new SimpleEntry<String, String>("R524","三重県"));
		regionList.add(new SimpleEntry<String, String>("R525","滋賀県"));
		regionList.add(new SimpleEntry<String, String>("R526","京都府"));
		regionList.add(new SimpleEntry<String, String>("R527","大阪府"));
		regionList.add(new SimpleEntry<String, String>("R528","兵庫県"));
		regionList.add(new SimpleEntry<String, String>("R529","奈良県"));
		regionList.add(new SimpleEntry<String, String>("R530","和歌山県"));
		regionList.add(new SimpleEntry<String, String>("R631","鳥取県"));
		regionList.add(new SimpleEntry<String, String>("R632","島根県"));
		regionList.add(new SimpleEntry<String, String>("R633","岡山県"));
		regionList.add(new SimpleEntry<String, String>("R634","広島県"));
		regionList.add(new SimpleEntry<String, String>("R635","山口県"));
		regionList.add(new SimpleEntry<String, String>("R736","徳島県"));
		regionList.add(new SimpleEntry<String, String>("R737","香川県"));
		regionList.add(new SimpleEntry<String, String>("R738","愛媛県"));
		regionList.add(new SimpleEntry<String, String>("R739","高知県"));
		regionList.add(new SimpleEntry<String, String>("R840","福岡県"));
		regionList.add(new SimpleEntry<String, String>("R841","佐賀県"));
		regionList.add(new SimpleEntry<String, String>("R842","長崎県"));
		regionList.add(new SimpleEntry<String, String>("R843","熊本県"));
		regionList.add(new SimpleEntry<String, String>("R844","大分県"));
		regionList.add(new SimpleEntry<String, String>("R845","宮崎県"));
		regionList.add(new SimpleEntry<String, String>("R846","鹿児島県"));
		regionList.add(new SimpleEntry<String, String>("R847","沖縄県"));
		form.setRegionList(regionList);
	}
}
