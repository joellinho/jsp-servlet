package com;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newServlet
 */
public class newServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private String mensaje;
   private String mensajePorDefecto = "hola";
   
   
    public newServlet() {
        super();


    }
    


	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig config =this.getServletConfig();
		
		Enumeration header = request.getHeaderNames();
		
		
		mensaje = config.getInitParameter("mensaje");
		System.out.println(mensaje);
		
		while (header.hasMoreElements()){
			String nombreCabecer = (String)header.nextElement();
			System.out.println("cabecero "+nombreCabecer+":");
			System.out.println(""+request.getHeader(nombreCabecer));
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
