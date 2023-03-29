package entornoPruebas;

import java.util.Calendar;

import org.junit.Test;

public class DateAndStringBuffer{
	 @Test
	 public void claseDateAndBuffer() {
		
		Calendar c = Calendar.getInstance();
		int mesNuevo = c.get(Calendar.MONTH) + 1;
		int diaNuevo = c.get(Calendar.DATE);
		int annioNuevo = (int) c.get(Calendar.YEAR);
		
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(mesNuevo);
		String annio = Integer.toString(c.get(Calendar.YEAR));
		String cadena = new String(annio + mes + dia);
		StringBuffer rea = new StringBuffer();
		rea.append(annio).append("0");
		rea.append(mes).append(dia);
		String cuer = rea.substring(0, 8);
		double dob = Double.valueOf(cuer);
		long fechaHoy = Math.round(dob);
		
		System.out.println(fechaHoy);
	
	 }
}
