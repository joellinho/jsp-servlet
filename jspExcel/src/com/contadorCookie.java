package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contadorCookie
 */
@WebServlet("/contadorCookie")
public class contadorCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public contadorCookie() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Integer contador = 0;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("contador")){
					contador=Integer.parseInt(cookie.getValue())+1;
					break;
				}
			}
			
		}
		String valor = contador.toString();
		Cookie coockie = new Cookie("contador", valor);
		response.addCookie(coockie);
		System.out.println("numero de visitas"+contador);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
