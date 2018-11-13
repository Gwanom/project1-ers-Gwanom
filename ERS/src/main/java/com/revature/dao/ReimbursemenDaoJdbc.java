package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Reimbursement;

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
	private Reimbursement extractRFromResultSet(ResultSet rs) throws SQLException {
		log.trace("AppUserDaoJdbc.extractRFromResultSet()");
		return new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amt"), rs.getTimestamp("reimb_submitted"),
				rs.getTimestamp("reimb_resolved"), rs.getString("reimb_description"), rs.getInt("reimb_author"),
				rs.getInt("reimb_resolver"), rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
	}
	
	@Override
	public Reimbursement findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> findByStatusId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReimbursement(Reimbursement reim) {
		// TODO Auto-generated method stub
		return 0;
	}

}
