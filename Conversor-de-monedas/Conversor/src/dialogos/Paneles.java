package dialogos;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Paneles {

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

		//Aprendizajes no aplicados:
		
		/* Como hacer una lista:
		JList list = new JList();
		list.setBounds(96, 100, 128, 48);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"De Pesos a Dólar.", "De Pesos a Euro.", "De Pesos a Libras.", "De Pesos a Yen.", "De Pesos a Won Coreano.", "De Dólar a Pesos.", "De Euro a Pesos.", "De Libras a Pesos."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		marco.getContentPane().add(list);
		*/
		
		/* Manera alterna de realizar una lista
		 * 
		String[] conversiones = {"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras", "De Pesos a Yen",
		 "De Pesos a Won Coreano", "De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos"};
		JList<String> lista = new JList<String>(conversiones);
		marco.getContentPane().add(lista, BorderLayout.CENTER); 
		*/
		
		/* Como hacer una barra de desplazamiento (No funciona con una lista)
		 * 
		JTextArea textArea =  new  JTextArea( 20 ,  20 );  
        JScrollPane scrollableTextArea =  new  JScrollPane(textArea);  
  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
        frame.getContentPane().add(scrollableTextArea);  
		*/

		/*No funciona este método para conseguir transformar el object a double.
		 * 
			double ingresaResultado = (double)ingresarValor;	
		*/
	}

}
