package conversores;

import java.text.DecimalFormat;
import java.util.Map;

import org.junit.Test;

import apiClass.ApiExchange;

public class conversorTest {
	@Test
	public void testConversorForMonedas() {
		ApiExchange test =  new ApiExchange();
		double proporcion = test.getJPY();
		double pesosEur = 1 / proporcion;
		
		
		//System.out.println(proporcion);
		System.out.println(pesosEur);
	}
	@Test
	public void testFormatear() {
		ApiExchange test =  new ApiExchange();
		double proporcion = test.getJPY();
		double pesosEur = 1 / proporcion;
		DecimalFormat df = new DecimalFormat("#.00000");
		String numeroFinal = df.format(pesosEur);
		double dou = Double.valueOf(numeroFinal);
		
		
		System.out.println(dou);
		
	}
	@Test
	public void testNumeros() {
		System.out.println(18/0.24);
		System.out.println(0.24/18);
		System.out.println(0.24 *18);
	}
	@Test
	public void testObtenerProporcion() {
		ApiExchange test = new ApiExchange();
		double inicial = test.getUSD();
		double fn = test.getJPY();
		Conversor prueba = new Conversor();
		Map<String, Double> testfn = prueba.obtenerProporcionBase(fn, inicial);
		System.out.println(1 / 131.47615892820997 );
		System.out.println(testfn);
	}
	@Test
	public void testObtenerValores() {
		ApiExchange test = new ApiExchange();
		double inicial = test.getUSD();
		double fn = test.getGBP();
		Conversor prueba = new Conversor();
		Map<String, Double> testfn = prueba.obtenerProporcionBase(fn, inicial);
		
		System.out.println(prueba.conversionResultado("menor", testfn.get("proporcionGrandePequena"), 50));
		System.out.println(testfn);
		System.out.println(prueba.conversionResultado("mayor", testfn.get("proporcionPequenaGrande"), 50));
	}
}
