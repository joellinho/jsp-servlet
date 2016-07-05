package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MuestraMensaje
 */
public class MuestraMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String mensaje;
	private String mensajePordefecto = "Hola";
	private int repeticiones = 3;

	public void init(ServletConfig config) throws ServletException {
		// siempre debemos añadir esta línea para esta versión del método init()
		super.init(config);
		mensaje = config.getInitParameter("mensaje");
		if (mensaje == null) {
			mensaje = mensajePordefecto;
		}
		try {
			String cadenaRepeticiones = config.getInitParameter("repeticiones");
			// debemos convertirlo a un entero, ya que getInitParameters()
			// siempre
			// devuelve objetos String
			repeticiones = Integer.parseInt(cadenaRepeticiones);
		} catch (NumberFormatException ex) {
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String titulo = "El Servlet muestra mensajes";
		out.println("<html><head><title>" + titulo + "</title></head>" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+ "<H1 ALIGN=CENTER>" + titulo + "</H1>");
		for (int i = 0; i < repeticiones; i++) {
			out.println(mensaje + "<BR>");
		}
		out.println("</BODY></HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
