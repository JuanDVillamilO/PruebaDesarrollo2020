package co.com.certicamara.serviciocarro.logica;

import java.util.ArrayList;

import co.com.certicamara.serviciocarro.modelo.Carro;
import co.com.certicamara.serviciocarro.modelo.Matrix;

public class Displacement {

	private Carro car = new Carro();
	private  ArrayList<String[]> move = new ArrayList<String[]>();
		
	public Carro ejecutar(int r, int c, Carro car) {
		try {
			/** Menú para ingresar datos**/
			int rows = r;
			int columns = c;
			
			System.out.println("Posición del carro: " + r + " Y - " + c + " - X"); //Posición inicial del carro
	
			System.out.println(columns + " - - " + rows);
			
			/**Movimientos a realizar por el carro **/
			System.out.println("Ingrese los movimientos del carro:");
			String movements = car.getMoviments(); //Cadena de movimientos
			if(insertData(movements)) {
				
				int[] pos = {car.getPosR(), car.getPosC()};
				System.out.println("Posición en y:(fila) " + car.getPosR() + " Posición en x:(columna) " + car.getPosC());
				for(int i = 0; i < move.size(); i++) {
					
					pos = moveCar(Integer.parseInt(move.get(i)[0]), move.get(i)[1], car.getPosR(), car.getPosC(), rows, columns);
					car.setPosR(pos[0]);
					car.setPosC(pos[1]);
					System.out.println("ACTUAL:  Posición en y:(fila) " + car.getPosR() + " Posición en x:(columna) " + car.getPosC());
					
				}
			}
			
		}catch(Exception e) {
			this.car.setMessage("Error ingresando los datos");
			System.out.println(e.getMessage());
			System.out.println("Error ingresando los datos");
		}finally {
			car.setMessage(this.car.getMessage());
			return car;
		}
	}
	

	/**Validación de carácteres especiales no permitidos**/
	public  boolean validateChar(String parameters) {
		String chSpecial = "-*._+!#@$%&/()=?¡¿°{}:[] ";//Carácteres no permitidos
		boolean find = true;
		for (int i = 0; i < parameters.length(); i++) {//Recorrido de cadena de movimientos
			for (int j = 0; j < chSpecial.length(); j++) {//Recorrido arreglo de carácteres no permitidos 
				if (parameters.contains(chSpecial.charAt(j) + "")) {//Validación de carácteres en cadena de movimientos
					car.setMessage("Carácter no valido, vuelva a intentar");
					System.out.println("Carácter no valido, vuelva a intentar");
					find = false;
					return find;
				}
			}
		}
		return find;
	}
	
	
	/**Llenado de ArrayList con movimientos**/
	public boolean insertData(String movements) { 
		boolean flag = false;
		movements = movements.toUpperCase(); //Estandarizar en mayúsculas las letras
		if(validateChar(movements)) {//Validación de carácteres
			String[] mv = movements.split(";");
			for(int i = 0; i < mv.length; i++) {
				String[] val = mv[i].split(",");
				if(isNumeric(val[0]) && !isNumeric(val[1])) {//Validación estructura de movimiento
					
					if(val.length != 2 || val[1].length() > 1)  {//Se valida orden de párametros
						car.setMessage("Cadena invalida, intente de nuevo. InsertData: TAMAÑO ARREGLO");
						System.out.println("Cadena invalida, intente de nuevo INSERT DATA TAMAÑO ARREGLO");
						return flag;
					}
					//Validación estructura de la dirección del movimiento
					if(!val[1].contains("N") && !val[1].contains("S") && !val[1].contains("O") && !val[1].contains("E")){
						car.setMessage("Cadena invalida, intente de nuevo. InsertData: LETRAS");
						System.out.println("Cadena invalida, intente de nuevo  INSERT DATA LETRAS");
						return flag;
					}
					move.add(val); //ingreso de movimiento a lista de movimientos
					
				}else {
					car.setMessage("Cadena invalida, el orden de los valores esta al revés");
					System.out.println("Cadena invalida, el orden de los valores esta al revés");
					return flag;
				}
					
				 
			}
			flag = true;
		}
		System.out.println("insert " + flag);
		return flag;
	}
	
	
	/**Validación de la dirección y movimiento de carro**/
	public int[] moveCar(int steps, String direction, int posRow, int posCol, int matrixR, int matrixC) {
		matrixR--;
		matrixC--;
		switch(direction) {
			case "N":
				if(steps > (matrixR - posRow)) {
					posRow = matrixR;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
					System.out.println("Se ha detenido el avance por salir de los límites");
					this.car.setMessage("Se ha detenido el avance por salir de los límites");
				}else {
					posRow = posRow + steps;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
				}
				break;
			case "S":
				if(steps > posRow) {
					posRow = 0;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
					System.out.println("Se ha detenido el avance por salir de los límites");
					this.car.setMessage("Se ha detenido el avance por salir de los límites");
				}else {
					posRow = posRow - steps;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
				}
				break;
			case "O":
				if(steps > posCol) {
					posCol = 0;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
					System.out.println("Se ha detenido el avance por salir de los límites");
					this.car.setMessage("Se ha detenido el avance por salir de los límites");
				}else {
					posCol = posCol - steps;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
				}
				break;
			case "E":
				if(steps > (matrixC - posCol)) {
					posCol = matrixC;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
					System.out.println("Se ha detenido el avance por salir de los límites");
					this.car.setMessage("Se ha detenido el avance por salir de los límites");
				}else {
					posCol = posCol + steps;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
				}
				break;
			default:
				System.out.println("Dirección erronea");
				break;
		}
		int[] position = {posRow, posCol};
		return position;
	}

	public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}
