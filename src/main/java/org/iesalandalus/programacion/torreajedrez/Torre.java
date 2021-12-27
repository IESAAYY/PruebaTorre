package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

import org.apache.commons.math3.exception.NullArgumentException;

public class Torre {

	private Color color;
	private Posicion posicion;

	// Constructores
	public Torre() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'h');
	}

	public Torre(Color parametroColor) {
		if (parametroColor!=null) {		
			if (parametroColor == Color.BLANCO) {
				posicion = new Posicion(1, 'h');
			}
			if (parametroColor == Color.NEGRO) {
				posicion = new Posicion(8, 'h');
			}
		
			this.color=parametroColor;
		} else {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		
	}

	public Torre(Color parametroColor, char colInicial) {
		setColor(parametroColor);

		if (colInicial == 'a' || colInicial == 'h') {
			if (parametroColor == Color.BLANCO) {
				posicion = new Posicion(1, colInicial);
			} else {
				posicion = new Posicion(8, colInicial);
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
	}

	// Métrodos set y get

	private void setPosicion(Posicion posicion) {
		if (posicion != null) {
			this.posicion = posicion;
		} else {
			throw new NullPointerException("Mensaje error: Deberías de haber introducido una posición válida");
		}
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setColor(Color sColor) {
		if (sColor != null) {
			color = sColor;
		} else {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}

	}

	public Color getColor() {
		return color;
	}

	// Métodos de miviemento
	public void enrocar(Direccion parametroDireccion) throws OperationNotSupportedException {
		if (parametroDireccion==null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		switch (parametroDireccion) {

		case ENROQUE_CORTO:
			if (color == Color.BLANCO) {
				if (posicion.getFila() == 1 && posicion.getColumna() == 'h') {
					setPosicion(new Posicion(1, 'f'));

				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
			}
			
			if (color == Color.NEGRO) {
				if (posicion.getFila() == 8 && posicion.getColumna() == 'h') {
					setPosicion(new Posicion(8, 'f'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				
			}
			break;

		case ENROQUE_LARGO:
			if (color == Color.BLANCO) {
				if (posicion.getFila() == 1 && posicion.getColumna() == 'a') {
					setPosicion(new Posicion(1, 'd'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
			} 
			
			if (color == Color.NEGRO) {
				if (posicion.getFila() == 8 && posicion.getColumna() == 'a') {
					setPosicion(new Posicion(8, 'd'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				} 
			} 
			break;
		default:
		}

	}
	
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
				if (color == Color.BLANCO) {
					setPosicion(new Posicion(posicion.getFila() + pasos, (char) posicion.getColumna()));
				} else {
					setPosicion(new Posicion(posicion.getFila() - pasos, (char) posicion.getColumna()));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;

		case IZQUIERDA:

			try {
				if (color == Color.BLANCO) {
					setPosicion(
							new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
				} else {
					setPosicion(new Posicion(posicion.getFila(),
							(char) (posicion.getColumna() + pasos)));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;

		case DERECHA:
			try {
				if (color == Color.BLANCO) {
					setPosicion(
							new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
				} else {
					setPosicion(
							new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;

		case ABAJO:
			try {
				if (color == Color.BLANCO) {
					setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
				} else {
					setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(
						"ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		default:
		}

	}

	// Métodos hashCode y equals, y toString
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	public String toString() {
		return "fila="+posicion.getFila()+", columna="+posicion.getColumna()+", color="+color;
	}

}
