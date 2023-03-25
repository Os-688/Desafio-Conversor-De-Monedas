package apiClass;

public class ApiExchange extends InvocadorApi{

	private double USD;
	private double EUR;
	private double GBP;
	private double JPY;
	private double KRW;

	public ApiExchange() {

		//No es relevante llamar al constructor, al nombrar el método de la clase que hereda lo realiza.
		super.iniciarConexion();
		
		USD = super.getJson().getJSONObject("rates").getDouble("USD");
		EUR = super.getJson().getJSONObject("rates").getDouble("EUR");
		GBP = super.getJson().getJSONObject("rates").getDouble("GBP");
		JPY = super.getJson().getJSONObject("rates").getDouble("JPY");
		KRW = super.getJson().getJSONObject("rates").getDouble("KRW");

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
}

