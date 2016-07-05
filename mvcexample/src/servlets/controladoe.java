package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import beans.Rectangulo;

public class controladoe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controladoe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Rectangulo rect1 = new Rectangulo(2,3);
		Rectangulo rect2 = new Rectangulo(4,5);
		Rectangulo rect3 = new Rectangulo(6,7);
	String accion = request.getParameter("accion");
	
	if("agregarVariables".equals(accion)){
		
		request.setAttribute("rectanguloreq", rect1);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("rectuangulosession", rect2);
		
		ServletContext aplication = this.getServletContext();
		aplication.setAttribute("rectanguloaplication", rect3);
	
		request.setAttribute("mensaje","variables cargadas y enviadas " );
		request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);

		
	}else if("listarVariables".equals(accion)){
		
		
		request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
	}else{
		
		request.setAttribute("mensaje", "no se ah indicado la accion");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
