package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletindex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletindex() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String informacion = request.getServerName();
	PrintWriter pw = response.getWriter();
	pw.println("<html>");
	pw.println("<p>");
	pw.println("hola desde el servidor");
	pw.println("</p>");
	pw.println("</html>");
	
	System.out.println("");
	System.out.println("html");
	System.out.println("p");
	System.out.println("hola desde el servidor");
	System.out.println("</p>");
	System.out.println("</html>");
	System.out.println("fin");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
