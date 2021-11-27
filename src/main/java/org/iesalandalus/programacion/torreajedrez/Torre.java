package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre {

	// Declaraci�n de atributos de clase como privados
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
			throw new IllegalArgumentException("Mensaje error: Deber�as de haber introducido a � h");
		}
	}

	// M�trodos get y set
	public Color getColor() {
		return atributoColor;
	}

	private void setColor(Color sColor) {
		if (sColor != null) {
			atributoColor = sColor;
		} else {
			throw new NullPointerException("Mensaje error: Deber�as de haber introducido un color v�lido.");
		}

	}

	public Posicion getPosicion() {
		return atributoPosicion;
	}

	private void setPosicion(Posicion sPosicion) {
		if (sPosicion != null) {
			atributoPosicion = sPosicion;
		} else {
			throw new NullPointerException("Mensaje error: Deber�as de haber introducido una posici�n v�lida");
		}
	}

	
	public void mover(Direccion parametroDireccion, int pasos) throws OperationNotSupportedException {
		if (pasos < 0) {
			throw new IllegalArgumentException(
					"Mensaje error: Supongo que querr�s retroceder, para ello debes de fijarte en la direcci�n y no dar un paso negativo campe�n.");
		}
		if (parametroDireccion == null) {
			throw new NullPointerException(
					"Mensaje error: No puedes dar un paso sin haber elegido una direcci�n.");
		}
	
			switch(parametroDireccion) {
				case ARRIBA: 
					try {
					if (atributoColor==Color.BLANCO) {
						setPosicion(new Posicion(atributoPosicion.getFila()+pasos, (char)atributoPosicion.getColumna()));	
					} else {
						setPosicion(new Posicion(atributoPosicion.getFila()-pasos, (char)atributoPosicion.getColumna()));
					}
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
					}
					break;
					
				case IZQUIERDA:
					
					try {
					if (atributoColor==Color.BLANCO) {
						setPosicion(new Posicion(atributoPosicion.getFila(), (char)(atributoPosicion.getColumna()-pasos)));
					} else {
						setPosicion(new Posicion(atributoPosicion.getFila()+pasos, (char)(atributoPosicion.getColumna()+pasos)));
					}
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
					}
					break;
				
				case DERECHA:
					try {
					if (atributoColor==Color.BLANCO) {
						setPosicion(new Posicion(atributoPosicion.getFila(), (char) (atributoPosicion.getColumna()+pasos)));
					} else {
						setPosicion(new Posicion(atributoPosicion.getFila(), (char) (atributoPosicion.getColumna()-pasos)));
					}
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
					}
					break;
					
				case ABAJO:
					try {
					if (atributoColor==Color.BLANCO) {
						setPosicion(new Posicion(atributoPosicion.getFila()-pasos, atributoPosicion.getColumna()));
					} else {
						setPosicion(new Posicion(atributoPosicion.getFila()+pasos, atributoPosicion.getColumna()));
					}
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
					}
				break;
			}
				
	}

}
