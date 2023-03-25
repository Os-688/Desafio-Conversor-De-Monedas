package almacenTemporal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import apiClass.ApiExchange;

public class AlmacenarTest {
	@Test
    public void testSetAndGet() {
    	Almacenar test = new Almacenar();
    	/*test.setBooleanPreferences("ValorDePrueba", false);
    	 
    	test.getBooleanPreferences();
    	*/
    	System.out.println(test.abrirBooleanAlmacen("ValorDePrueba"));
    	
    	test.removerAlmacen("ValorDePrueba");
    	
    	System.out.println(test.abrirBooleanAlmacen("ValorDePrueba"));
    	
    	//Prueba terminada
    } 
}
