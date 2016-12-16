package com.mycompany.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util {
	GregorianCalendar calendar;

	public Util() {
		calendar = new GregorianCalendar();
	}

	public String getAnio() {

		return String.valueOf(calendar.get(calendar.YEAR));
	}

	public String getMes() {
		int indice = calendar.get(calendar.MONTH) + 1;
		String mes;
		switch (indice) {
		case 1:
			mes = "enero";
			break;

		case 2:
			mes = "febrero";
			break;
		case 3:
			mes = "marzo";
			break;
		case 4:
			mes = "abril";
			break;
		case 5:
			mes = "mayo";
			break;
		case 6:
			mes = "junio";
			break;
		case 7:
			mes = "julio";
			break;
		case 8:
			mes = "agosto";
			break;
		case 9:
			mes = "septiembre";
			break;
		case 10:
			mes = "octubre";
			break;
		case 11:
			mes="noviembre";
			break;
		case 12:
			mes="diciembre";
			break;
		default:
			mes="no definido";
			break;
		}
		return mes;
	}
	public String dia(){
		int  dia =calendar.get(calendar.DAY_OF_MONTH);
		if(dia<=9){
			return "0"+ String.valueOf(dia);
		}else{
		return String.valueOf(dia);
		}
	}
}
