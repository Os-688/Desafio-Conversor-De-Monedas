package dialogos;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class InterfazInteractiva {
	
	public static void main(String[] args) {
		//Creación de la ventana de los dos conversores.
		
		Object [] conversores = {"Conversor de monedas", "Conversor de Temperatura"};
		Object mostrarConversores = JOptionPane.showInputDialog(null, "Menu", "Conversor: ", -1, null, conversores, conversores[0]);
		
		/*Conversiones de monedas.
		 * 
		 * Para Activar el conversor.
		 */
		
		Object [] monedas = {"De Pesos a Dólar.", "De Pesos a Euro.", "De Pesos a Yen.", "De Pesos a Won Coreano.", "De Dólar a Pesos.", "De Euro a Pesos.", "De Libras a Pesos."};
		Object messaje = "Elije la moneda a la que deseés convertir tu dinero: ";
		
		Object mostrarMonedas = null;
		boolean comprobadorString = false;
		
		if (mostrarConversores == "Conversor de monedas") {
			mostrarMonedas = JOptionPane.showInputDialog(null, messaje, "Conversor de monedas", -1, null, monedas, monedas[0]);
			comprobadorString = mostrarMonedas.getClass().getSimpleName().equals("String");
		}
		
		// Numero a convertir
		
		Object ingresarValor;
		String valorIngresado = "--";
		
		if (comprobadorString) {
			ingresarValor = JOptionPane.showInputDialog("Ingresa la cantidad a convertir.", 38.00);
			valorIngresado = ingresarValor.toString();		
		} 
		
		//Solo se permiten numeros.
		
		double numeroIngresado = 5.00;
		
		try {
			numeroIngresado = Double.valueOf(valorIngresado).doubleValue();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Escribe solo numeros", "Error solo se aceptan numeros.", 1);
		}
		
		//Resultado de la conversión.
		
		double factorPesoDolar = 18.5;
		double conversionPesoDolar = numeroIngresado/ factorPesoDolar;
		DecimalFormat df = new DecimalFormat("#.00000");
		String numeroFinal = df.format(conversionPesoDolar);
		
		Object resultado = "Tienes estos: " + numeroFinal;
		
		if (mostrarMonedas == "De Pesos a Dólar.") {
			JOptionPane.showMessageDialog(null, resultado, " Estos son tus dolares. ", 0);
		}

		
	}
}
