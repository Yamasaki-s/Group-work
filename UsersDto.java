package jp.co.masquerade.dto;

public class UsersDto {
	
	//Users
	private String id;
	private String name;
	private String password;
	private String genderCode;
	private String regionCode;
	private String birthday;
	private String introduction;
	private String activity;
	
	//Account
	private String acoountType;

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

	public String getGenderCode() {
		return genderCode;
	}

	public void setGender(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
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

	public String getAcoountType() {
		return acoountType;
	}

	public void setAcoountType(String acoountType) {
		this.acoountType = acoountType;
	}


}
