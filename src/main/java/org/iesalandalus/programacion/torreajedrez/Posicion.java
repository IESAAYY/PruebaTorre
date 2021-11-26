package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {

	// Declaraci�n de variable privates
	private int fila;
	private char columna;

	
	
	//Constructor
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}

	//Constructor copia
	public Posicion(Posicion Posicion) {
		this.fila = Posicion.getFila();
		this.columna = Posicion.getColumna();
	}

	// M�todos get y set para fila y columna con excepciones indicadas por el
		// enunciado en sus respectivos lugares
		public int getFila() {
			return fila;
		}
	
	private void setFila(int fila) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("Mensaje error: Debe ser entero entre 1 y 8");
		} else {
			this.fila = fila;
		}
	}

	public char getColumna() {
		return columna;
	}

	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException("Mensaje rror: Deber ser del alfabeto entre a y h");

		} else {

			this.columna = columna;
		}
	}

	//M�todos hashCode y equals
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
	
	//M�todo toString 
	public String toString() {
		return "Fila seleccionada: "+fila+"   Columna seleccionada: "+columna;
	}
}