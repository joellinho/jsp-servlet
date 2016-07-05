package com.joedayz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String navegador = request.getHeader("User-Agent");

		Enumeration<String> headers = request.getHeaderNames();
		//
		out.println("<html>");
		out.println("<h1>llamada a todos los cabeceros http</h1> 	");

		out.println(navegador);
		while (headers.hasMoreElements()) {
			out.println("</br>");
			String cabecero = headers.nextElement();
			out.println(cabecero);
			out.println("---->");
			out.println(request.getHeader(cabecero));

		}
		

		// variables CGI
		String[][] variables = { { "AUTH_TYPE", request.getAuthType() },
				{ "CONTENT_LENGTH", String.valueOf(request.getContentLength()) },
				{ "CONTENT_TYPE", request.getContentType() },
				{ "DOCUMENT_ROOT", getServletContext().getRealPath("/") },
				{ "PATH_INFO", request.getPathInfo() }, 
				{ "PATH_TRANSLATED", request.getPathTranslated() },
				{ "QUERY_STRING", request.getQueryString() }, 
				{ "REMOTE_ADDR", request.getRemoteAddr() },
				{ "REMOTE_HOST", request.getRemoteHost() }, 
				{ "REMOTE_USER", request.getRemoteUser() },
				{ "REQUEST_METHOD", request.getMethod() },
				{ "SCRIPT_NAME", request.getServletPath() },
				{ "SERVER_NAME", request.getServerName() }, 
				{ "SERVER_PORT", String.valueOf(request.getServerPort()) },
				{ "SERVER_PROTOCOL", request.getProtocol() },
				{ "SERVER_SOFTWARE", getServletContext().getServerInfo() } };

		out.println("<p>llamada a todas las variables sgi disponibles</p>" + "<TABLE BORDER=1 ALIGN=\"CENTER\">"
				+ "<TR BGCOLOR=\"#FFAD00\">" + "<TH>Variable CGI</TH><TH>Valor</TH>");
		for (int i = 0; i < variables.length; i++) {
			String varNombre = variables[i][0];
			String varValor = variables[i][1];
			if (varValor == null)
				varValor = "<I>No especificado</I>";
			out.println("<TR><TD>" + varNombre + "</TD><TD>" + varValor + "</TD>");
		}
		out.println("</TABLE></HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
// los cabeceros son informacion de la metadata de una peticion http
// indican informacion como el tipo de informacion el nombre del servidor
// el nombre del navegador etc atrves de los metodos getheadersnames() se
// obtienen todos los nombres de los cabeceros
// con el metodo getheader("nombre del header") se obtiene el valor asociado
// alos cabeceros

// Las variables de entorno de los scripts CGI es un conjunto de variables que
// contiene una colección
// variada de información. Algunas de estas variables se basan en la línea de
// petición HTTP o en sus
// cabeceras de petición, otras se derivan del propio socket utilizado para
// realizar la conexión o del
// servidor Web.
// Los servlets ofrecen mecanismos mucho más sencillos para obtener esta
// información a través de los
// interfaces tales como ServletRequest y HttpServletRequest.
