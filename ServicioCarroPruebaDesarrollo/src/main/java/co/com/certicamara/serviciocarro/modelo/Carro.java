package co.com.certicamara.serviciocarro.modelo;

public class Carro {

	public String moviments;
	public int posR, posC, steps;
	
	public Carro() {
		this.moviments = "";
		this.posR = 0;
		this.posC = 0;
	}
	
	public Carro(String moviments, int posR, int posC) {
		this.moviments = moviments;
		this.posR = posR;
		this.posC = posC;
	}

	public String getMoviments() {
		return moviments;
	}

	public void setMoviments(String moviments) {
		this.moviments = moviments;
	}

	public int getPosR() {
		return posR;
	}

	public void setPosR(int posR) {
		this.posR = posR;
	}

	public int getPosC() {
		return posC;
	}

	public void setPosC(int posC) {
		this.posC = posC;
	}
	
	
}
