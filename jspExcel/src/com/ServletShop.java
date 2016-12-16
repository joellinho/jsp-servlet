package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Articulo;

/**
 * Servlet implementation class ServletShop
 */
@WebServlet("/ServletShop")
public class ServletShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletShop() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nombre = request.getParameter("nombre");
		String cantidad = request.getParameter("cantidad");

		Articulo articulo = new Articulo();
		articulo.setNombre(nombre);
		articulo.setCantidad(Integer.parseInt(cantidad));

		List<Articulo> listaArticulos = (List<Articulo>) session.getAttribute("articulos");
		if (listaArticulos == null) {
			listaArticulos = new ArrayList<>();
			System.out.println("se inicializa la lista");
			listaArticulos.add(articulo);
		} else {
			listaArticulos.add(articulo);
		}

		session.setAttribute("articulos", listaArticulos);

		System.out.println("mostrando articulos");
		for (Articulo articulo2 : listaArticulos) {

			System.out.println("articulo:" + articulo2.getNombre() + "cantidad:" + articulo2.getCantidad());

		}
		
		System.out.println("protocolo :"+request.getProtocol());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
