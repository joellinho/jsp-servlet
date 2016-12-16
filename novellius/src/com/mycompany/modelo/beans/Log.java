package com.mycompany.modelo.beans;

public class Log {

	private int idLog;
	private String anccionLog;
	private int idAdmin;
	
	
	
	public Log(int idLog, String anccionLog, int idAdmin) {
		super();
		this.idLog = idLog;
		this.anccionLog = anccionLog;
		this.idAdmin = idAdmin;
	}
	public int getIdLog() {
		return idLog;
	}
	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	public String getAnccionLog() {
		return anccionLog;
	}
	public void setAnccionLog(String anccionLog) {
		this.anccionLog = anccionLog;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	
}
