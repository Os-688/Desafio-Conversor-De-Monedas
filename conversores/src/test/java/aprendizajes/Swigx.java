package aprendizajes;

public class Swigx {
	public static void main(String[] args) {
		//Aprendizajes:
		
		// Jlist no acopla scrollPane. Y la interfaz para modificar JFrame acepta a su manera la creacion de elementos de swig.
		
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
		//No es relevante llamar al constructor, al nombrar el método de la clase que hereda lo realiza. Esto en la utilizacion de un metodo de la clase que da herencia dentro de la clase que recibe la herencia.
	}
}
