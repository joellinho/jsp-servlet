package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fechasrvlet
 */
public class fechasrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public fechasrvlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", -1);
		response.setHeader("refresh", "1");
		Date fecha = new Date();
		SimpleDateFormat formateador= new SimpleDateFormat("dd 'de'MMMM 'de'YYYY 'alas 'HH:mm:ss");
		String fechaformateada = formateador.format(fecha);
		PrintWriter out = response.getWriter();
		out.println(fechaformateada);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
