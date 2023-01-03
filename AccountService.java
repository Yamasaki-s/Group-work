package jp.co.masquerade.service;

import jp.co.masquerade.dao.AccountDao;
import jp.co.masquerade.dto.AccountDto;
import jp.co.masquerade.entity.LoginEntity;

public class AccountService {
	
	public LoginEntity create (AccountDto accountDto) {
		
		
		//ユーザテーブル変更
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setName(accountDto.getName());
		loginEntity.setGenderCode(accountDto.getGenderCode());
		loginEntity.setRegionCode(accountDto.getRegionCode());
		loginEntity.setIntroduction(accountDto.getIntroduction());
		loginEntity.setActivity(accountDto.getActivity());
		loginEntity.setSeqId(accountDto.getSeqId());
		
		
		AccountDao accountDao = new AccountDao();
		LoginEntity loginEntity2 = accountDao.update(loginEntity);
		System.out.println("loginEntity.getId() => " + loginEntity.getId());
		System.out.println("loginEntity2.getId() => " + loginEntity2.getId());
		
		
		return loginEntity2;
	}

}
