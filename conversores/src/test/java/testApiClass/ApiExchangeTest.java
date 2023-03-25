package testApiClass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import apiClass.ApiExchange;


public class ApiExchangeTest {
	/**
     * Rigorous Test :-)
     */
	/*
	public static void main(String[] args) {
		ApiExchange test = new ApiExchange();
		
		double result = test.getUSD();
		System.out.println(result);
	}
	*/  
	@Test
    public void testGetUsd() {
    	ApiExchange test = new ApiExchange();
    	
    	double result = test.getUSD();
    	
    	assertEquals("La funcion no da el valor esperado", 0.053798, result, 0.05);
    	System.out.println(result);
    
    } 
	//Prueba terminada
}
