package almacenTemporal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Almacenar {

		private final Preferences preferences = Preferences.userNodeForPackage(this.getClass());
		
		private List<String> ClaveBoolean = new ArrayList<>();
		private List<String> ClaveString = new ArrayList<>();
		private List<String> ClaveDouble = new ArrayList<>();
		
		public Preferences getPreferences() {
			return preferences;
		}
		//La clave tiene que ser descriptiva. Para saber el valor al que esta conectado.
		
		public void setBooleanPreferences(String clave, boolean s) {
			preferences.putBoolean(clave, s);
			ClaveBoolean.add(clave);
		}
		
		public void setDoublePreferences(String clave,  double s) {
			preferences.putDouble(clave, s);
			ClaveDouble.add(clave);
		}
		
		public void setStringPreferences(String clave, String s) {
			preferences.put(clave, s);
			ClaveString.add(clave);
		}
		
		public void getBooleanPreferences() {
			ClaveBoolean.forEach(t -> {
				System.out.println(t);
			});
			
		}
		
		public void getDoublePreferences() {
			ClaveDouble.forEach(t -> {
				System.out.println(t);
			});
		}
		
		public void getStringPreferences() {
			ClaveString.forEach(t -> {
				System.out.println(t);
			});
		}
		
		public boolean abrirBooleanAlmacen(String clave) {
			return preferences.getBoolean(clave, true);
		}
		
		public double abrirDoubleAlmacen(String clave) {
			return preferences.getDouble(clave, 0.0000);
		}
		
		public String abrirStringAlmacen(String clave) {
			return preferences.get(clave, "Fallo por completo");
		}
		
		public void removerAlmacen(String clave) {
			preferences.remove(clave);
		}
		
		public void removerAlmacenes() {
			try {
				preferences.clear();
			} catch (BackingStoreException e) { 
				System.out.println("Han robado los almacenes, antes de vaciarlos..." + "Error: No hay nada guardado.");
			}

		}

}
