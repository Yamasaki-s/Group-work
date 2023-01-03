package jp.co.masquerade.entity;

import java.io.Serializable;
import java.sql.Date;

public class UsersEntity implements Serializable {
	private Integer seqId;
	private String id;
	private String name;
	private String password;
	private String genderCode;
	private String regionCode;
	private Date birthday;
	private String introduction;
	private String maskCode;
	private String activity;
	private Date createdDate;
	private Date lastLoginDate;
	private boolean withdrawalFlg;



	public Integer getSeqId() {
		return seqId;
	}


	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}


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


	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}


	public String getRegionCode() {
		return regionCode;
	}


	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getIntroduction() {
		return introduction;
	}


	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	public String getMaskCode() {
		return maskCode;
	}


	public void setMaskCode(String maskCode) {
		this.maskCode = maskCode;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	public boolean isWithdrawalFlg() {
		return withdrawalFlg;
	}


	public void setWithdrawalFlg(boolean withdrawalFlg) {
		this.withdrawalFlg = withdrawalFlg;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersEntity [seqId=").append(seqId)
				.append(", id=").append(id)
				.append(", name=").append(name)
				.append(", password=").append(password)
				.append(", genderCode=").append(genderCode)
				.append(", regionCode=").append(regionCode)
				.append(", birthday=").append(birthday)
				.append(", introduction=").append(introduction)
				.append(", maskCode=").append(maskCode)
				.append(", activity=").append(activity)
				.append(", createdDate=").append(createdDate)
				.append(", lastLoginDate=").append(lastLoginDate)
				.append(", withdrawalFlg=").append(withdrawalFlg).append("]");
		return builder.toString();
	}

}
