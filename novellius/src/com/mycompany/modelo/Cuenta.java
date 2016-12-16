package com.mycompany.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycompany.modelo.beans.Administrador;

public class Cuenta {

	private Connection con;

	public Cuenta(Connection con) {
		super();
		this.con = con;
	}

	
	public boolean login(String email, String contrasena) {
		String sql = "select count(*) as count from adminstrador where correo= ? and contasena = ? ";
		int cta = 0;
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, contrasena);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				cta = rs.getInt("count");
					
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("error al realizar login :" + e.getMessage());
			return false;
		}
		if (cta == 0) {
			return false;

		} else {
			return true;
		}
	}
	
	
	
	public  ArrayList<Administrador> consultarAdministradores(){
		ArrayList<Administrador> lista = new ArrayList<>();
		String consulta ="select * from adminstrador";
		try {
			PreparedStatement statement = con.prepareStatement(consulta);
			ResultSet result = statement.executeQuery();
			while (result.next()){
				Administrador admin = new Administrador();
				admin.setIdAdmin(result.getInt("idAdmin"));
				admin.setCorreo(result.getString("correo"));
				admin.setContasena(result.getString("contasena"));
				admin.setNombre(result.getString("nombre"));
				admin.setIdPegunta(result.getInt("id"));
				admin.setRespuesta(result.getString("respuesta"));
				admin.setImagen(result.getString("urlImagen"));
				lista.add(admin);
			}
			result.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return lista;
	}
	
	
	public Administrador findByUser(String usuario){
		Administrador admin = new Administrador();
		String consulta ="select * from adminstrador where correo= ?";
		try {
			PreparedStatement st = con.prepareStatement(consulta);
			st.setString(1, usuario);
			ResultSet result = st.executeQuery();
			while(result.next()){
				admin.setIdAdmin(result.getInt("idAdmin"));
				admin.setCorreo(result.getString("correo"));
				admin.setContasena(result.getString("contasena"));
				admin.setNombre(result.getString("nombre"));
				admin.setIdPegunta(result.getInt("id"));
				admin.setRespuesta(result.getString("respuesta"));
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("error en la consulta daministrador by usuario");
		}
		return admin;
	}
	
	
	
	public boolean Registrar(Administrador administrador){
		String query = "insert into adminstrador(correo,contasena,nombre,id,respuesta,urlImagen) VALUES (?, ?, ?,?, ?,?)";
		try{
			PreparedStatement  st =  con.prepareStatement(query);
			st.setString(1, administrador.getCorreo());
			st.setString(2, administrador.getContasena());
			st.setString(3,administrador.getNombre());
			st.setInt(4,administrador.getIdPegunta());
			st.setString(5, administrador.getRespuesta());
			st.setString(6, administrador.getImagen());
			st.executeUpdate();
			st.close();
			return true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		
	}
	
	
}
