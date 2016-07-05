package beans;
import java.io.Serializable;

public class Rectangulo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int base;
	public int altura;

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getArea(){
		return this.base*this.altura;
		
	}
}
