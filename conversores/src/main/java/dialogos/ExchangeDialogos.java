package dialogos;

import javax.swing.JOptionPane;

import apiClass.ApiExchange;
import conversores.conversorForMonedas;

public class ExchangeDialogos extends CreacionDialogos{
	
	private Object [] discursos = crObjectArray("Menu", "Conversor:", "Elije la moneda a la que deseés convertir tu dinero: ", "Conversor de monedas:",
			"Ingresa la cantidad a convertir.", "Escribe solo numeros", "Error solo se aceptan numeros.", " Conversion terminada. ",
			"Selecciona la moneda que posees o desees transformar: ", "23");
	
	
	private Object [] fase1 = crObjectArray("Conversor de monedas", "Conversor de Temperatura");
	
	private Object [] fase2 = crObjectArray("Dolar", "Euro", "Yen", "Peso", "Libra", "Won", "Cancel"); 
	
	private boolean continuara = false;
	
	
	public Object ventanaFase1() {
		Object ventana = crVentanaOpciones(discursos[0].toString(),discursos[1].toString(), fase1, -1);
		return ventana;
	}
	
	public Object ventanaFase2() {
		Object ventana = crVentanaOpciones(discursos[8].toString(), discursos[3].toString(), fase2, -1);
		return ventana;
	}
	
	public Object ventanaFase3() {
		Object ventana = crVentanaOpciones(discursos[2].toString(), discursos[3].toString(), fase2, -1);
		return ventana;
	}
	
	public Object ventanaFase4() {
		Object ventana = crDialogoCampoTexto(discursos[4].toString(), 50);
		
		try {
			double numeroIngresado = Double.valueOf((String) ventana).doubleValue();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, discursos[5], discursos[6].toString(), 1);
			Object m = "Error con el numero ingresado, asegurese de ingresar numeros";
			System.out.println(m);
			return m;
		}
		return ventana;
	}
	
	public void ventanaFase5() {
		conversorForMonedas init = new conversorForMonedas();
		
		double resultado = init.ConvertirPorMoneda(ventanaFase2().toString(), ventanaFase3().toString(), Double.valueOf(ventanaFase4().toString()));
		Object resultadoFn = "Tienes un total: " + resultado;
		JOptionPane.showMessageDialog(null, resultadoFn , discursos[7].toString(), -1);	
		
		
	}
	
	public double ventanaFase6() {
		double rt = JOptionPane.showConfirmDialog(null, "Quieres realizar otra conversion?");
		return rt;
	}
	
	public void ciclarVentana() {
		boolean comprobar = ventanaFase1().toString() != "Conversor de monedas";
		
		if (comprobar) {
			JOptionPane.showMessageDialog(null, "Sorry","No se encuentra disponible por el momento.", -1);
		} else {
			ventanaFase5();			
			for (double continua = ventanaFase6(); continua == 0 ; continua = ventanaFase6()) {
				ventanaFase5(); 
			}
			JOptionPane.showMessageDialog(null, "Programa Finalizado","Cancelado", -1);
		}
	}
}
