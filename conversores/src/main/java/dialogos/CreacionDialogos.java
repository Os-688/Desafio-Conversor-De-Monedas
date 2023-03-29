package dialogos;

import javax.swing.JOptionPane;

public class CreacionDialogos {
	
	public Object crVentanaOpciones(String mensaje1, String mensaje2, Object [] opcionables, int n) {
		Object ventana = JOptionPane.showInputDialog(null, mensaje1, mensaje2, n, null, opcionables, opcionables[0]);
		return ventana;
	}
	
	public Object [] crObjectArray (String n1, String n2, String n3, String n4, String n5,String n6,String n7) {
		Object [] valores = {n1.strip(),n2.strip(),n3.strip(),n4.strip(),n5.strip(),n6.strip(),n7.strip()};
		return valores;
	}
	public Object [] crObjectArray (String n1,String n2) {
		Object [] valores = {n1.strip(),n2.strip()};
		return valores;
	}
	public Object [] crObjectArray (String n1, String n2, String n3, String n4, String n5,String n6, String n7, String n8, String n9, String n10) {
		Object [] valores = {n1.strip(),n2.strip(),n3.strip(),n4.strip(),n5.strip(),n6.strip(),n7.strip(),n8.strip(),n9.strip(),n10.strip()};
		return valores;
	}
	
	public Object crDialogoCampoTexto(String mensaje1, double predefinido) {
		Object ingresarValor = JOptionPane.showInputDialog(mensaje1, predefinido);
		return ingresarValor;
	}
}
