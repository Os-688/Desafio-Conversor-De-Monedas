package testApiClass;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.text.Format;

import org.junit.Test;

import apiClass.ApiExchange;


public class ApiExchangeTest {
	/**
     * Rigorous Test :-)
     */ 
	@Test
    public void testGetUsd() {
    	ApiExchange test = new ApiExchange();
    	
    	double result = test.getUSD();
    	
    	assertEquals("La funcion no da el valor esperado", 0.053798, result, 0.01);
    	System.out.println(result);    	
    	
    } 
	//Prueba terminada
	@Test
	public void testGuardarValores() {
		ApiExchange test = new ApiExchange();
		
		//test.guardarValores();
	}
	
	@Test
	public void testdate() {
		ApiExchange test = new ApiExchange();
		
		
		System.out.println(test.getDateRecibida());
		System.out.println(test.getEUR());
		/*
		System.out.println(test.getDateRecibida());
    	DecimalFormat df = new DecimalFormat("########");
    	String date = df.format(Double.valueOf(test.getDateMañana()));
    	String date1 = df.format(test.transformarDate(test.getDateRecibida()));
    	double date00 = Double.parseDouble(date);
    	double date01 = Double.parseDouble(date1);
    	int date000 = (int) date01;
    	long date001 = Math.round(date00);
    	
    	
    	if (date000 < date001) {
			System.out.println("success");
		} else {
			System.out.println(date00 + " " + date01);
		}
    	
    	System.out.println(date000);
    	System.out.println(date001);
    	*/
	}
	
}
