package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	private Color Color;
	private Posicion Posicion;
	
	public Color getColor() {
		return Color;
	}
	private void setColor(Color color) {
		if (color!=null) {
			Color = color;
		} else {
			throw new NullPointerException("Mensaje error: Deber�as de haber introducido un color.");
		}
		
		
		
	}
	public Posicion getPosicion() {
		return Posicion;
	}
	private void setPosicion(Posicion posicion) {
		if (posicion!=null) {
		Posicion = posicion;
		} else {
			throw new NullPointerException("Mensaje error: Deber�as de haber introducido una posici�n.");
		}
	}
	
	
	
	
	
	
	
}
