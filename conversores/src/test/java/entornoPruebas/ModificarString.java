package entornoPruebas;

import org.junit.Test;

public class ModificarString {
	@Test
	public void metodosPrueba(){
		
		   String source = "hola munDO";
		    StringBuffer res = new StringBuffer();
		    char[] stringArray = null;
		    String[] strArr = source.toLowerCase().split(" ");
		    
		    for (String str : strArr) {
		        stringArray = str.trim().toCharArray();
		        stringArray[0] = Character.toUpperCase(stringArray[0]);
		        str = new String(stringArray);

		        res.append(str).append(" ");
		    }

		    System.out.println("Resultado: " + res.toString().trim());
		    System.out.println(stringArray[0]);
		    System.out.println(res);
		    System.out.println(strArr[1]);
		
	}
}
