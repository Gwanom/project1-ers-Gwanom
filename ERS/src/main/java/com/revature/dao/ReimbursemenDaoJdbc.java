package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursemenDaoJdbc implements ReimbursementDao {

	private Logger log = Logger.getRootLogger();

	/**
	 * Given an SQL ResultSet object, create and return a new Reimbursement object,
	 * populating its fields with the data retrieved from the database
	 * 
	 * @param rs - an SQL result set containing the details of a single
	 *           reimbursement
	 * @return a new Reimbursement object
	 * @throws SQLException
	 */
	private Reimbursement extractFromResultSet(ResultSet rs) throws SQLException {
		log.trace("AppUserDaoJdbc.extractRFromResultSet()");
		return new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amt"), rs.getTimestamp("reimb_submitted"),
				rs.getTimestamp("reimb_resolved"), rs.getString("reimb_description"), rs.getInt("reimb_author"),
				rs.getInt("reimb_resolver"), rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
	}
	
	@Override
	public Reimbursement findById(int id) {
		log.trace("ReimbursementDaoJdbc.findById()");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> findByStatusId(int id) {
		log.trace("ReimbursementDaoJdbc.findByStatusId()");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Reimbursement> reimbs = new ArrayList<>();
			while (rs.next()) {
				reimbs.add(extractFromResultSet(rs));
			}
			return reimbs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> findAll() {
		log.trace("ReimbursementDaoJdbc.findById()");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement");
			ResultSet rs = ps.executeQuery();
			List<Reimbursement> reimbs = new ArrayList<>();
			while (rs.next()) {
				reimbs.add(extractFromResultSet(rs));
			}
			return reimbs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateReimbursement(int reimbId, int statusId) {
		log.trace("ReimbursementDaoJdbc.updateReimbursement()");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE reimbursement SET reimb_resolved=?, reimb_status_id=? WHERE reimb_id=?"
			);
			ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			ps.setInt(2, statusId);
			ps.setInt(3, reimbId);
			ResultSet rs = ps.executeQuery();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
