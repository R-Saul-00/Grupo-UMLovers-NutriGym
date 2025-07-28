package nutrigym.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SimularCrearDieta {
	private static double tBM;
	private static int gET;
	private static int  proteinas;
	private static int  grasas;
	private static int  carbohidratos;
    private static ListaAlimentos listaAlimentos = new ListaAlimentos();
    private static ArrayList<Alimento> listaDieta = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("---BIENVENIDO A NUTRIGYM---");
		
		//Para evitar el error "Resource leak: 'entrada' is never closed"
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> alimentosDisp = new ArrayList<>();
        
        SimulaBDUsuarios bdUsuarios = new SimulaBDUsuarios();
        AlimentosPorPais alimentosPorPais = new AlimentosPorPais();
        //El nombre del usuario ya debe estar registrado en la base de datos (SimulaBDUsuarios)
        Usuario usuario = bdUsuarios.buscarUsuarioPorNombreCorreo("tomi_m");
        String pais = usuario.getRegion();
        String genero = usuario.getSexo();
        int edad = usuario.calcularEdadAFecha("27/07/2025");
        int peso =((int)usuario.getPeso());
        int altura = 100 * ((int)usuario.getAltura());
        
        if(genero.equals("Hombre")) {
        	tBM = (10 * peso) + (6.25 * altura) - (5 * edad) + 5;
        }else {
        	tBM = (10 * peso) + (6.25 * altura) - (5 * edad) - 161;
        }
        gET = (int)(tBM * 1.55);
        proteinas = (int)(1.8 * peso);
        grasas = (int)(0.8 * peso);
        carbohidratos = (int)((gET - (proteinas * 4) - (grasas * 9))/4);
        
        System.out.println("\n---REQUERIMIENTO NUTRICIONAL RECOMENDADO---");
        System.out.println("Calorías diarias totales: " + gET + " kcal");
        System.out.println("Proteínas: " + proteinas + " gramos");
        System.out.println("Grasas: " + grasas + " gramos");
        System.out.println("Carbohidratos: " + carbohidratos + " gramos");
        
        System.out.println("\n---Gestionar Dieta Dia Lunes---");
        alimentosDisp = (ArrayList<String>) alimentosPorPais.estePais(pais);

 String opcionMenu;
        
        do {
            System.out.println("\n--- OPCIONES DE DIETA ---");
            System.out.println("1. Ver dieta actual");
            System.out.println("2. Agregar alimento a dieta");
            System.out.println("3. Eliminar alimento de dieta");
            System.out.println("'salir'. Salir de la gestion de dieta");
            System.out.print("Ingrese una opcion: ");
            opcionMenu = entrada.nextLine();

            switch (opcionMenu.toLowerCase()) {
                case "1":
                    mostrarDieta();
                    valorNTotal();
                    break;
                case "2":
                	System.out.println("Alimentos disponibles en tu país:");
                	mostrarAlimentos(alimentosDisp);
                    System.out.print("Ingrese el nombre del alimento a agregar: ");
                    String agregarAlimento = entrada.nextLine();
                    agregarAlimentoDieta(agregarAlimento);
                    valorNTotal();
                    break;
                case "3":
                	mostrarDieta();
                    System.out.print("Ingrese el nombre del alimento a eliminar: ");
                    String alimentoEliminar = entrada.nextLine();
                    eliminarAlimentoDieta(alimentoEliminar);
                    valorNTotal();
                    break;
                case "salir":
                    System.out.println("Saliendo de la gestion de dieta.");
                    break;
                default:
                    System.err.println("Opcion no valida. Por favor, intente de nuevo.");
            }
        } while(!opcionMenu.equalsIgnoreCase("salir"));
	}
	
	public static void agregarAlimentoDieta(String nuevoAlimento) {
		if(listaAlimentos.estaAlimento(nuevoAlimento)) {
			Alimento nuevo = listaAlimentos.obtenerAlimentoLista(nuevoAlimento);
			listaDieta.add(nuevo);
		}else {
			System.err.println("El alimento " + nuevoAlimento + " no esta disponible en tu region o esta mal escrito");
		}
	}
	
	public static void eliminarAlimentoDieta(String eliminarAlimento) {
        if (listaDieta.isEmpty()) {
            System.out.println("Dieta vacia");
            return;
        }
        boolean seElimino = false;
        Iterator<Alimento> iterador = listaDieta.iterator();
        while (iterador.hasNext()) {
            Alimento esteAlimento = iterador.next();
            if (esteAlimento.getNombre().equalsIgnoreCase(eliminarAlimento)) {
                iterador.remove();
                seElimino = true;
            }
        }

        if (seElimino) {
            System.out.println("\nEl alimento '" + eliminarAlimento + "' fue borrado de la dieta.");
        } else {
            System.err.println("\nNo se encontro el alimento '" + eliminarAlimento + "' en la dieta.");
        }
    }
	
	public static void mostrarDieta() {
		if(!listaDieta.isEmpty()) {
			System.out.println("\nNombre:     Cantidad | Calorias | Carbohidratos | Proteínas | Grasas |");
			for(Alimento esteAlimento : listaDieta) {
				System.out.printf("%-18s", esteAlimento.getNombre() + ": ");
				System.out.print(esteAlimento.getCantidad() + "g | ");
				System.out.print(esteAlimento.getKcal() + "kcal |  ");
				System.out.print(esteAlimento.getCarbohidratos() + "g | ");
				System.out.print(esteAlimento.getProteinas() + "g | ");
				System.out.print(esteAlimento.getGrasas() + "g | ");
				System.out.println("");
			}
		}else {
			System.out.println("Dieta vacia");
		}
	}
	
	public static void valorNTotal() {
		float kcalTotal = 0.00f;
		float carbTotal = 0.00f;
		float protTotal = 0.00f;
		float grasaTotal = 0.00f;
		if(!listaDieta.isEmpty()) {
			for(Alimento esteAlimento : listaDieta) {
				kcalTotal += esteAlimento.getKcal();
				carbTotal += esteAlimento.getCarbohidratos();
				protTotal += esteAlimento.getProteinas();
				grasaTotal += esteAlimento.getGrasas();
			}
		}
		System.out.println("\nCalorias totales: " + kcalTotal + " Carbohidratos totales: " + carbTotal);
		System.out.println("Proteínas totales: " + protTotal + " Grasas totales: " + grasaTotal);
	}
	
	public static void mostrarAlimentos(ArrayList<String> alimentosDisp) {
		System.out.println("\nNombre:     Cantidad | Calorias | Carbohidratos | Proteínas | Grasas |");
		for(String esteAlimento : alimentosDisp) {
			Alimento datosAlimento = listaAlimentos.obtenerAlimentoLista(esteAlimento);
			if(!(datosAlimento == null)) {
				System.out.printf("%-18s", datosAlimento.getNombre() + ": ");
				System.out.print(datosAlimento.getCantidad() + "g | ");
				System.out.print(datosAlimento.getKcal() + "kcal |  ");
				System.out.print(datosAlimento.getCarbohidratos() + "g | ");
				System.out.print(datosAlimento.getProteinas() + "g | ");
				System.out.print(datosAlimento.getGrasas() + "g | ");
				System.out.println();
			}
		}
	}
}
