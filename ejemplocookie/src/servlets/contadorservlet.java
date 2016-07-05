package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contadorservlet")
public class contadorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public contadorservlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	Cookie[] cookis = request.getCookies();
	int contador = 0;
	
	if (cookis!=null) {
		for (Cookie cookie : cookis) {
			if(cookie.getName().equals("identificador")){
				contador= Integer.parseInt(cookie.getValue());
				//si encuentra ala coockie llamada identificador parsea su value y lo asigan a contador
				
			}
		}
	} 
	//ala segunda vuelta lo encuentra y incrementa el contador
	contador++;
	Cookie nuevacookie = new Cookie("identificador", Integer.toString(contador));
	nuevacookie.setMaxAge(3600);
	response.addCookie(nuevacookie);
	//crea la coockie y le asigna el valo pero previamente incrementado si no siempre sera el mismo
	
	PrintWriter out = response.getWriter();
	out.println(contador);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
