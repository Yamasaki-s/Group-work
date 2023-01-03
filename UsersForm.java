package jp.co.masquerade.form;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

//■フォーム　=>　画面上の入力データを入れるDTO

/**
 * ユーザー情報フォーム
 */
public class UsersForm {
	
	private String id;
	private String name;
	private String password;
	private String gender;
	private String region;
	private String regionName;
	private String birthday;
	private String introduction;
	private String activity;
	private String action;
	
	List<SimpleEntry<String,String>> genderList;
	List<SimpleEntry<String,String>> activityList;
	List<SimpleEntry<String,String>> regionList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersForm [id=").append(id)
				.append(", name=").append(name)
				.append(", gender=").append(gender)
				.append(", region=").append(region)
				.append(", birthday=").append(birthday)
				.append(", introduction=").append(introduction)
				.append(", activity=").append(activity).append("]");
		return builder.toString();
	}
	
	public List<SimpleEntry<String,String>> getGenderList() {
		return genderList;
	}
	
	public void setGenderList(List<SimpleEntry<String,String>> genderList) {
		this.genderList = genderList;
	}
	
	public List<SimpleEntry<String,String>> getActivityList() {
		return activityList;
	}
	
	public void setActivityList(List<SimpleEntry<String,String>> activityList) {
		this.activityList = activityList;
	}
	public List<SimpleEntry<String, String>> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<SimpleEntry<String, String>> regionList) {
		this.regionList = regionList;
	}

}
