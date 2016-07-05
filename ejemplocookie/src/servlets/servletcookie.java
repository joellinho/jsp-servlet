package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.css.DOMImplementationCSS;
@WebServlet("/servletcookie")
public class servletcookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletcookie() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter pw= response.getWriter();
		
		Cookie[] micook = request.getCookies();
		String dominioCookie = null;
		boolean existe = true;
		
		
		if(micook!=null){
		for (Cookie cookie : micook) {
			if(cookie.getName().equals("nuevo")&& cookie.getValue().equals("si")){
				existe = false;
				dominioCookie = " "+cookie.getValue()+cookie.getName();
				//si encuentra el cookie sale del bucle si no recorre todo y pasa ala siguiente sentencia
				//la bandera es false si lo encuentra
				
				break;
			}
		}}
		
		//como no lo encontro crea la coockie y lo añade al response
		String mensa=null;
		if(existe){
		Cookie nuevacook = new Cookie("nuevo", "si");
		mensa ="buenveido a nuestro sitio";
		response.addCookie(nuevacook);
		}else{
			mensa="gracias por vistarnos nuevamente"+dominioCookie;
		}
		pw.println(mensa);
		//para la otra vez ya lo encontrara en el primer bucle  labandera existe sera false
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}


//una cookie es una onformacion que se guarda en el navegador cada vez que se realiza una peticion url
// es posible acceder a todo el arreglo de cookie con el objego request.getcookies que devuele arreglosd e objetos cookies
//podemos saber si ya tenemos esa cookie registrada si la guardamos como objeto nuevo mediante el objeto response //
//que entregara esa cookie al hhto y la tendra identificada, un objeto cookie tiene dos variables name y value que se pueden obtener