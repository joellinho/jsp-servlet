package com.mycompany.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;

import com.mycompany.modelo.Logging;
import com.mycompany.util.Util;

public class filtroLogging implements Filter {
	private DataSource ds;
	private Connection con;

	public filtroLogging() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("error al configurar cargar driver" + e.getMessage());
			e.printStackTrace();
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String accion = httpRequest.getParameter("accion");
		HttpSession session = httpRequest.getSession();

		String loginUrl = httpRequest.getContextPath() + "/jsp/login.jsp";
		boolean loggenId = session != null && session.getAttribute("usuario") != null;
		System.out.println(httpRequest.getContextPath());

		boolean loginRequest = httpRequest.getRequestURI().equals(loginUrl);
		//
		
			if (accion != null) {
				if (session.getAttribute("usuario") != null && session.getAttribute("id") != null) {
					Util util = new Util();
					String fecha = util.dia() + "/" + util.getMes() + "/" + util.getAnio();
					int idAdmin = (int) session.getAttribute("id");
					if (accion.equals("consultarAdministradores")) {
						if (new Logging(con).registrarLog(accion, idAdmin)) {
							System.out.println("registrado log correctamente   ");
						} else {
							System.out.println("error al registrar log");
						}
					} else if (accion.equals("resgistroPregunta")) {
						if (new Logging(con).registrarLog(accion + "  -" + fecha, idAdmin)) {
							System.out.println("registrado log correctamente");
						} else {
							System.out.println("error al registrar log");
						}

					}
				}

			}

			chain.doFilter(request, response);

			

		

	}

	public void init(FilterConfig fConfig) throws ServletException {
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

}
