package co.com.certicamara.pruebadesarrollo.testcarro;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static ArrayList<String[]> move = new ArrayList<String[]>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		try {
			/** Menú para ingresar datos**/
			System.out.println("Ingrese el número de filas para la superficie: ");
			int rows = input.nextInt();
			input.nextLine();
			System.out.println("Ingrese el número de columnas para la superficie: ");
			int columns = input.nextInt();
			input.nextLine();
			//Confirmación de datos
			System.out.println("¿Los valores son correctos?(Y/N): ");
			String answer = input.next();
			if(answer.equals("y") || answer.equals("Y")) {
				if(rows > 0 && columns > 0) {
					String[][] matrix = new String[rows][columns]; //Creación de matriz
					System.out.println("Posición inicial del carro: 0 Y - 0 - X"); //Posición inicial del carro
	
					System.out.println("Matriz: Columnas " + columns + " - - Filas " + rows);
					
					boolean flag = false;
					/**Movimientos a realizar por el carro **/
					while(!flag) {
						System.out.println("Ingrese los movimientos del carro:");
						String movements = input2.nextLine(); //Cadena de movimientos
						flag = insertData(movements);
					}
					
					int[] pos = {0, 0};
					System.out.println("Posición en y:(fila) " + pos[0] + " Posición en x:(columna) " + pos[1]);
					for(int i = 0; i < move.size(); i++) {
						
						pos = moveCar(Integer.parseInt(move.get(i)[0]), move.get(i)[1], pos[0], pos[1], rows, columns);
						System.out.println("Posición en y:(fila) " + pos[0] + " Posición en x:(columna) " + pos[1]);
						
					}
				}else {
					System.out.println("Debe ingresar valores mayores a 0");
				}
			
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error ingresando los datos");
		}finally {
			input2.close();
			input.close();			
		}
		
	}

	/**Validación de carácteres especiales no permitidos**/
	public static boolean validateChar(String parameters) {
		String chSpecial = "-*._+!#@$%&/()=?¡¿°{}:[] ";//Carácteres no permitidos
		boolean find = true;
		for (int i = 0; i < parameters.length(); i++) {//Recorrido de cadena de movimientos
			for (int j = 0; j < chSpecial.length(); j++) {//Recorrido arreglo de carácteres no permitidos 
				if (parameters.contains(chSpecial.charAt(j) + "")) {//Validación de carácteres en cadena de movimientos
					System.out.println("Carácter no valido, vuelva a intentar");
					find = false;
					return find;
				}
			}
		}
		return find;
	}
	
	/**Llenado de ArrayList con movimientos**/
	public static boolean insertData(String movements) { 
		boolean flag = false;
		movements = movements.toUpperCase(); //Estandarizar en may�sculas las letras
		if(validateChar(movements)) {//Validaci�n de car�cteres
			String[] mv = movements.split(";");
			for(int i = 0; i < mv.length; i++) {
				String[] val = mv[i].split(",");
				if(isNumeric(val[0]) && !isNumeric(val[1])) {//Validaci�n estructura de movimiento
					
					if(val.length != 2 || val[1].length() > 1)  {//Se valida orden de p�rametros
						System.out.println("Cadena invalida, intente de nuevo INSERT DATA TAMA�O ARREGLO");
						return flag;
					}
					//Validaci�n estructura de la direcci�n del movimiento
					if(!val[1].contains("N") && !val[1].contains("S") && !val[1].contains("O") && !val[1].contains("E")){
						System.out.println("Cadena invalida, intente de nuevo  INSERT DATA LETRAS");
						return flag;
					}
					move.add(val); //ingreso de movimiento a lista de movimientos
					
				}else {
					System.out.println("Cadena invalida, el orden de los valores esta al rev�s");
					return flag;
				}
					
				 
			}
			flag = true;
		}
		System.out.println("insert " + flag);
		return flag;
	}
	
	/**Validación de la dirección y movimiento de carro**/
	public static int[] moveCar(int steps, String direction, int posRow, int posCol, int matrixR, int matrixC) {
		matrixR--;
		matrixC--;
		switch(direction) {
			case "N":
				if(steps > (matrixR - posRow)) {
					posRow = matrixR;
					System.out.println("Posición actual: Fila " + posRow + " Columna " + posCol + " -- Movimiento: " + steps + " " +  direction);
					System.out.println("Se ha detenido el avance por salir de los límites");
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