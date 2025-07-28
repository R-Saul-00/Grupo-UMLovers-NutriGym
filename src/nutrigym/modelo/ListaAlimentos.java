package nutrigym.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaAlimentos {
	private List<Alimento> alimentos = new ArrayList<>();
	
	public ListaAlimentos() {
		llenarAlimentos();
	}
	
	private void llenarAlimentos() {
		Alimento alimento1 = new Alimento(
				"Pechuga de pollo",100,
				165,0.0f,31.0f,3.6f);
		this.alimentos.add(alimento1);
		Alimento alimento2 = new Alimento(
				"Pescado blanco",100,
				85,0.0f,18.0f,2.0f);
		this.alimentos.add(alimento2);
		Alimento alimento3 = new Alimento(
				"Atun en agua",100,
				110,0.0f,25.0f,1.0f);
		this.alimentos.add(alimento3);
		Alimento alimento4 = new Alimento(
				"Huevo",100,
				52,0.7f,11.0f,0.2f);
		this.alimentos.add(alimento4);
		Alimento alimento5 = new Alimento(
				"Lomo de vaca",100,
				70,0.0f,27.0f,7.0f);
		this.alimentos.add(alimento5);
		Alimento alimento6 = new Alimento(
				"Pechuga de pavo",100,
				140,0.0f,29.0f,2.0f);
		this.alimentos.add(alimento6);
		Alimento alimento7 = new Alimento(
				"Yogur griego",100,
				59,3.6f,10.0f,0.4f);
		this.alimentos.add(alimento7);
		Alimento alimento8 = new Alimento(
				"Queso",100,
				72,3.0f,12.0f,1.5f);
		this.alimentos.add(alimento8);
		Alimento alimento9 = new Alimento(
				"Avena (seca)",100,
				380,66.0f,17.0f,7.0f);
		this.alimentos.add(alimento9);
		Alimento alimento10 = new Alimento(
				"Arroz Integral",100,
				111,23.0f,2.6f,0.9f);
		this.alimentos.add(alimento10);
		Alimento alimento11 = new Alimento(
				"Patata (cocida, con piel)",100,
				87,20.0f,2.0f,0.1f);
		this.alimentos.add(alimento11);
		Alimento alimento12 = new Alimento(
				"Batata (camote) (cocida)",100,
				76,18.0f,1.6f,0.1f);
		this.alimentos.add(alimento12);
		Alimento alimento13 = new Alimento(
				"Quinoa (cocida)",100,
				120,21.0f,4.4f,1.9f);
		this.alimentos.add(alimento13);
		Alimento alimento14 = new Alimento(
				"Pan integral",100, 
				75,13.5f,3.5f,1.5f);
		this.alimentos.add(alimento14);
		Alimento alimento15 = new Alimento(
				"Aguacate",100,
				160,8.5f,2.0f,15.0f);
		this.alimentos.add(alimento15);
		Alimento alimento16 = new Alimento(
				"Aceite de Oliva Extra Virgen",100,
				884,0.0f,0.0f,100.0f);
		this.alimentos.add(alimento16);
		Alimento alimento17 = new Alimento(
				"Nueces (secas)",100,
				654,14.0f,15.0f,65.0f);
		this.alimentos.add(alimento17);
		Alimento alimento18 = new Alimento(
				"Almendras (secas)",100,
				579,22.0f,21.0f,49.0f);
		this.alimentos.add(alimento18);
		Alimento alimento19 = new Alimento(
				"Semillas de Chía",100,
				486,42.0f,17.0f,31.0f);
		this.alimentos.add(alimento19);
		Alimento alimento20 = new Alimento(
				"Pescado Azul (Salmon, Sardinas)",100,
				225,0.0f,21.0f,12.5f);
		this.alimentos.add(alimento20);
		Alimento alimento21 = new Alimento(
				"Brocoli",100,
				34,7.0f,2.8f,0.4f);
		this.alimentos.add(alimento21);
		Alimento alimento22 = new Alimento(
				"Espinacas",100,
				23,3.6f,2.9f,0.4f);
		this.alimentos.add(alimento22);
		Alimento alimento23 = new Alimento(
				"Bayas (Arandanos, Fresas)",100,
				41,10.0f,0.8f,0.4f);
		this.alimentos.add(alimento23);
		Alimento alimento24 = new Alimento(
				"Platano",100,
				89,23.0f,1.1f,0.3f);
		this.alimentos.add(alimento24);
		Alimento alimento25 = new Alimento(
				"Manzana",100,
				52,14.0f,0.3f,0.2f);
		this.alimentos.add(alimento25);	
	}
	
	public Alimento obtenerAlimentoLista(String alimentoBuscado) {
		for(Alimento alimento : this.alimentos) {
			if(alimento.getNombre().equals(alimentoBuscado)) {
				return alimento;
			}
		}
		return null;
	}
	
	public boolean estaAlimento(String alimentoBuscado) {
		for(Alimento alimento : this.alimentos) {
			if(alimento.getNombre().equals(alimentoBuscado)) {
				return true;
			}
		}
		return false;
	}
}
