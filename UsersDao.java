package jp.co.masquerade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.co.masquerade.entity.UsersEntity;

public class UsersDao {
	
	public UsersEntity insert (UsersEntity usersEntity) {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/masq2");
			
			try (Connection connection = dataSource.getConnection()) {
				
				PreparedStatement ps = connection.prepareStatement(
						"insert into users ("
								+"id"
								+ ",name "
								+ ",password"
								+",gender"
								+",region"
								+",birthday"
								+",introduction"
								+",maskCode"
								+",activity"
								+",createdDate"
								+",lastLoginDate"
								+",withdrawalFlg"
								+ ") values ("
								+ "?,?,?"
								+ ") returning id;");
				
				ps.setString(1, usersEntity.getId());
				ps.setString(2, usersEntity.getName());
				ps.setString(3, usersEntity.getPassword());
				ps.setString(4, usersEntity.getGenderCode());
				ps.setString(5, usersEntity.getRegionCode());
				ps.setDate(6, usersEntity.getBirthday());
				ps.setString(7, usersEntity.getIntroduction());
				ps.setString(8, usersEntity.getMaskCode());
				ps.setString(9, usersEntity.getActivity());
				ps.setDate(10, usersEntity.getCreatedDate());
				ps.setDate(11, usersEntity.getLastLoginDate());
				//ps.setString(12, usersEntity.getWithdrawalFlg());
				
				
				ResultSet resultSet = ps.executeQuery();
				resultSet.next();
				String id = resultSet.getString("id");
				usersEntity.setId(id);
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
			return usersEntity;
		}
}
