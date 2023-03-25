package apiClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class InvocadorApi {

	 private final String key = "NLcHZDPMxLTzSGvi1i1wxttGwNRiWkKu";

	 private Scanner flujoDatos = null;

	 private StringBuilder almacenDatos = new StringBuilder();

	 private JSONObject jsonObject;

	 private URL url = null;

	 public InvocadorApi() {
		 try {

			 url = new URL("https://api.apilayer.com/exchangerates_data/latest?symbols=EUR%2CGBP%2CJPY%2CKRW%2CUSD&base=MXN");

		} catch (MalformedURLException e) {
			System.out.println("Error con url: Conexion falida");
		}
	 }

	 public void iniciarConexion() {
		 try {

			HttpURLConnection urlConexion = (HttpURLConnection) url.openConnection();

			urlConexion.setRequestProperty("apiKey", key);

			urlConexion.setRequestMethod("GET");

			urlConexion.connect();

			int responseCode = urlConexion.getResponseCode();

			if (responseCode != 200) {

				throw new RuntimeException("Ha ocurrido un error: " + responseCode);
			} else {

				flujoDatos = new Scanner(urlConexion.getInputStream());

				while (flujoDatos.hasNext()) {
					almacenDatos.append(flujoDatos.nextLine());
				}

				flujoDatos.close();

				jsonObject = new JSONObject(almacenDatos.toString());
			}

		} catch (IOException | RuntimeException e) {
			System.out.println("No se logro conectar: error response code 200");
		}
	 }

	 public URL getUrl() {
		 return url;
	 }

	 public JSONObject getJson() {
		 return jsonObject;
	 }

	 public URL setUrl (String u) {
		 try {

			 url = new URL(u);

		} catch (MalformedURLException e) {
			System.out.println("Fallo la creacion de la URL");
		}
		return url;
	 }
}
