package co.com.certicamara.serviciocarro.service;

import javax.validation.Valid;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.certicamara.serviciocarro.logica.Displacement;
import co.com.certicamara.serviciocarro.modelo.Carro;
import co.com.certicamara.serviciocarro.modelo.Matrix;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST} )
@RestController
@RequestMapping("/Servicios")

public class Controller {
	
	public static Matrix matrix;
	public static Carro car = new Carro();
	
	@RequestMapping(
			path = "/configSurface",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
    public @ResponseBody Matrix configSurface(@Valid @RequestBody Matrix matrix){
		if(matrix.getColumns() > 0 && matrix.getRows() > 0) {
			this.matrix = matrix;
			car = new Carro();
			System.out.println("rows: " + this.matrix.getRows() + " columns: " + this.matrix.getColumns());
		}else {
			System.out.println("Debe ingresar un valor mayor a 0");
		}
		return this.matrix;
	}
	
	@RequestMapping(
			path = "/displacement",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
    public @ResponseBody Carro displacement(@Valid @RequestBody Carro car){
		if(!(matrix == null)) {
			Displacement dis = new Displacement();
			this.car = dis.ejecutar(matrix.getRows(), matrix.getColumns(), car);			
		}else {
			this.car.setMessage("No se ha configurado la superficie");
			System.out.println("No se ha configurado la superficie");
		}
		return this.car;
	}
	
	
	@RequestMapping(
			path = "/getPosition",
			method = RequestMethod.GET,
			consumes = "application/json",
			produces = "application/json")
    public @ResponseBody Carro getPosition(){
		return car;
	}
}
