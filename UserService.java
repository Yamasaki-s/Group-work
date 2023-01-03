package jp.co.masquerade.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.DatatypeConverter;

import jp.co.masquerade.dao.RegisterDao;
import jp.co.masquerade.dto.UsersDto;
import jp.co.masquerade.entity.UsersEntity;
import jp.co.masquerade.util.Utility;

public class UserService {
	
	public UsersEntity create (UsersDto usersDto) {
		
		//パスワードハッシュ化
		String passwordDigest = Utility.digest(usersDto.getPassword());
		
		//ユーザテーブル登録
		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setId(usersDto.getId());
		usersEntity.setName(usersDto.getName());
		usersEntity.setPassword(passwordDigest);
		usersEntity.setGenderCode(usersDto.getGenderCode());
		usersEntity.setRegionCode(usersDto.getRegionCode());
		LocalDate birthday = LocalDate.parse(usersDto.getBirthday(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		usersEntity.setBirthday(new Date(birthday.toEpochDay()));
		usersEntity.setIntroduction(usersDto.getIntroduction());
		usersEntity.setActivity(usersDto.getActivity());
		
		
		RegisterDao usersDao = new RegisterDao();
		UsersEntity usersEntity2 = usersDao.insert(usersEntity);
		System.out.println("usersEntity.getId() => " + usersEntity.getId());
		System.out.println("usersEntity2.getId() => " + usersEntity2.getId());
		
		
		return usersEntity2;
	}
	
	public UsersEntity create1(UsersEntity usersEntity) {
		//パスワードハッシュ化
		String passwordDigest = null;
		try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				//MD5形式のハッシュ値を計算する => 128ビット（16バイト）のハッシュ値を返す
				byte[] digest = messageDigest.digest(usersEntity.getPassword().getBytes());
				//byte[] => 32桁の16進数に変換する
				passwordDigest = DatatypeConverter.printHexBinary(digest);
		} catch (NoSuchAlgorithmException e2) {
			e2.printStackTrace();
		}
		//パスワード（平文） => ハッシュ値
		
		UsersEntity newUsersEntity = new UsersEntity();
		newUsersEntity.setId(usersEntity.getId());
		newUsersEntity.setId(passwordDigest);
		newUsersEntity.setId(usersEntity.getName());
		
		RegisterDao usersDao = new RegisterDao();
		UsersEntity usersEntity2 = usersDao.insert(newUsersEntity);
		return usersEntity2;
		
	}

}
