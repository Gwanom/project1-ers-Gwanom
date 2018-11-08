package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.AppUser;
import com.revature.model.UserRole;
import com.revature.util.ConnectionUtil;

public class UserDaoJdbc implements UserDao {
	
	private Logger log = Logger.getRootLogger();

	private AppUser extractFromResultSet(ResultSet rs) throws SQLException {
		return new AppUser(rs.getInt("user_id"), rs.getString("username"), rs.getString(""),
			   rs.getString(""), rs.getString(""), rs.getString(""),
			   new UserRole(rs.getInt("role_id"), rs.getString("role_name")));
	}

	@Override
	public AppUser findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM app_users INNER JOIN user_roles USING (role_id) WHERE user_id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractFromResultSet(rs);
			}
		} catch (SQLException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AppUser> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM app_users INNER JOIN user_roles USING (role_id)");
			ResultSet rs = ps.executeQuery();
			List<AppUser> users = new ArrayList<>();
			while (rs.next()) {
				users.add(extractFromResultSet(rs));
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AppUser findByUsernameAndPassword(String username, String password) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM app_users INNER JOIN user_roles USING (role_id) WHERE username = ?  AND pass = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractFromResultSet(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
