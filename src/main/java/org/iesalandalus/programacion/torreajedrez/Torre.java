package org.iesalandalus.programacion.torreajedrez;

public class Torre {

	// Declaración de atributos de clase como privados
	private Color atributoColor;
	private Posicion atributoPosicion;

	// Constructor
	public Torre() {
		atributoColor = Color.NEGRO;
		atributoPosicion = new Posicion(8, 'h');
	}

	public Torre(Color parametroColor) {
		if (parametroColor == Color.BLANCO) {
			atributoPosicion = new Posicion(1, 'h');
		}
		if (parametroColor == Color.NEGRO) {
			atributoPosicion = new Posicion(8, 'h');
		}
	}

	public Torre(Color parametroColor, char colInicial) {
		setColor(parametroColor);

		if (colInicial == 'a' || colInicial == 'h') {
			if (parametroColor == Color.BLANCO) {
				atributoPosicion = new Posicion(1, colInicial);
			} else {
				atributoPosicion = new Posicion(8, colInicial);
			}
		} else {
			throw new IllegalArgumentException("Mensaje error: Deberías de haber introducido a ó h");
		}
	}

	// Métrodos get y set
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
		return atributoPosicion;
	}

	private void setPosicion(Posicion sPosicion) {
		if (sPosicion != null) {
			atributoPosicion = sPosicion;
		} else {
			throw new NullPointerException("Mensaje error: Deberías de haber introducido una posición.");
		}
	}

}
