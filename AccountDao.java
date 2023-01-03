package jp.co.masquerade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.co.masquerade.entity.LoginEntity;

public class AccountDao {
	
	public LoginEntity update(LoginEntity loginEntity) {
		
		//return用オブジェクトの生成
		ArrayList<LoginEntity> account = new ArrayList<LoginEntity>();
		
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/masq");
			
			try (Connection connection = dataSource.getConnection()) {

				PreparedStatement ps = connection.prepareStatement(
						
						//SQL文
						"UPDATE account SET"
						+ " name = ?, "
						+ " gender_code=?, "
						+ " region_code=?, "
						+ " introduction=?, "
						+ " activity=? "
						+ " WHERE seq_id = ?"
						);

				ps.setString(1,loginEntity.getName());
				ps.setString(2,loginEntity.getGenderCode());
				ps.setString(3,loginEntity.getRegionCode());
				ps.setString(4,loginEntity.getIntroduction());
				ps.setString(5,loginEntity.getActivity());
				ps.setInt(6,loginEntity.getSeqId());

						ps.executeUpdate();
						
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				} catch (NamingException e) {
					e.printStackTrace();
				}
					return loginEntity;
				}
		}
