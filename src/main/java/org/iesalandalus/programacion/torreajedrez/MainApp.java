package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre atributoTorre;
	private static int opcionDireccion;

	public static void main(String[] args) throws OperationNotSupportedException {
		int opcion;

		do {
			mostrarMenu();
			opcion = elegirOpcion();
			ejecutarOpcion(opcion);
		} while (opcion != 0);

		System.out.print("\n-------------El programa finalizó con éxito.-------------");

	}

	private static void mostrarTorre() {

		if (atributoTorre != null) {
			System.out.println("==============================");
			System.out.println("Estado actual de la torre:");
			System.out.println(atributoTorre);
			System.out.println("==============================");
		} else {
			System.out.println("==============================");
			System.out.println("Debes crear una torre primero.");
			System.out.println("==============================");
		}

	}

	private static void mostrarMenu() {
		System.out.println("\n---------------");
		System.out.println("Menú de inicio.");
		System.out.println("---------------\n");
		System.out.println("1.- Crear una torre negra en \"h1\".");
		System.out.println("2.- Crear una torre en columna h seleccionando el color.");
		System.out.println("3.- Crear una torre seleccionando el color y la columna.");
		System.out.println("4.- Mover la torre creada.");
		System.out.println("5.- Mostrar el estado actual de la torre.\n");
		System.out.println("0.- Salir del programa.");
	}

	private static int elegirOpcion() {
		int opcion;

		System.out.print("\nIntroduce la opción a realizar (0-5): ");
		opcion = Entrada.entero();
		while (opcion < 0 || opcion > 5) {
			System.out.print("\nPorfavor, vuelva a introducir la opción y deje de jugar conmigo: ");
			opcion = Entrada.entero();
		}
		return opcion;

	}

	private static Color elegirColor() {
		char color;

		System.out.print("\nPrimer paso: introduce \"b\" para seleccionar blanco y \"n\" para seleccionar negro: ");
		color = Entrada.caracter();

		while (color != 'B' && color != 'b' && color != 'N' && color != 'n') {
			System.out.print("\nPorfavor, vuelva a introducir el color y deje de jugar conmigo(\"b\" ó \"n\"): ");
			color = Entrada.caracter();
		}

		if (color == 'B' || color == 'b') {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
	}

	private static char elegirColumnaInicial() {
		char columnaInicial;

		System.out.print("\nSegundo paso: introduce una columna inicial para tu torre, introduce \"a\" ó \"h\": ");
		columnaInicial = Entrada.caracter();

		while (columnaInicial != 'A' && columnaInicial != 'a' && columnaInicial != 'H' && columnaInicial != 'h') {
			System.out.print(
					"\nPorfavor, vuelva a introducir la columna inicial y deje de jugar conmigo (\"a\" ó \"h\"): ");
			columnaInicial = Entrada.caracter();
		}

		return columnaInicial;
	}

	private static void mostrarMenuDirecciones() {
		System.out.println("\n-----------------------------------------------");
		System.out.println("¿Qué movimiento deseas realizar con tu torre?");
		System.out.println("-----------------------------------------------");
		System.out.println("1.- Enroque largo");
		System.out.println("2.- Enroque corto");
		System.out.println("3.- Arriba");
		System.out.println("4.- Izquierda");
		System.out.println("5.- Derecha");
		System.out.println("6.- Abajo");

	}

	private static int elegirDireccion() {

		if (atributoTorre != null) {
			System.out.print("Elige una dirección para mover tu torre(1-6): ");
			opcionDireccion = Entrada.entero();

			while (opcionDireccion < 1 || opcionDireccion > 6) {
				System.out.print("\nPorfavor, vuelva a introducir la opción y deje de jugar conmigo(1-6): ");
				opcionDireccion = Entrada.entero();
				System.out.println("");
			}
		} else {
			System.out.println("==============================");
			System.out.println("Debes crear una torre primero.");
			System.out.println("==============================");
		}

		return opcionDireccion;
	}

	private static void crearTorreDefecto() {
		atributoTorre = new Torre();

		System.out.println("==============================");
		System.out.println("Estado actual de la torre:");
		System.out.println(atributoTorre);
		System.out.println("==============================");
	}

	private static void crearTorreColor() {
		Color atributoColor = elegirColor();
		atributoTorre = new Torre(atributoColor);

		System.out.println("===============================");
		System.out.println("Estado actual de la torre:");
		System.out.println(atributoTorre);
		System.out.println("===============================");

	}

	private static void crearTorreColorColumna() {
		Color atributoColor = elegirColor();
		char columna = elegirColumnaInicial();

		atributoTorre = new Torre(atributoColor, columna);

		System.out.println("===============================");
		System.out.println("Estado actual de la torre:");
		System.out.println(atributoTorre);
		System.out.println("===============================");

	}

	public static void mover() throws OperationNotSupportedException {

		if (atributoTorre != null) {
			mostrarMenuDirecciones();
			elegirDireccion();
			int pasos;
			Direccion atributoDireccion = null;

			switch (opcionDireccion) {
			case 1:
				atributoDireccion = Direccion.ENROQUE_LARGO;
				try {
					atributoTorre.enrocar(atributoDireccion);
				} catch (OperationNotSupportedException e) {
					e.getMessage();
				}
				System.out.println("Enroque largo realizado");
				System.out.println("===============================");
				System.out.println("Estado actual de la torre:");
				System.out.println(atributoTorre);
				System.out.println("===============================");
				break;
				
			case 2:
				atributoDireccion = Direccion.ENROQUE_CORTO;
				try {
					atributoTorre.enrocar(atributoDireccion);
				} catch (OperationNotSupportedException e) {
					e.getMessage();
				}

				System.out.println("Enroque corto  realizado");
				System.out.println("===============================");
				System.out.println("Estado actual de la torre:");
				System.out.println(atributoTorre);
				System.out.println("===============================");
				break;

			case 3:
				atributoDireccion = Direccion.ARRIBA;
				System.out.print("Elige la cantidad de pasos que deseas realizar: ");
				pasos = Entrada.entero();
				try {
					atributoTorre.mover(atributoDireccion, pasos);
				} catch (OperationNotSupportedException e) {
					e.getMessage();
				}
				System.out.println("===============================");
				System.out.println("Estado actual de la torre:");
				System.out.println(atributoTorre);
				System.out.println("===============================");
				break;

			case 4:
				atributoDireccion = Direccion.IZQUIERDA;
				System.out.print("Elige la cantidad de pasos que deseas realizar: ");
				pasos = Entrada.entero();
				try {
					atributoTorre.mover(atributoDireccion, pasos);
				} catch (OperationNotSupportedException e) {
					e.getMessage();
				}
				System.out.println("===============================");
				System.out.println("Estado actual de la torre:");
				System.out.println(atributoTorre);
				System.out.println("===============================");
				break;

			case 5:
				atributoDireccion = Direccion.DERECHA;
				System.out.print("Elige la cantidad de pasos que deseas realizar: ");
				pasos = Entrada.entero();
				try {
					atributoTorre.mover(atributoDireccion, pasos);
				} catch (OperationNotSupportedException e) {
					e.getMessage();
				}
				System.out.println("===============================");
				System.out.println("Estado actual de la torre:");
				System.out.println(atributoTorre);
				System.out.println("===============================");
				break;

			case 6:
				atributoDireccion = Direccion.ABAJO;
				System.out.print("Elige la cantidad de pasos que deseas realizar: ");
				pasos = Entrada.entero();
				try {
					atributoTorre.mover(atributoDireccion, pasos);
				} catch (OperationNotSupportedException e) {
					e.getMessage();
				}
				System.out.println("===============================");
				System.out.println("Estado actual de la torre:");
				System.out.println(atributoTorre);
				System.out.println("===============================");
				break;
			}
			
				
			
		} else {
			System.out.println("==============================");
			System.out.println("Debes crear una torre primero.");
			System.out.println("==============================");
		}
	}

	private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
		switch (opcion) {
		case 1:
			System.out.println("\n******************************************************");
			System.out.println("Elegiste la opción 1.- Crear una torre negra en h1");
			System.out.println("******************************************************");
			crearTorreDefecto();
			break;

		case 2:
			System.out.println("\n*****************************************************************************");
			System.out.println("Elegiste la opción 2.- Crear una torre en columna \"h\" seleccionando el color.");
			System.out.println("*****************************************************************************");
			crearTorreColor();
			break;

		case 3:
			System.out.println("\n***************************************************************************");
			System.out.println("Elegiste la opción 3.- Crear una torre seleccionando el color y la columna.");
			System.out.println("***************************************************************************");
			crearTorreColorColumna();
			break;

		case 4:
			System.out.println("\n*********************************************");
			System.out.println("Elegiste la opción 4.- Mover la torre creada.");
			System.out.println("*********************************************");
			mover();
			break;

		case 5:
			System.out.println("\n************************************************************");
			System.out.println("Elegiste la opción 5.- Mostrar el estado actual de la torre.");
			System.out.println("************************************************************");
			mostrarTorre();
			break;

		}
	}

}
