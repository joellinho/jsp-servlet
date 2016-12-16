package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class coockie
 */
@WebServlet("/coockie")
public class coockie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public coockie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] coockies = request.getCookies();
		String mensaje = "";
		boolean bandera = false;
		if (coockies != null) {
			for (Cookie cookie : coockies) {
				if (cookie.getName().equals("cliente") && cookie.getValue().equals("joel")) {

					bandera = true;
					break;
				}

			}
		}
		
		if(bandera){
			mensaje="bienvenido nuevamente";
			
		}else{
			mensaje="bienvenido al sistema";
		Cookie coockie = new Cookie("cliente", "joel");
		response.addCookie(coockie);
		
		}
		System.out.println(mensaje);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
