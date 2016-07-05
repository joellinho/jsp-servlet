package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class carritoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public carritoservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String articulo = request.getParameter("articulo");
		HttpSession session = request.getSession();

		List<String> articulos = (List<String>) session.getAttribute("articulos");
		if (articulos == null) {
			articulos = new ArrayList<String>();
			session.setAttribute("articulos", articulos);
		}

		if (articulo != null && !articulo.trim().equals("")) {
			articulos.add(articulo);

	
		}
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("lista de articulis");
			for (String articulolista : articulos) {
				out.println("<p>"+articulolista.toString()+"</p>");
			}
			
			out.println("<a href='/carritodecompraservlet/index.jsp'>link al inicio</a>");
			out.println();
			out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
