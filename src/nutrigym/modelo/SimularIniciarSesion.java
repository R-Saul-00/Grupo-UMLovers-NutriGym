package nutrigym.modelo;

import java.util.Scanner;

public class SimularIniciarSesion {
    private final static String FechaActual = "26/07/2025";
    private static String usuarioCorreoIngresado;
    private static Usuario usuarioEncontrado;

    public static void main(String[] args) {
        System.out.println("---BIENVENIDO A NUTRIGYM---"); 
        
        Scanner entrada = new Scanner(System.in); 
        SimulaBDUsuarios bdUsuarios = new SimulaBDUsuarios();  
        
        System.out.println("---OPCION INICIAR SESION---");
        boolean usuarioEncontradoValido = false;
        usuarioCorreoIngresado = "";
        
        while(!usuarioEncontradoValido) {
            System.out.print("Ingrese su nombre de usuario/correo electronico o 'salir' para finalizar: ");
            usuarioCorreoIngresado = entrada.nextLine();

            if(usuarioCorreoIngresado.equalsIgnoreCase("salir")) {
                System.err.println("Saliendo del inicio de sesión...");
                break;
            }
            
            if(bdUsuarios.existeCuentaPorNombreCorreo(usuarioCorreoIngresado)) {
                usuarioEncontradoValido = true;
            }else {
                System.err.println("Usuario no registrado. Por favor, verifique su nombre de usuario o escriba 'salir'.");
            }
        }
        
        if(usuarioEncontradoValido) {
            usuarioEncontrado = bdUsuarios.buscarUsuarioPorNombreCorreo(usuarioCorreoIngresado);
            
            boolean contraseniaCorrecta = false;
            while(!contraseniaCorrecta) {
                System.out.print("Usuario encontrado. Por favor, introduzca su contraseña: ");
                String contraseniaIngresada = entrada.nextLine();
                
                if(usuarioEncontrado.getContrasenia().equals(contraseniaIngresada)) {
                    System.out.println("\n¡Inicio de sesión exitoso, " + usuarioEncontrado.getNombrePublico() + "!");
                    contraseniaCorrecta = true;
                    
                    System.out.println("\n---TUS DATOS DE PERFIL---");
                    System.out.println("Correo electronico: " + usuarioEncontrado.getCorreoElectronico());
                    System.out.println("Usuario: " + usuarioEncontrado.getUsuario());
                    System.out.println("Nombre público: " + usuarioEncontrado.getNombrePublico());
                    
                    int edad = usuarioEncontrado.calcularEdadAFecha(FechaActual);
                    System.out.println("Edad: " + edad + " años");
                    
                    System.out.println("Peso: " + usuarioEncontrado.getPeso() + " kg");
                    System.out.println("Altura: " + usuarioEncontrado.getAltura() + " m");
                    System.out.println("Sexo: " + usuarioEncontrado.getSexo());
                    System.out.println("Región: " + usuarioEncontrado.getRegion());
                }else {
                    System.err.println("Contraseña incorrecta. Inténtelo de nuevo.");
                }
            }
        }
        entrada.close();
        System.out.println("\n---SESIÓN FINALIZADA---");
    }
}