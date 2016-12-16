package com.mycompany;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.mycompany.modelo.Cuenta;
import com.mycompany.modelo.beans.Administrador;

public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String rutaJsp;
	private DataSource ds;
	private Connection con;

	public controller() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		rutaJsp = config.getInitParameter("rutajsp");

		InitialContext initContext;
		try {
			initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/joelJar");
			System.out.println("todo bien en el init");
		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession session = request.getSession();

		try {
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/administradores",
			// "root",
			// "Cibertec20160227");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("error al configurar cargar driver" + e.getMessage());
			e.printStackTrace();
		}

		if (accion != null) {

			if (accion.equals("login")) {
				setRespuestaController("login").forward(request, response);
			}

			else if (accion.equals("inicio")) {
				setRespuestaController("index").forward(request, response);
			}

			else if (accion.equals("iniciarSession")) {
				String usuario = request.getParameter("usuario");
				String password = request.getParameter("password");
				Cuenta cuenta = new Cuenta(con);
				try {
					if (request.getParameter("recuerdame").equals("on")) {
						Cookie cookie = new Cookie("usuario", usuario);
						// cookie.setMaxAge(60*60*24);
						response.addCookie(cookie);
					}
				} catch (NullPointerException e) {
					System.out.println("coockie vacio");
				}
				if (cuenta.login(usuario, password)) {

					session.setAttribute("usuario", usuario);
					session.setAttribute("id", (new Cuenta(con).findByUser(usuario)).getIdAdmin());
					// session.setAttribute("unautorized", "autirzed");
					setRespuestaController("index").forward(request, response);
				} else {
					request.setAttribute("error", "usario o contraseña incorrectos");
					setRespuestaController("login").forward(request, response);
				}

			}

			else if (accion.equals("logout")) {
				session.invalidate();
				setRespuestaController("login").forward(request, response);
			}

			else if (accion.equals("consultarAdministradores")) {
				List<Administrador> adminsitradores = new Cuenta(con).consultarAdministradores();
				String mensaje = "";
				if (adminsitradores.isEmpty()) {
					System.out.println("administradores esta vacio");
					mensaje = "no se encontró administradores";
				} else {
					mensaje = "adminsitradores encontrados";
					request.setAttribute("adminsitradores", adminsitradores);
				}
				request.setAttribute("mensaje", mensaje);
				setRespuestaController("consultaAdministradores").forward(request, response);

			}

			else if (accion.equals("resgistroPregunta")) {
				setRespuestaController("registroPregunta").forward(request, response);
			}

			else if (accion.equals("resgistrarPregunta")) {
				setRespuestaController("pregunta").forward(request, response);
			}

			else if (accion.equals("registroAdmin")) {
				setRespuestaController("registroAdmin").forward(request, response);
			}

			else if (accion.equals("registrarAdmin")) {

				String nombreCorreo = request.getParameter("correo");
				String dominio = request.getParameter("dominio");
				String correo = nombreCorreo + "@" + dominio;

				String contrasena = request.getParameter("contrasena");
				String nombre = request.getParameter("nombre");
				int pregunta = Integer.parseInt(request.getParameter("pregunta"));
				String respuesta = request.getParameter("respuesta");

				Administrador administrador = new Administrador();
				administrador.setCorreo(correo);
				administrador.setContasena(contrasena);
				administrador.setNombre(nombre);
				administrador.setIdPegunta(pregunta);
				administrador.setRespuesta(respuesta);

				if (session.getAttribute("urlImagen") != null) {
					if (!session.getAttribute("urlImagen").equals("")) {
						administrador.setImagen((String) session.getAttribute("urlImagen"));
					
					}
				}
				Cuenta cuenta = new Cuenta(con);

				if (administrador.isValidAdministrador()) {
					if (cuenta.Registrar(administrador)) {
						System.out.println("registro correctamente");
						setRespuestaController("index").forward(request, response);
					} else {
						
						setRespuestaController("registroAdmin").forward(request, response);

					}
				} else {
					System.out.println("hubo un error en el registro");
					request.setAttribute("mensajes", administrador.getErroresForm());
					setRespuestaController("registroAdmin").forward(request, response);

				}

			}

		} else {
			setRespuestaController("login").forward(request, response);
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("error al cerrar la coneccion" + e.getMessage());

		}

	}

	public RequestDispatcher setRespuestaController(String vista) {
		String url = rutaJsp + vista + ".jsp"; // "/jsp/"
		return getServletContext().getRequestDispatcher(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
