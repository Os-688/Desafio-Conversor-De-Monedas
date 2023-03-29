package conversores;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;

public class Conversor {
	
	
	// En conversion proporcionBaseMnORMy se coloca la base de donde se va a convertir esta siendo uno de las dos monedas en la que se realiza la proporcion de monedas.
	// proporcionBaseMnORMy se escribe si es mayor o menor la unidad en relacion con la que se convertira para obtener el numero.
	
	protected double conversionResultado(String proporcionBaseMnORMy,double proporcionBase , double numeroMonedaBase) {
		double resultado = 0;
		double relacionProporcion = 1;
		
		switch (proporcionBaseMnORMy.toLowerCase()) {
		case "mayor":
			if (proporcionBase > relacionProporcion) {
				resultado = numeroMonedaBase * proporcionBase;
			}else {
				resultado = numeroMonedaBase / proporcionBase;
			}
			break;
		case "menor":
			if (proporcionBase > relacionProporcion) {
				resultado = numeroMonedaBase / proporcionBase;
			}else {
				resultado = numeroMonedaBase * proporcionBase;
			}
		default:
			break;
		}
		
		return resultado;
	}
	
	protected Double form(double u) {
		DecimalFormat df = new DecimalFormat("#.00000");
		String numeroFinal = df.format(u);
		return Double.valueOf(numeroFinal);
	}
	
	//Obtienes la inversion opuesta: De la unidad de monedad y su equivalente en la otra moneda. 
	//En Orden de revertir quien es la unidad y el equivalente.
	
	protected double obtenerInversionMonedas(double proporcionUnidad) {
		double inversion = 0;
		double proporcionDirecta = 1;
		if (proporcionUnidad > proporcionDirecta) {
			inversion =  proporcionDirecta / proporcionUnidad;
		}else {
			inversion =  1 / proporcionUnidad ;
		}
		return inversion;
	}
	
	//El metodo devuelve la proporcion que quieras. El parametro proporcionDeReferencia1 es el que representara la unidad y proporcionDeReferencia2 el 	
	//equivalente a la unidad de Moneda.Ya que se toma una referencia de UnidadPesos a su equivalente a otra moneda. La referencia de proporcion debe ser 
	//de la moneda equivalente a una unidad de peso. Es necesario que tengan la misma base  
	
	protected Map<String, Double> obtenerProporcionBase(double proporcionDeReferenciaInicial, double proporcionDeReferenciaFinal) {
		
		Map<String, Double> proporciones = new HashMap<>();
		double monedaInicialInPesos = 0;
		double monedaFinalInPesos = 0;
		double proporcionGrandePequena = 0;
		double proporcionPequenaGrande = 0;
		// Variable semantica que significa si es por unidad mas de uno o menor de uno: Cambia la representacion de uno. 
		double underOrOver = 1;
		
		// Es una division que representa los casos en los que se divide la moneda para obtener la proporcion
		monedaInicialInPesos = underOrOver / proporcionDeReferenciaInicial;
		
		monedaFinalInPesos = underOrOver / proporcionDeReferenciaFinal;
		
		//El retorno devuelve la proporcion de unidades(pesos) entre la moneda mas grande y la otra moneda. El resultado son las monedas pequeñas necesarias
		//para una moneda grande.
		if (monedaInicialInPesos > monedaFinalInPesos) {
			 proporcionPequenaGrande = monedaInicialInPesos / monedaFinalInPesos;
		} else {
			proporcionPequenaGrande = monedaFinalInPesos / monedaInicialInPesos;
		}
		//El retorno devuelve la proporcion de unidades(pesos) entre la moneda mas grande y la otra moneda. El resultado es la cantidad de una moneda grande
		//de una unidad de una moneda pequeña. EN PROPORCION_AMBAS_PEQUENA.
		proporcionGrandePequena = 1 / proporcionPequenaGrande;
		
		proporciones.put("proporcionPequenaGrande", proporcionPequenaGrande);
		proporciones.put("proporcionGrandePequena", proporcionGrandePequena);
		
		return proporciones;
		
	}
	
	public String [] obtenerClaves() {
		String [] st = {"proporcionPequenaGrande", "proporcionGrandePequena"};
		return st;
	}
	
}
