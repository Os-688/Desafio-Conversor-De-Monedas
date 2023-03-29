package conversores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import apiClass.ApiExchange;

public class TestConversorMonedas {
	 @Test
	 public void testInversionMonedasOver() {
		ApiExchange test =  new ApiExchange();
		double peso = 1;
		double proporcion = test.getJPY();
		double pesosJPY = proporcion;
		System.out.println(pesosJPY);
		System.out.println(proporcion);
		
		double inversion = peso / pesosJPY;
		System.out.println(inversion);
	 }
	 
	 @Test
	 public void testInversionMonedasUnder() {
		 ApiExchange test =  new ApiExchange();
			double peso = 1;
			double proporcion = test.getEUR();
			double pesosEUR = 1 / proporcion;
			System.out.println(pesosEUR);
			System.out.println(proporcion);
			
			
			//double inversion = peso / pesosJPY;
			
	 }
	 @Test 
	 public void testConvertirMonedas() {
		conversorForMonedas test = new conversorForMonedas();
		double dolar = test.ConvertirPorMoneda("libra", "yen", 50);
		String [] lista = {" dolar", " libra", "won ", " yen", "euro ", " peso"};
	
		List<String> list = new ArrayList<>();
		for (int i = 0; i < lista.length; i++) {
			list.add(lista[i]);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			String st = new String(list.get(i));
		}
		
		/*
		for (String string : list) {
			for (String string2 : list) {
				System.out.println(test.ConvertirPorMoneda(string.toString(), string2.toString(), 50));
			}
		}
		*/
		double n = 50;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				System.out.println(test.ConvertirPorMoneda(list.get(i), list.get(j), n));
			}
		}
		
		
	 }
}
