package nutrigym.modelo;

import java.util.ArrayList;

public class SimulaBDUsuarios {
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public SimulaBDUsuarios() {
		llenarUsuariosIniciales();
	}
	
	private void llenarUsuariosIniciales() {
		Usuario usuario1 = new Usuario(
				"tomi12m@gmail.com",
				"tomi_m", "tomi123",
				"Tomas Mamani",
				"15/01/2004",
				75.5f, 1.70f,
				"Hombre", "Bolivia"
				);
		this.usuarios.add(usuario1);
		Usuario usuario2 = new Usuario(
				"jugoh12@gmail.com",
				"hugo21", "jugo777",
				"Rodrigo Hugo Chalco",
				"07/04/2005",
				74.5f, 1.73f,
				"Hombre", "Bolivia"
				);
		this.usuarios.add(usuario2);
		Usuario usuario3 = new Usuario(
				"gabi123@gmail.com",
				"gabi__", "matias1001",
				"Gabriela Villca",
				"21/11/2000",
				51.4f, 1.56f,
				"Mujer","Argentina"
				);
		this.usuarios.add(usuario3);
		Usuario usuario4 = new Usuario(
				"andy321@gmail.com",
				"andy_r", "100prins",
				"Andrea Garcia",
				"20/08/2004",
				51.4f, 1.56f,
				"Mujer","Cuba"
				);
		this.usuarios.add(usuario4);
	}
	
	public boolean existeCuentaPorNombreCorreo(String usuarioBuscado) {
        for(Usuario usuario : this.usuarios) {
            if(usuario.getUsuario().equals(usuarioBuscado)) {
                return true;
            }
            if(usuario.getCorreoElectronico().equals(usuarioBuscado)) {
                return true;
            }
        }
        return false;
    }
	
	public Usuario buscarUsuarioPorNombreCorreo(String usuarioBuscado) {
        for(Usuario usuario : this.usuarios) {
            if(usuario.getUsuario().equals(usuarioBuscado)) {
                return usuario;
            }
            if(usuario.getCorreoElectronico().equals(usuarioBuscado)) {
                return usuario;
            }
        }
        return null;
    }
}
