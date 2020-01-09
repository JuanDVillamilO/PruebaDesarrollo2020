package co.com.certicamara.pruebadesarrollo.testcarro;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static ArrayList<String[]> move = new ArrayList<String[]>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		try {
			/** Men煤 para ingresar datos**/
			System.out.println("Ingrese el n煤mero de filas para la superficie: ");
			int rows = input.nextInt();
			input.nextLine();
			System.out.println("Ingrese el n煤mero de columnas para la superficie: ");
			int columns = input.nextInt();
			input.nextLine();
			//Confirmaci贸n de datos
			System.out.println("驴Los valores son correctos?(Y/N): ");
			String answer = input.next();
			if(answer.equals("y") || answer.equals("Y")) {
				if(rows > 0 && columns > 0) {
					String[][] matrix = new String[rows][columns]; //Creaci贸n de matriz
					System.out.println(matrix.length + " sad");
					System.out.println("Posici贸n del carro: 0 Y - 0 - X"); //Posici贸n inicial del carro
	
					System.out.println(columns + " - - " + rows);
					
					boolean flag = false;
					/**Movimientos a realizar por el carro **/
					while(!flag) {
						System.out.println("Ingrese los movimientos del carro:");
						String movements = input2.nextLine(); //Cadena de movimientos
						flag = insertData(movements);
					}
					
					int[] pos = {0, 0};
					System.out.println("Posici贸n en y:(fila) " + pos[0] + " Posici贸n en x:(columna) " + pos[1]);
					for(int i = 0; i < move.size(); i++) {
						
						pos = moveCar(Integer.parseInt(move.get(i)[0]), move.get(i)[1], pos[0], pos[1], rows, columns);
						System.out.println("Posici贸n en y:(fila) " + pos[0] + " Posici贸n en x:(columna) " + pos[1]);
						
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

	/**Validaci贸n de car谩cteres especiales no permitidos**/
	public static boolean validateChar(String parameters) {
		String chSpecial = "-*._+!#@$%&/()=?隆驴掳{}:[] ";//Car谩cteres no permitidos
		boolean find = true;
		for (int i = 0; i < parameters.length(); i++) {//Recorrido de cadena de movimientos
			for (int j = 0; j < chSpecial.length(); j++) {//Recorrido arreglo de car谩cteres no permitidos 
				if (parameters.contains(chSpecial.charAt(j) + "")) {//Validaci贸n de car谩cteres en cadena de movimientos
					System.out.println("Car谩cter no valido, vuelva a intentar");
					find = false;
					return find;
				}
			}
		}
		return find;
	}
	
	/**
	 * VALIDAR EL ORDEN DE LOS PARAM,ETROS
	 * 
	 * PENDIENTE
	 * 
	 * FALTA MOSTRAR QUE COMANDO SE EJECUTO
	 * 
	 */
	
	/**Llenado de ArrayList con movimientos**/
	public static boolean insertData(String movements) { 
		boolean flag = false;
		movements = movements.toUpperCase(); //Estandarizar en may鷖culas las letras
		if(validateChar(movements)) {//Validaci髇 de car醕teres
			String[] mv = movements.split(";");
			for(int i = 0; i < mv.length; i++) {
				String[] val = mv[i].split(",");
				if(isNumeric(val[0]) && !isNumeric(val[1])) {//Validaci髇 estructura de movimiento
					
					if(val.length != 2 || val[1].length() > 1)  {//Se valida orden de p醨ametros
						System.out.println("Cadena invalida, intente de nuevo INSERT DATA TAMA袿 ARREGLO");
						return flag;
					}
					//Validaci髇 estructura de la direcci髇 del movimiento
					if(!val[1].contains("N") && !val[1].contains("S") && !val[1].contains("O") && !val[1].contains("E")){
						System.out.println("Cadena invalida, intente de nuevo  INSERT DATA LETRAS");
						return flag;
					}
					move.add(val); //ingreso de movimiento a lista de movimientos
					
				}else {
					System.out.println("Cadena invalida, el orden de los valores esta al rev閟");
					return flag;
				}
					
				 
			}
			flag = true;
		}
		System.out.println("insert " + flag);
		return flag;
	}
	
	/**Validaci贸n de la direcci贸n y movimiento de carro**/
	public static int[] moveCar(int steps, String direction, int posRow, int posCol, int matrixR, int matrixC) {
		matrixR--;
		System.out.println("Tama帽o matrixR: " + matrixR);
		matrixC--;
		System.out.println("Tama帽o matrixC: " + matrixC);
		switch(direction) {
			case "N":
				if(steps > (matrixR - posRow)) {
					posRow = matrixR;
					System.out.println("Se ha detenido el avance por salir de los l铆mites");
				}else {
					posRow = posRow + steps;
				}
				break;
			case "S":
				if(steps > posRow) {
					posRow = 0;
					System.out.println("Se ha detenido el avance por salir de los l铆mites");
				}else {
					posRow = posRow - steps;
				}
				break;
			case "O":
				if(steps > posCol) {
					posCol = 0;
					System.out.println("Se ha detenido el avance por salir de los l铆mites");
				}else {
					posCol = posCol - steps;
				}
				break;
			case "E":
				if(steps > (matrixC - posCol)) {
					posCol = matrixC;
					System.out.println("Se ha detenido el avance por salir de los l铆mites");
				}else {
					posCol = posCol + steps;
				}
				break;
			default:
				System.out.println("Direcci贸n erronea");
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