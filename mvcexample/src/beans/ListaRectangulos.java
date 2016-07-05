package beans;

import java.util.ArrayList;
import java.util.List;

public class ListaRectangulos {

	private List<Rectangulo> lista = new ArrayList<>();
	public void setRectangulo(Rectangulo r){
		lista.add(r);
	}
	public List<Rectangulo> getLista() {
		return lista;
	}
	public void setLista(List<Rectangulo> lista) {
		this.lista = lista;
	}

}
