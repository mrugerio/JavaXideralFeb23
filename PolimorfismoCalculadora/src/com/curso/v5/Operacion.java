package com.curso.v5;

public class Operacion {

	private int x;
	private int y;
	
	public Operacion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int ejecuta() {
		return 0;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()
				+" [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}
