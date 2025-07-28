package nutrigym.modelo;

public class Alimento {
	private String nombre;
	private int cantidad;
	private int kcal;
	private float carbohidratos;
	private float proteinas;
	private float grasas;
	
	public Alimento(String nombre,int cantidad,int kcal,float carbohidratos,float proteinas,float grasas) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.kcal = kcal;
		this.carbohidratos = carbohidratos;
		this.proteinas = proteinas;
		this.grasas = grasas;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	public void setCarbohidratos(float carbohidratos) {
		this.carbohidratos = carbohidratos;
	}
	
	public void setProteinas(float proteinas) {
		this.proteinas = proteinas;
	}
	
	public void setGrasas(float grasas) {
		this.grasas = grasas;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public int getKcal() {
		return this.kcal;
	}
	
	public float getCarbohidratos() {
		return this.carbohidratos;
	}
	
	public float getProteinas() {
		return this.proteinas;
	}
	
	public float getGrasas() {
		return this.grasas;
	}
}
