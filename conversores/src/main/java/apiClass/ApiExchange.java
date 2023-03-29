package apiClass;

import java.util.Calendar;

import almacenTemporal.Almacenar;

public class ApiExchange extends InvocadorApi{
	
	Almacenar almacen = new Almacenar();
	
	private double USD =  almacen.abrirDoubleAlmacen("USD");
	private double EUR =  almacen.abrirDoubleAlmacen("EUR");
	private double GBP =  almacen.abrirDoubleAlmacen("GBP");
	private double JPY =  almacen.abrirDoubleAlmacen("JPY");
	private double KRW =  almacen.abrirDoubleAlmacen("KRW");
	private String dateRecibida = almacen.abrirStringAlmacen("dateRecibida");
	private long fechaApiMañana = simpleNum(transformarDate(dateRecibida) + 1) ;
	
	public ApiExchange (){
		long fechaHoy = simpleNum(obtenerFechaHoy());
		//long fechaApi = simpleNum(transformarDate(dateRecibida));
		
		if ( fechaApiMañana <= fechaHoy) {
			System.out.println("han sido actualizados los valores");
			guardarValores();
		}else {
			System.out.println("No es necesario actualizar los valores");
		}
		
	}
	
	private Double transformarDate(String u) {
		String[] str = u.split("-");
		String ultima = new String(str[0] + str[1] + str[2]);
		return Double.valueOf(ultima);
	}
	
	private Double obtenerFechaHoy() {
		Calendar c = Calendar.getInstance();
		int mesNuevo = c.get(Calendar.MONTH) + 1;
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(mesNuevo);
		String annio = Integer.toString(c.get(Calendar.YEAR));
		StringBuffer rea = new StringBuffer();
		rea.append(annio).append("0");
		rea.append(mes).append(dia);
		double cuer = Double.valueOf(rea.substring(0, 8));
		return cuer;
	}
	
	private long simpleNum(double n) {
		long number = Math.round(n);
		return number;
	}
	
	public void guardarValores() {
		
		super.iniciarConexion();
		
		almacen.setDoublePreferences("USD", super.getJson().getJSONObject("rates").getDouble("USD"));
		almacen.setDoublePreferences("EUR", super.getJson().getJSONObject("rates").getDouble("EUR"));
		almacen.setDoublePreferences("GBP", super.getJson().getJSONObject("rates").getDouble("GBP"));
		almacen.setDoublePreferences("JPY", super.getJson().getJSONObject("rates").getDouble("JPY"));
		almacen.setDoublePreferences("KRW", super.getJson().getJSONObject("rates").getDouble("KRW"));
		almacen.setStringPreferences("dateRecibida", super.getJson().getString("date"));
	}
	
	public double getUSD() {
		return USD;
	}

	public double getEUR() {
		return EUR;
	}

	public double getGBP() {
		return GBP;
	}

	public double getJPY() {
		return JPY;
	}

	public double getKRW() {
		return KRW;
	}

	public String getDateRecibida() {
		return dateRecibida;
	}
	
}

