package nutrigym.modelo;

import java.util.Scanner;

public class SimularRegistrarUsuario {
    private final static String FechaActual = "26/07/2025";

    public static void main(String[] args) {
        System.out.println("---BIENVENIDO AL REGISTRO DE NUTRIGYM---");
        
        //Para evitar el error "Resource leak: 'entrada' is never closed"
        @SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
        
        SimulaBDUsuarios bdUsuarios = new SimulaBDUsuarios();
        ListaGenero listaGenero = new ListaGenero(); 
        ListaPais listaPais = new ListaPais();
        
        System.out.println("---OPCION CREAR CUENTA---");
        System.out.println("\n---INGRESE SUS DATOS PARA EL REGISTRO---");
        String nuevoCorreoElectronico = "";
        boolean correoValido = false;
        while(!correoValido) {
            System.out.print("Ingrese su correo electronico o 'salir' para cancelar: ");
            nuevoCorreoElectronico = entrada.nextLine();
            
            if(nuevoCorreoElectronico.equalsIgnoreCase("salir")) {
                System.err.println("Registro cancelado. Saliendo...");
                entrada.close();
                System.out.println("\n---REGISTRO FINALIZADO---");
                return; 
            }
            if(bdUsuarios.existeCuentaPorNombreCorreo(nuevoCorreoElectronico)) {
                System.err.println("Este correo electronico ya esta registrado. Por favor, ingrese otro.");
            }else {
                correoValido = true;
            }
        }
        System.out.print("Ingrese una contraseña: ");
        String nuevaContrasenia = entrada.nextLine();
        String nuevoNombreUsuario = "";
        boolean nombreUsuarioValido = false;
        
        while(!nombreUsuarioValido) {
            System.out.print("Ingrese un nombre de usuario o 'salir' para cancelar: ");
            nuevoNombreUsuario = entrada.nextLine();
            if(nuevoNombreUsuario.equalsIgnoreCase("salir")) {
                System.err.println("Registro cancelado. Saliendo...");
                entrada.close();
                System.out.println("\n---REGISTRO FINALIZADO---");
                return;
            }
            if(bdUsuarios.existeCuentaPorNombreCorreo(nuevoNombreUsuario)) {
                System.err.println("Este nombre de usuario ya existe o es un correo ya registrado. Por favor, elija otro.");
            }else {
                nombreUsuarioValido = true;
            }
        }
        System.out.print("Ingrese su nombre publico: ");
        String nuevoNombrePublico = entrada.nextLine();
        String nuevaFechaNacimiento = "";
        boolean edadPermitida = false;
        while(!edadPermitida) {
        	System.out.println("Su edad debe ser mayor a 11 años");
        	System.out.print("Ingrese su fecha de nacimiento (DD/MM/AAAA): ");
	        nuevaFechaNacimiento = entrada.nextLine();
        	if(15 < verificarEdadFormato(nuevaFechaNacimiento)) {
		        edadPermitida = true;
        	}else {
        		System.err.println("Formato incorrecto o edad no invalido");
        	}
        }
        System.out.print("Ingrese su peso en kg (ej. 70.5): ");
        float nuevoPeso = Float.parseFloat(entrada.nextLine());
        System.out.print("Ingrese su altura en metros (ej. 1.75): ");
        float nuevaAltura = Float.parseFloat(entrada.nextLine());
        String nuevoSexo = "";
        boolean sexoValido = false;
        
        while(!sexoValido) {
            System.out.println("Ingrese su sexo: "); 
            listaGenero.mostrarGeneros();
            System.out.print("  :");
            nuevoSexo = entrada.nextLine();
            if(listaGenero.generoDisponible(nuevoSexo)) {
                sexoValido = true;
            }else {
                System.err.println("Sexo no valido. Por favor, ingrese uno de los siguientes: ");
                listaGenero.mostrarGeneros();
                System.out.print("  :");
            }
        }
        String nuevaRegion = "";
        boolean regionValida = false;
        
        while(!regionValida) {
            System.out.println("Ingrese su region/pais:");
            listaPais.mostrarPaises();
            System.out.print("  :");
            nuevaRegion = entrada.nextLine();
            if(listaPais.paisDisponible(nuevaRegion)) {
                regionValida = true;
            }else {
                System.err.println("Region/pais no valido. Por favor, ingrese uno de los siguientes:");
                listaPais.mostrarPaises();
                System.out.print("  :");
            }
        }
        Usuario nuevoUsuario = new Usuario(        
                nuevoCorreoElectronico, 
                nuevoNombreUsuario,      
                nuevaContrasenia, 
                nuevoNombrePublico,
                nuevaFechaNacimiento,
                nuevoPeso,
                nuevaAltura,
                nuevoSexo,
                nuevaRegion
                );
        System.out.println("\n---¡REGISTRO EXITOSO!---");
        System.out.println("Bienvenido/a, " + nuevoUsuario.getNombrePublico() + "!");
        System.out.println("Tus datos registrados son:");
        System.out.println("  Correo electronico: " + nuevoUsuario.getCorreoElectronico());
        System.out.println("  Usuario: " + nuevoUsuario.getUsuario());
        System.out.println("  Nombre publico: " + nuevoUsuario.getNombrePublico());
        System.out.println("  Fecha de nacimiento: " + nuevoUsuario.getFechaNacimiento());
        System.out.println("  Edad: " + nuevoUsuario.calcularEdadAFecha(FechaActual) + " años");
        System.out.println("  Peso: " + nuevoUsuario.getPeso() + " kg");
        System.out.println("  Altura: " + nuevoUsuario.getAltura() + " m");
        System.out.println("  Sexo: " + nuevoUsuario.getSexo());
        System.out.println("  Region: " + nuevoUsuario.getRegion());
    }
    

	
    public static int verificarEdadFormato(String fechaNacimiento) {
        try {
	    	int diaNacimiento = Integer.parseInt(fechaNacimiento.substring(0, 2));
	        int mesNacimiento = Integer.parseInt(fechaNacimiento.substring(3, 5));
	        int anioNacimiento = Integer.parseInt(fechaNacimiento.substring(6, 10));
	        
	        int diaActual = Integer.parseInt(FechaActual.substring(0, 2));
	        int mesActual = Integer.parseInt(FechaActual.substring(3, 5));
	        int anioActual = Integer.parseInt(FechaActual.substring(6, 10));
	        
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
        catch(Exception error) {
        	return 0;
        }
    }
}