package com.revature.model;

public class Reimbursement {
	
	private int reimbursementId;
	private double reimbursementAmount;
	private String description;
	private int authorUserId;
	private int resolverUserId;
	private int statusId;
	private int reimbursementTypeId;
	
	public Reimbursement(int reimbursementId, double reimbursementAmount, String description, int authorUserId,
			int resolverUserId, int statusId, int reimbursementTypeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.description = description;
		this.authorUserId = authorUserId;
		this.resolverUserId = resolverUserId;
		this.statusId = statusId;
		this.reimbursementTypeId = reimbursementTypeId;
	}
	
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthorUserId() {
		return authorUserId;
	}
	public void setAuthorUserId(int authorUserId) {
		this.authorUserId = authorUserId;
	}
	public int getResolverUserId() {
		return resolverUserId;
	}
	public void setResolverUserId(int resolverUserId) {
		this.resolverUserId = resolverUserId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}
	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", description=" + description + ", authorUserId=" + authorUserId + ", resolverUserId="
				+ resolverUserId + ", statusId=" + statusId + ", reimbursementTypeId=" + reimbursementTypeId + "]";
	}	
}
