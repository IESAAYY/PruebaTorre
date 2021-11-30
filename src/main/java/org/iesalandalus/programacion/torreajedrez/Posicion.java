package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {

	// Declaración de atributos privados de clase
	private int fila;
	private char columna;

	// Constructores
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}

	public Posicion(Posicion parametroPosicion) {
		if (parametroPosicion!=null) {
			this.fila = parametroPosicion.getFila();
			this.columna = parametroPosicion.getColumna();
		} else {
		 throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
	}

	// Métodos set y get para fila y columna con excepciones indicadas por el
	// enunciado en sus respectivos lugares
	private void setFila(int fila) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else {
			this.fila = fila;
		}
	}

	public int getFila() {
		return fila;
	}

	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");

		} else {

			this.columna = columna;
		}
	}

	public char getColumna() {
		return columna;
	}

	// Métodos hashCode y equals
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

	// Método toString
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}
}
