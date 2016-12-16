package com.mycompany.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


public class Logging {
	private Connection con;
	public Logging(Connection con){
		this.con = con;
	}
	public boolean registrarLog(String accionLog,int idAdmin){
		String fecha = new Date().toString();
		try {
			PreparedStatement stm =con.prepareStatement("INSERT INTO log(accionlog,idadmin) values (?,?)");
			stm.setString(1, accionLog);
			stm.setInt(2, idAdmin);
			 stm.executeUpdate();
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	
		
	}
	
	
}
