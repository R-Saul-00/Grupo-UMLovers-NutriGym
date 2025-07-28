package nutrigym.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlimentosPorPais {
	//PA = Pais Alimentos
	private List<List<String>> listaPA = new ArrayList<>();
	
	public AlimentosPorPais() {
		llenarListas();
	}
	
	public void llenarListas() {
		List<String> listBolivia = new ArrayList<>();
		listBolivia.addAll(Arrays.asList("Bolivia","Pechuga de pollo","Atun en agua","Huevo",
				"Lomo de vaca","Pechuga de pavo","Yogur griego","Queso","Avena (seca)","Platano","Manzana"));
		listaPA.add(listBolivia);
		List<String> listArgentina = new ArrayList<>();
		listArgentina.addAll(Arrays.asList("Argentina","Pechuga de pavo","Pechuga de pollo","Atun en agua","Huevo",
				"Lomo de vaca","Pechuga de pavo","Yogur griego","Queso","Pan integral","Nueces (secas)","Bayas (Arandanos, Fresas)"));
		List<String> listCuba = new ArrayList<>();
		listCuba.addAll(Arrays.asList("Cuba","Pechuga de pollo","Atun en agua","Huevo",
				"Lomo de vaca","Pechuga de pavo","Yogur griego","Yogur griego","Queso","Pan integral","Nueces (secas)",
				"Bayas (Arandanos, Fresas)","Platano","Manzana"));
	}
	
	public List<String> estePais(String buscarPais) {
		for(List<String> listaPais : this.listaPA) {
			if(!listaPais.isEmpty()) {
				String estePais = listaPais.get(0);
				if(estePais.equals(buscarPais)) {
					return listaPais;
				}
			}
		}
		return null;
	}
}