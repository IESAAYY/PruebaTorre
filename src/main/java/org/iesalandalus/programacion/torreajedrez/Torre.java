package org.iesalandalus.programacion.torreajedrez;

public class Torre {

	// Declaraci�n de atributos de clase como privados
	private Color atributoColor;
	private Posicion atributoPosicion;

	// Constructor
	public Torre() {
		atributoColor = Color.NEGRO;
		atributoPosicion = new Posicion(8, 'h');

	}

	// M�trodos get y set
	public Color getColor() {
		return atributoColor;
	}

	private void setColor(Color sColor) {
		if (sColor != null) {
			atributoColor = sColor;
		} else {
			throw new NullPointerException("Mensaje error: Deber�as de haber introducido un color.");
		}

	}

	public Posicion getPosicion() {
		return atributoPosicion;
	}

	private void setPosicion(Posicion sPosicion) {
		if (sPosicion != null) {
			atributoPosicion = sPosicion;
		} else {
			throw new NullPointerException("Mensaje error: Deber�as de haber introducido una posici�n.");
		}
	}

}
