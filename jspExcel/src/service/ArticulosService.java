package service;

import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;

public class ArticulosService {

	List<Articulo> articulos= new ArrayList<Articulo>();

	public ArticulosService() {
		

	}

	
	public List<Articulo> getArticulos() {
		return articulos;
	}


	public void setListaArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}


	
	
	public void setArticulo(Articulo articulo){
		if(articulo!=null){
			articulos.add(articulo);
			
		}
		
	}

}
