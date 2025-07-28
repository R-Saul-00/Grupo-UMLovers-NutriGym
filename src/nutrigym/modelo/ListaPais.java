package nutrigym.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ListaPais {
private List<String> paises = new ArrayList<>();
	
	public ListaPais() {
		paises.addAll(Arrays.asList("Argentina","Bolivia","Chile","Cuba","Colombia","Costa Rica",
				"Ecuador","El Salvador","Guatemala","Haití","Honduras","México","Nicaragua","Panamá",
				"Paraguay","Peru","República Dominicana","Uruguay","Venezuela"));
	}
	
	public ArrayList<String> getPais() {
		return (ArrayList<String>) this.paises;
	}
	
	public boolean paisDisponible(String nombrePais) {
		for(String pais : this.paises) {
			if(pais.equals(nombrePais)) {
				return true;
			}
		}
		return false;
	}
	
	public void mostrarPaises() {
		for(String pais : this.paises) {
            System.out.println(pais);
        }
	}
}
