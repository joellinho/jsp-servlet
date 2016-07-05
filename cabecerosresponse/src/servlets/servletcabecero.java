package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class servletcabecero
 */
public class servletcabecero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletcabecero() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	response.setContentType("application/vnd-excel");
	response.setHeader("Content-disposition","inline; filename=nombre.xls");
	PrintWriter out = response.getWriter();
	try {
		out.println("\tvalores");
		out.println("\t1 ");
		out.println("\t2");
		out.println("suma \t=SUMA(B2:B3)");
	} finally {
		out.close();
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
