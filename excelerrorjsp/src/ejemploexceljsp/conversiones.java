package ejemploexceljsp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class conversiones {

	
	public static String formatear(Date fecha) {
		SimpleDateFormat formateador = new SimpleDateFormat("dd-mm-yy");
		return formateador.format(fecha);

	}

	public static String formatear(Object value) {
		
			DecimalFormat formateador = (DecimalFormat) NumberFormat.getInstance();
			formateador.applyPattern("$#,##.oo");
			return formateador.format(value);	
			// TODO: handle exception
	}

}
