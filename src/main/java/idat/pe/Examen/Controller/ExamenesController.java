package idat.pe.Examen.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.pe.Examen.Entity.ExamenesEntity;
import idat.pe.Examen.Service.ExamenesService;

@RestController
@RequestMapping("/Examenes")
public class ExamenesController {
	@Autowired
	private ExamenesService examenservice;
	public ExamenesController() {}
	@GetMapping("/listar")
	public ResponseEntity<?>listar(){
		Collection<ExamenesEntity>examenDb=examenservice.findAll();
		if(examenDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/registrar")
	public ResponseEntity<?>registrarexmaen(@RequestBody ExamenesEntity examen){
		examenservice.insert(examen);
		return new ResponseEntity<>("Examen Medico Registrado",HttpStatus.CREATED);
	}
	@PutMapping("/editar/{IdExamenMedico}")
	public ResponseEntity<?>editar(@RequestBody ExamenesEntity examen,@PathVariable Integer IdExamenMedico){
		ExamenesEntity examenDb=examenservice.findById(IdExamenMedico);
		if(examenDb!=null) {
			examenDb.setPaciente(examen.getPaciente());
			examenDb.setResultado(examen.getResultado());
			examenDb.setDescripcion(examen.getDescripcion());
			examenDb.setFechadeRealizacion(examen.getFechadeRealizacion());
			return new ResponseEntity<>("Examen Actualizado",HttpStatus.OK);
		}
		return new ResponseEntity<>("Examen no encontrado",HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{IdExamenMedico}")
	public ResponseEntity<?>eliminarexamen(@PathVariable Integer IdExamenMedico){
		ExamenesEntity examenDb=examenservice.findById(IdExamenMedico);
		if(examenDb!=null) {
			examenservice.delete(IdExamenMedico);
			return new ResponseEntity<>("Examen Medico Eliminado",HttpStatus.OK);
		}
		return new ResponseEntity<>("Examen medico no encontrado",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/buscar/{IdExamenMedico}")
	public ResponseEntity<?>buscarexamen(@PathVariable Integer IdExamenMedico){
		ExamenesEntity examenDb=examenservice.findById(IdExamenMedico);
		if(examenDb!=null) {
			return new ResponseEntity<>(examenDb,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("Examen Medico No encontrado",HttpStatus.NOT_FOUND);
	}

}
