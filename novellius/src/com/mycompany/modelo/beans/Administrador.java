package com.mycompany.modelo.beans;

import javax.xml.bind.Validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.omg.CORBA.PRIVATE_MEMBER;

import sun.security.pkcs11.Secmod.DbMode;

public class Administrador {
	private int idAdmin;
	private String correo;
	private String contasena;
	private String nombre;
	private int idPegunta;
	private String respuesta;
	private String imagen;
	private StringBuilder sb;

	
	public String getErroresForm() {
		return (sb!=null) ? sb.toString() : new StringBuilder().toString();
	}
	
	public boolean isValidAdministrador(){
		sb = new StringBuilder();
		EmailValidator emailValidator = EmailValidator.getInstance();
        boolean valorRetorno = false;
		if(!emailValidator.isValid(correo)){
			sb.append("Email e sinvalido");
			valorRetorno = false;
		}
		if(contasena.equals("")){
			sb.append("escriba una contraseña");
			valorRetorno = false;
		}else if (contasena.length()<3) {
			sb.append("contraseña es muy corta");
			valorRetorno = false;
		}
		if(nombre.equals("")){
			sb.append("Nombre no puede estar vacio");
			valorRetorno = false;
		}
		if(sb.length()==0){
			return true;
		}
		return valorRetorno;
	}
	
	
	public Administrador() {
		super();
	}
	public Administrador(int idAdmin, String correo, String contasena, String nombre, int idPegunta, String respuesta) {
		super();
		this.idAdmin = idAdmin;
		this.correo = correo;
		this.contasena = contasena;
		this.nombre = nombre;
		this.idPegunta = idPegunta;
		this.respuesta = respuesta;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContasena() {
		return contasena;
	}
	public void setContasena(String contasena) {
		this.contasena = contasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdPegunta() {
		return idPegunta;
	}
	public void setIdPegunta(int idPegunta) {
		this.idPegunta = idPegunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", correo=" + correo + ", contasena=" + contasena + ", nombre="
				+ nombre + ", idPegunta=" + idPegunta + ", respuesta=" + respuesta + "]";
	}
	
	
}
