package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class formservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public formservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	String nombre = request.getParameter("usuario");
	String pass = request.getParameter("password");
	PrintWriter out = response.getWriter();
	
	if (nombre.equals("joel")&&pass.equals("123")) {
		response.sendRedirect("http://www.google.com.pe");;
	} else {
		response.sendError(response.SC_UNAUTHORIZED,"el usuario y el pasword no son correctos");
	}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
