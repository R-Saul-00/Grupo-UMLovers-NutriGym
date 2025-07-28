package nutrigym.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ListaGenero {
	private List<String> genero = new ArrayList<>();
	
	public ListaGenero() {
		genero.addAll(Arrays.asList("Hombre","Mujer"));
	}
	
	public ArrayList<String> getGenero() {
		return (ArrayList<String>) this.genero;
	}
	
	public boolean generoDisponible(String generoElegido) {
		for(String genero : this.genero) {
			if(genero.equals(generoElegido)) {
				return true;
			}
		}
		return false;
	}
	
	public void mostrarGeneros() {
		for(String genero : this.genero) {
            System.out.println(genero);
        }
	}
}
