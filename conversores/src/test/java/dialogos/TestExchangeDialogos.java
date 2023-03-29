package dialogos;

import javax.swing.JOptionPane;

import org.junit.Test;

public class TestExchangeDialogos {
	@Test
	public void testFase1() {
		ExchangeDialogos test = new ExchangeDialogos();
		
		System.out.println(test.ventanaFase1());
		
		
	}
	@Test
	public void testFase5() {
		ExchangeDialogos test = new ExchangeDialogos();
		
		test.ventanaFase5();
	}
	@Test
	public void testRetornoDialog() {
		double rt = JOptionPane.showConfirmDialog(null, "Quieres realizar otra conversion?");
		if (rt == 0) {
			System.out.println("ssadadsad " + rt);
		}
		System.out.println(rt);
		
	}
	@Test
	public void testCiclarVentana() {
		ExchangeDialogos test = new ExchangeDialogos();
		test.ciclarVentana();
	}
}
