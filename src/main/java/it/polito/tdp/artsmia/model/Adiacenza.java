package it.polito.tdp.artsmia.model;

public class Adiacenza {
	
	private int obj1;
	private int obj2;
	private int peso;
	/**
	 * @param obj1
	 * @param obj2
	 * @param peso
	 */
	public Adiacenza(int obj1, int obj2, int peso) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.peso = peso;
	}
	public int getObj1() {
		return obj1;
	}
	public void setObj1(int obj1) {
		this.obj1 = obj1;
	}
	public int getObj2() {
		return obj2;
	}
	public void setObj2(int obj2) {
		this.obj2 = obj2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	

}
