package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Torre {

	// Declaración de atributos de clase como privados
	private Color atributoColor;
	private Posicion atributoPosicion;

	// Constructores
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

	// Métrodos set y get

	private void setPosicion(Posicion sPosicion) {
		if (sPosicion != null) {
			atributoPosicion = sPosicion;
		} else {
			throw new NullPointerException("Mensaje error: Deberías de haber introducido una posición válida");
		}
	}

	public Posicion getPosicion() {
		return atributoPosicion;
	}

	private void setColor(Color sColor) {
		if (sColor != null) {
			atributoColor = sColor;
		} else {
			throw new NullPointerException("Mensaje error: Deberías de haber introducido un color válido.");
		}

	}

	public Color getColor() {
		return atributoColor;
	}

	public void mover(Direccion parametroDireccion, int pasos) throws OperationNotSupportedException {
		if (pasos < 0) {
			throw new IllegalArgumentException(
					"Mensaje error: Supongo que querrás retroceder, para ello debes de fijarte en la dirección y no dar un paso negativo campeón.");
		}
		if (parametroDireccion == null) {
			throw new NullPointerException("Mensaje error: No puedes dar un paso sin haber elegido una dirección.");
		}

		switch (parametroDireccion) {
		case ARRIBA:
			try {
				if (atributoColor == Color.BLANCO) {
					setPosicion(new Posicion(atributoPosicion.getFila() + pasos, (char) atributoPosicion.getColumna()));
				} else {
					setPosicion(new Posicion(atributoPosicion.getFila() - pasos, (char) atributoPosicion.getColumna()));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
			}
			break;

		case IZQUIERDA:

			try {
				if (atributoColor == Color.BLANCO) {
					setPosicion(
							new Posicion(atributoPosicion.getFila(), (char) (atributoPosicion.getColumna() - pasos)));
				} else {
					setPosicion(new Posicion(atributoPosicion.getFila() + pasos,
							(char) (atributoPosicion.getColumna() + pasos)));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
			}
			break;

		case DERECHA:
			try {
				if (atributoColor == Color.BLANCO) {
					setPosicion(
							new Posicion(atributoPosicion.getFila(), (char) (atributoPosicion.getColumna() + pasos)));
				} else {
					setPosicion(
							new Posicion(atributoPosicion.getFila(), (char) (atributoPosicion.getColumna() - pasos)));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
			}
			break;

		case ABAJO:
			try {
				if (atributoColor == Color.BLANCO) {
					setPosicion(new Posicion(atributoPosicion.getFila() - pasos, atributoPosicion.getColumna()));
				} else {
					setPosicion(new Posicion(atributoPosicion.getFila() + pasos, atributoPosicion.getColumna()));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"Mensaje error: La frase \"The sky is the limit\" no se aplica en el ajedrez :(.");
			}
			break;
			default:
		}

	}

	public void enrocar(Direccion parametroDireccion) {
		switch (parametroDireccion) {

		case ENROQUE_CORTO:
			if (atributoColor == Color.BLANCO) {
				if (atributoPosicion.getFila() == 1 || atributoPosicion.getColumna() == 'h') {
					setPosicion(new Posicion(1, 'f'));

				}
			}
			if (atributoColor == Color.NEGRO) {
				if (atributoPosicion.getFila() == 8 || atributoPosicion.getColumna() == 'h') {
					setPosicion(new Posicion(8, 'f'));
				}
			}
			break;

		case ENROQUE_LARGO:
			if (atributoColor == Color.BLANCO) {
				if (atributoPosicion.getFila() == 1 || atributoPosicion.getColumna() == 'a') {
					setPosicion(new Posicion(1, 'd'));
				}
			}
			if (atributoColor == Color.NEGRO) {
				if (atributoPosicion.getFila() == 8 || atributoPosicion.getColumna() == 'a') {
					setPosicion(new Posicion(8, 'd'));
				}
			}
			break;
			default:
		}

	}

	public int hashCode() {
		return Objects.hash(atributoColor, atributoPosicion);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return atributoColor == other.atributoColor && Objects.equals(atributoPosicion, other.atributoPosicion);
	}
	
	

}
