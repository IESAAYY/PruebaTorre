package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	
	//Declaración de variable privates
	private int filas;
	private char columnas;
	
	//Métodos get y set para filas y columnas con expeciones indicadas por el enunciado en sus respectivos lugares
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		if (filas < 1 || filas > 8) {
			throw new IllegalArgumentException("Debe ser entero entre 1 y 8");
		} else {
			this.filas = filas;
		}
	}

	public char getColumnas() {
		return columnas;
	}

	public void setColumnas(char columnas) {
		if (columnas < 'a' || columnas > 'h') {
			throw new IllegalArgumentException("Deber ser del alfabeto entre a y h");

		} else {

			this.columnas = columnas;
		}
	}

}
