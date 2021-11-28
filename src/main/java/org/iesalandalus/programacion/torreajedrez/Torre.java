package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

import org.apache.commons.math3.exception.NullArgumentException;

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
		if (parametroColor!=null) {		
			if (parametroColor == Color.BLANCO) {
				atributoPosicion = new Posicion(1, 'h');
			}
			if (parametroColor == Color.NEGRO) {
				atributoPosicion = new Posicion(8, 'h');
			}
			this.atributoColor=parametroColor;
		} else {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
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
			throw new IllegalArgumentException("ERROR: Columna no válida.");
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
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}

	}

	public Color getColor() {
		return atributoColor;
	}

	// Métodos de miviemento
	public void mover(Direccion parametroDireccion, int pasos) throws OperationNotSupportedException {
		if (pasos <= 0) {
			throw new IllegalArgumentException(
					"ERROR: El número de pasos debe ser positivo.");
		}
		if (parametroDireccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
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
						"ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;

		case IZQUIERDA:

			try {
				if (atributoColor == Color.BLANCO) {
					setPosicion(
							new Posicion(atributoPosicion.getFila(), (char) (atributoPosicion.getColumna() - pasos)));
				} else {
					setPosicion(new Posicion(atributoPosicion.getFila(),
							(char) (atributoPosicion.getColumna() + pasos)));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"ERROR: Movimiento no válido (se sale del tablero).");
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
						"ERROR: Movimiento no válido (se sale del tablero).");
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
						"ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		default:
		}

	}

	public void enrocar(Direccion parametroDireccion) throws OperationNotSupportedException {
		if (parametroDireccion==null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		switch (parametroDireccion) {

		case ENROQUE_CORTO:
			if (atributoColor == Color.BLANCO) {
				if (atributoPosicion.getFila() == 1 && atributoPosicion.getColumna() == 'h') {
					setPosicion(new Posicion(1, 'a'));

				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
			}
			
			if (atributoColor == Color.NEGRO) {
				if (atributoPosicion.getFila() == 8 && atributoPosicion.getColumna() == 'h') {
					setPosicion(new Posicion(8, 'f'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				
			}
			break;

		case ENROQUE_LARGO:
			if (atributoColor == Color.BLANCO) {
				if (atributoPosicion.getFila() == 1 && atributoPosicion.getColumna() == 'a') {
					setPosicion(new Posicion(1, 'd'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
			} 
			
			if (atributoColor == Color.NEGRO) {
				if (atributoPosicion.getFila() == 8 && atributoPosicion.getColumna() == 'a') {
					setPosicion(new Posicion(8, 'd'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				} 
			} 
			break;
		default:
		}

	}

	// Métodos hashCode y equals, y toString
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

	public String toString() {
		return "fila="+atributoPosicion.getFila()+", columna="+atributoPosicion.getColumna()+", color="+atributoColor;
	}

}
