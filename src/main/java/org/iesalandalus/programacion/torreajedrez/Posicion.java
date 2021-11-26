package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {

	// Declaración de variable privates
	private int fila;
	private char columna;

	// Métodos get y set para fila y columna con expeciones indicadas por el
	// enunciado en sus respectivos lugares
	public int getfila() {
		return fila;
	}
	
	//Constructor
	public Posicion(int fila, char columna) {
		setfila(fila);
		setcolumna(columna);
	}

	//Constructor copia
	public Posicion(Posicion Posicion) {
		this.fila = Posicion.getfila();
		this.columna = Posicion.getcolumna();
	}

	public void setfila(int fila) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("Mensaje error: Debe ser entero entre 1 y 8");
		} else {
			this.fila = fila;
		}
	}

	public char getcolumna() {
		return columna;
	}

	public void setcolumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException("Mensaje rror: Deber ser del alfabeto entre a y h");

		} else {

			this.columna = columna;
		}
	}

	//Métodos hashCode y equals
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}
	
	

}
