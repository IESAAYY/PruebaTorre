package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre atributoTorre;
	
	private static void mostrarTorre () {
		System.out.println(atributoTorre);
			
	}
	
	private static void mostrarMenu () {
		System.out.println("\n--------------------------------------------------------------");
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
		int opcion;
		
		System.out.print("\nIntroduce la opción a realizar (0-6): ");
		opcion=Entrada.entero();
		
		if (opcion==0) {
			System.out.print("Introduzca 0 de nuevo para finalizar el programa, cualquier otro número para mostrar el menú: ");
			opcion=Entrada.entero();
		}
		if (opcion==0) {
			System.out.println("\n--------------------------------El programa finalizó con éxito.--------------------------------");
			System.exit(0);
		} else {
			mostrarMenu();
			elegirOpcion();
		}
		while (opcion<0 || opcion >6) {
			System.out.print("Porfavor, vuelva a introducir la opción y deje de jugar conmigo: ");
			opcion=Entrada.entero();
			
		}
		return opcion;
	}
	
	private static Color  elegirColor() {
		char color;
		
		System.out.print("Es momento de elegir el color, introduce \"B\" para seleccionar blanco y \"N\" para seleccionar negro: ");
		color=Entrada.caracter();
		
		while (color != 'B' && color != 'b' && color != 'N' && color != 'n') {
			System.out.print("Porfavor, vuelva a introducir el color y deje de jugar conmigo: ");
			color=Entrada.caracter();
		}
		
		if (color=='B' || color=='b') {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
	}
	
	private static char elegirColumnaInicial() {
		char columnaInicial;
		
		System.out.print("Ahora debes de elegir una columna inicial para tu torre, introduce a ó h ");
		columnaInicial=Entrada.caracter();
		
		while (columnaInicial!= 'A' && columnaInicial!='a' && columnaInicial!= 'H' && columnaInicial!='h' ) {
			System.out.print("Porfavor, vuelva a introducir la columna inicial y deje de jugar conmigo: ");
			columnaInicial=Entrada.caracter();
		}
		
		return columnaInicial;
	}	
	
	
	
	
	
	
	
	
	
	
}
