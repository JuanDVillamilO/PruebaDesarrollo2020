package co.com.certicamara.serviciocarro.modelo;

public class Carro {

	private String moviments, message;
	private int posR, posC;
	
	public Carro() {
		this.moviments = "";
		this.posR = 0;
		this.posC = 0;
		this.message = "";
	}
	
	public Carro(String moviments, int posR, int posC, String message) {
		this.moviments = moviments;
		this.posR = posR;
		this.posC = posC;
		this.message = message;
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
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
