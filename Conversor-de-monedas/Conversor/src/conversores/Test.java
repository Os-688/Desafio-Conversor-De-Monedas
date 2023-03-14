package conversores;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		 String urlApi = "https://api.apilayer.com/fixer/latest?base=COP&symbols=USD,EUR,GBP,JPY,KRW";		
		try {
			
			URL url = new URL(urlApi);
			
			HttpURLConnection urlConexion = (HttpURLConnection) url.openConnection();
			
			urlConexion.setRequestProperty("apikey", "rl5nCfpm6dB4CeSpJggv420pKdAcwvQo");
			
			urlConexion.setRequestMethod("GET");
			
			urlConexion.connect();
			
			
			int responseCode = urlConexion.getResponseCode();
			
			if (responseCode != 200) {
				
				throw new RuntimeException("Ha ocurrido un error:" + responseCode);
				
			} else {
				
				StringBuilder almacenDatos = new StringBuilder();
				
				Scanner flujoDatos = new Scanner(urlConexion.getInputStream());
				
				while (flujoDatos.hasNext()) {
					
					almacenDatos.append(flujoDatos.nextLine());
					
				}
				
				flujoDatos.close();
				
				JSONObject jsonObject = new JSONObject(almacenDatos.toString());
				
				double dolar = jsonObject.getJSONObject("rates").getDouble("USD"),
						euro = jsonObject.getJSONObject("rates").getDouble("EUR"),
                        libraEsterlina = jsonObject.getJSONObject("rates").getDouble("GBP"),
                        yen = jsonObject.getJSONObject("rates").getDouble("JPY"),
                        won = jsonObject.getJSONObject("rates").getDouble("KRW");

                System.out.println("Dolar: " + dolar + "\n"
                        + "Euro: " + euro + "\n"
                        + "Libra Esterlina: " + libraEsterlina + "\n"
                        + "Yen Japones: " + yen + "\n"
                        + "Won Coreano: " + won);
                System.out.println(jsonObject);
			} 
		}catch (IOException | RuntimeException e) {
			System.out.println();
		}
	}
}
