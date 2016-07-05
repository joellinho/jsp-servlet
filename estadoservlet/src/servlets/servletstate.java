package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletstate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url=null;
		String navegador = request.getHeader("User-Agent");
	if (navegador!=null && navegador.contains("MSSIS")) {
		url="http://www.facebook.com";
	} else if(navegador!=null && navegador.contains("Firefox")){
		url="htto://twiter.com";
	}else{
		url="http://www.google.com.pe";
	}
	response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
