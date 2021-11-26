package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	
	//Declaración de atributos de clase como privados
	private Color atributoColor;
	private Posicion Posicion;

	public Color getColor() {
		return atributoColor;
	}
	
	private void setColor(Color sColor) {
		if (sColor != null) {
			atributoColor = sColor;
		} else {
			throw new NullPointerException("Mensaje error: Deberías de haber introducido un color.");
		}

	}

	public Posicion getPosicion() {
		return Posicion;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion != null) {
			Posicion = posicion;
		} else {
			throw new NullPointerException("Mensaje error: Deberías de haber introducido una posición.");
		}
	}

}
