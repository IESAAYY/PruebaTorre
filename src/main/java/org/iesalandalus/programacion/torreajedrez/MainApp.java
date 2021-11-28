package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre atributoTorre;
	
	private static void mostrarTorre () {
		System.out.println(atributoTorre);
		
		
	}
	
	private static void mostrarMenu () {
		System.out.println("Programa para controlar el movimiento de una torre en Ajedrez.");
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("1.- Crear una torre negra en h1");
		System.out.println("2.- Crear una torre en columna h seleccionando el color ");
		System.out.println("4.- Crear una torre seleccionando el color y la columna.");
		System.out.println("5.- Mover la torre creada.");
		System.out.println("6.- Mostrar la Torre.\n");
		System.out.println("0.- Salir del programa.");
	}
	
	private static int elegirOpcion() {
		int opcion=Entrada.entero();
		
		System.out.print("Introduce la opción a realizar (0-6): ");
		opcion=Entrada.entero();
		while (opcion<1 || opcion >6) {
			opcion=Entrada.entero();
			System.out.println("Porfavor, vuelva a introducir la opción y deje de jugar conmigo");
	
		}
	
		return opcion;
	}
}
