package org.iesalandalus.programacion.torreajedrez;

public class MainApp {

	private static Torre atributoTorre;
	
	public static void main(String[] args) {
		mostrarMenu();
	}

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
}
