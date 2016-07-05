package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class sessionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public sessionservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String titulo = null;
		Integer contador = null;

		contador = (Integer) session.getAttribute("contadorvisitas");

		if (contador == null) {
			contador = new Integer(1);
			titulo = "bienvenido";
		} else {
			titulo = "hola otra vez";
			contador += 1;
		}
		session.setAttribute("contadorvisitas", contador);
		PrintWriter out = response.getWriter();
		out.println("mensaje " + contador);
		out.println("");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
