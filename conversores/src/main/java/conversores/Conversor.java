package conversores;

import java.text.DecimalFormat;

public class Conversor {
	public String resultado(double numeroIngresado, double factor) {
		double conversion = numeroIngresado/ factor;
		DecimalFormat df = new DecimalFormat("#.00000");
		String numeroFinal = df.format(conversion);
		return numeroFinal;
	}
}
