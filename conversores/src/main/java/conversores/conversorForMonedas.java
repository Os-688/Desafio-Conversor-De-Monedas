package conversores;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import apiClass.ApiExchange;

public class conversorForMonedas extends Conversor {
	
	private ApiExchange ref = new ApiExchange();
	private Map<String, Double> conversor = new HashMap<>();
	private List<String> claves = new ArrayList<>();
	
	public conversorForMonedas() {
		configuracionInicialProporciones();
	}
	
	private void configuracionInicialProporciones() {
		
		conversor.put("inversionEUR", obtenerInversionMonedas(ref.getEUR()));
		conversor.put("inversionUSD", obtenerInversionMonedas(ref.getUSD()));
		conversor.put("inversionGBP", obtenerInversionMonedas(ref.getGBP()));
		conversor.put("inversionJPY", obtenerInversionMonedas(ref.getJPY()));
		conversor.put("inversionKRW", obtenerInversionMonedas(ref.getEUR()));
		
		conversor.put("pesoEUR", ref.getEUR());
		conversor.put("pesoUSD", ref.getUSD());
		conversor.put("pesoGBP", ref.getGBP());
		conversor.put("pesoJPY", ref.getJPY());
		conversor.put("pesoKRW", ref.getKRW());
		
		claves.add("inversionEUR");
		claves.add("inversionUSD");
		claves.add("inversionGBP");
		claves.add("inversionKRW");
		claves.add("inversionJPY");
		claves.add("pesoEUR");
		claves.add("pesoUSD");
		claves.add("pesoGBP");
		claves.add("pesoJPY");
		claves.add("pesoKRW");
	}
	
	public double ConvertirPorMoneda(String monedaInicial, String monedaFinal, double valorConvertir) {
		double resultado = 0;
		switch (monedaInicial.toLowerCase().strip()) {
		case "dolar":
			switch (monedaFinal.toLowerCase().strip()) {
			case "dolar": 
				return valorConvertir;
			case "libra":
				resultado = form(conversionResultado("menor", obtenerProporcionBase(ref.getUSD(), ref.getGBP()).get("proporcionGrandePequena"), valorConvertir));
				return resultado;
			case "won":
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getUSD(), ref.getKRW()).get("proporcionGrandePequena"), valorConvertir));
				return resultado;
			case "yen":
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getUSD(), ref.getJPY()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "euro":
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getUSD(), ref.getEUR()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "peso":
				resultado = form(conversionResultado("Mayor",  ref.getUSD(), valorConvertir));
				return resultado;
			default:
				System.out.println("Te falto una moneda final para convertir");
			}
			break;
		case "libra":
			switch (monedaFinal.toLowerCase().strip()) {
			case "dolar": 
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getUSD(), ref.getGBP()).get("proporcionGrandePequena"), valorConvertir));
				return resultado;
			case "libra":
				 return valorConvertir;
			case "won":
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getKRW(), ref.getGBP()).get("proporcionGrandePequena"), valorConvertir)) ;
				return resultado;
			case "yen":
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getGBP(), ref.getJPY()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "euro":
				resultado = form(conversionResultado("MAYor", obtenerProporcionBase(ref.getGBP(), ref.getEUR()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "peso":
				resultado = form(conversionResultado("Mayor",  ref.getGBP(), valorConvertir));
				return resultado;
			default:
				System.out.println("No ingresaste valor. Falta moneda final");
			}
			break;
		case "won":
			switch (monedaFinal.toLowerCase().strip()) {
			case "dolar": 
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getKRW(), ref.getUSD()).get("proporcionGrandePequena"), valorConvertir));
				return resultado;
			case "libra":
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getKRW(), ref.getGBP()).get("proporcionGrandePequena"), valorConvertir));
				return resultado;
			case "won":
				return valorConvertir;
			case "yen":
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getKRW(), ref.getJPY()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "euro":
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getKRW(), ref.getEUR()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "peso":
				resultado = form(conversionResultado("Menor",  ref.getKRW(), valorConvertir));
				return resultado;
			default:
				System.out.println("No ingresaste valor. Falta moneda final");
			}
			break;
		case "yen":
			switch (monedaFinal.toLowerCase().strip()) {
			case "dolar": 
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getUSD(), ref.getJPY()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "libra":
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getJPY(), ref.getGBP()).get("proporcionGrandePequena"), valorConvertir));
				return resultado;
			case "won":
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getJPY(), ref.getKRW()).get("proporcionGrandePequena"), valorConvertir)) ;
				return resultado;
			case "yen":
				return valorConvertir;
			case "euro":
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getJPY(), ref.getEUR()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "peso":
				resultado = form(conversionResultado("Menor",  ref.getJPY(), valorConvertir));
				return resultado;
			default:
				System.out.println("No ingresaste valor. Falta moneda final");
			}
			break;
		case "euro":
			switch (monedaFinal.toLowerCase().strip()) {
			case "dolar": 
				resultado = form(conversionResultado("mayor", obtenerProporcionBase(ref.getUSD(), ref.getEUR()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "libra":
				resultado = form(conversionResultado("Menor", obtenerProporcionBase(ref.getEUR(), ref.getGBP()).get("proporcionGrandePequena"), valorConvertir));
				return resultado;
			case "won":
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getEUR(), ref.getKRW()).get("proporcionGrandePequena"), valorConvertir)) ;
				return resultado;
			case "yen":
				resultado = form(conversionResultado("Mayor", obtenerProporcionBase(ref.getEUR(), ref.getJPY()).get("proporcionPequenaGrande"), valorConvertir));
				return resultado;
			case "euro":
				return valorConvertir;
			case "peso":
				resultado = form(conversionResultado("Mayor",  ref.getEUR(), valorConvertir));
				return resultado;
			default:
				System.out.println("No ingresaste valor. Falta moneda final");
			}
			break;
		case "peso":
			switch (monedaFinal.toLowerCase().strip()) {
			case "dolar": 
				resultado = form(conversionResultado("Menor", ref.getUSD(), valorConvertir));
				return resultado;
			case "libra":
				resultado = form(conversionResultado("Menor", ref.getGBP(), valorConvertir)); 
				return resultado;
			case "won":
				resultado = form(conversionResultado("mayor", ref.getKRW(), valorConvertir));
				return resultado;
			case "yen":
				resultado = form(conversionResultado("mayor", ref.getJPY(), valorConvertir));
				return resultado;
			case "euro":
				resultado = form(conversionResultado("menor", ref.getEUR(), valorConvertir));
				return resultado;
			case "peso":
				return valorConvertir;
			default:
				System.out.println("No ingresaste valor. Falta moneda final");
			}
			break;
		default:
			System.out.println("Escribe cual sera la moneda que quieres convertir y la moneda que deseeas obtener");
			break;
		}
		return resultado;
	}	
}
