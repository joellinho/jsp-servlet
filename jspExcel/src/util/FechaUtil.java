package util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtil {
private static final String pattern="dd-MMMM-yyyy";
private static final String patternNumber ="#,##.00";

public static String formater(Date date){
	SimpleDateFormat format = new SimpleDateFormat(pattern);
	return format.format(date);
}


public static String formater(Object objeto){
	DecimalFormat format = (DecimalFormat)NumberFormat.getInstance();
	return format.format(objeto);
}
}
