package com.mycompany;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class ServletAjax
 */
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nombreImagen="";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//configuramos la salida
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		PrintWriter out = response.getWriter();   //obtenemos el flujo
		HttpSession session = request.getSession();
		
		String accion = request.getParameter("accion");
		if (accion != null) {
			if (accion.equals("cargarImagen")) {
				String string = cargarImagen(request, "C:/Users/admin-joel/Documents/workspace-sts-3.8.2.RELEASE/novellius/WebContent/img");
				session.setAttribute("urlImagen","/img/"+this.nombreImagen );
				System.out.println(string);
				out.println(string);
			}
		}
	}
	

	public String cargarImagen(HttpServletRequest request, String desitno) {
		String valorRetorno = "";
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) {
				String nombreImagen = item.getName();
				long tamanio = item.getSize();
				if (isImagenValida(item)) {
					if (tamanio > 0 && tamanio < 5242880) {
						File archivoCaragdo = new File(desitno, nombreImagen);
						item.write(archivoCaragdo);
						this.nombreImagen = nombreImagen;
						valorRetorno = "Imagen cargada correctamente";
					} else {
						valorRetorno = "tamaño maximo de la imagen es 5 mb";
					}
				} else {
					valorRetorno = "El archivo no es una imagen";
				}
			}
		} catch (Exception e) {
			System.out.println("error al cargar" + e.getMessage());
			valorRetorno = "error al Cargar Imagen";
		}
		return valorRetorno;
	}

	
	public boolean isImagenValida(FileItem archivo) {
		String nombre = archivo.getName();
		if (!nombre.isEmpty()) {
			String extencion3 = nombre.substring(nombre.length() - 3, nombre.length());
			String extencion4 = nombre.substring(nombre.length() - 4, nombre.length());
			if (extencion3.equals("jpg") || extencion3.equals("png") || extencion3.equals("bmp")) {
				return true;
			} else if (extencion4.equals("jpeg") || extencion4.equals("JPEG")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

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
