package nutrigym.modelo;

public class Usuario {
	private String correoElectronico;
	private String usuario;
	private String contrasenia;
	
	private String nombrePublico;
	private String fechaNacimiento;
	private float peso;
	private float altura;
	private String sexo;
	private String region;
	
	public Usuario (String correoElectronico,String usuario,String contrasenia,String nombrePublico,
			String fechaNacimiento,float peso,float altura,String sexo,String region) {
		this.correoElectronico = correoElectronico;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombrePublico = nombrePublico;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.altura = altura;
		this.sexo = sexo;
		this.region = region;
	}
	
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public String getUsuario() {
		return this.usuario;
	}
	
	public String getContrasenia() {
		return this.contrasenia;
	}
	
	public String getNombrePublico() {
		return this.nombrePublico;
	}
	
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public float getPeso() {
		return this.peso;
	}
	
	public float getAltura() {
		return this.altura;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public String getRegion() {
		return this.region;
	}
	
    public int calcularEdadAFecha(String fechaActual) {
    	int diaNacimiento = Integer.parseInt(this.fechaNacimiento.substring(0, 2));
        int mesNacimiento = Integer.parseInt(this.fechaNacimiento.substring(3, 5));
        int anioNacimiento = Integer.parseInt(this.fechaNacimiento.substring(6, 10));
        
        int diaActual = Integer.parseInt(fechaActual.substring(0, 2));
        int mesActual = Integer.parseInt(fechaActual.substring(3, 5));
        int anioActual = Integer.parseInt(fechaActual.substring(6, 10));
        
        int edad = anioActual - anioNacimiento;
        
        if(mesActual < mesNacimiento) {
            edad--;
        }else {
        	if (mesActual == mesNacimiento) {
        		if (diaActual < diaNacimiento) {
                    edad--;
        		}
        	}
        }
        return edad;
    }
    
    public void setCorreoElectronico(String nuevoCorreoElec) {
    	this.correoElectronico = nuevoCorreoElec;
    }
	
	public void setUsuario(String nuevoUsuario) {
		this.usuario = nuevoUsuario;
	}
	
	public void setContrasenia(String nuevaContrasenia) {
		this.contrasenia = nuevaContrasenia;
	}
	
	public void setNombrePublico(String nuevoNombrePublico) {
		this.nombrePublico = nuevoNombrePublico;
	}
	
	public void setFechaNacimiento(String nuevaFechaNacimiento) {
		this.fechaNacimiento = nuevaFechaNacimiento;
	}
	
	public void setPeso(float nuevoPeso) {
		this.peso = nuevoPeso;
	}
	
	public void setAltura(float nuevaAltura) {
		this.altura = nuevaAltura;
	}
	
	public void setSexo(String nuevoSexo) {
		this.sexo = nuevoSexo;
	}
	
	public void setRegion(String nuevaRegion) {
		this.region = nuevaRegion;
	}
}