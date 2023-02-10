package idat.pe.Examen.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.pe.Examen.Entity.HistorialMedicoEntity;
import idat.pe.Examen.Service.HistorialMedicoService;

@RestController
@RequestMapping("/HistorialMedico")
public class HistorialMedicoController {
	@Autowired
	private HistorialMedicoService historialservice;
	public HistorialMedicoController() {}
	@GetMapping("/listar")
	public ResponseEntity<?>listar(){
		Collection<HistorialMedicoEntity>historialDb=historialservice.findAll();
		if(historialDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<>(historialDb,HttpStatus.OK);
	}
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody HistorialMedicoEntity historial){
		historialservice.insert(historial);
		return new ResponseEntity<>("Historial Registrado corectamente",HttpStatus.CREATED);
	}
	@PutMapping("/editar/{IdHistorialMedico}")
	public ResponseEntity<?>editar(@RequestBody HistorialMedicoEntity historial,@PathVariable Integer IdHistorialMedico){
		HistorialMedicoEntity historialDb=historialservice.findById(IdHistorialMedico);
		if(historialDb!=null) {
			historialDb.setDiagnosticoAnterior(historial.getDiagnosticoAnterior());
			historialDb.setResetaMedicaAnterior(historial.getResetaMedicaAnterior());
			historialDb.setFechaDiagnostico(historial.getFechaDiagnostico());
			historialservice.update(historialDb);
			return new ResponseEntity<>("Historial Medico actualizado",HttpStatus.OK);
		}
		return new ResponseEntity<>("Historial no encontrado",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/eliminar/{IdHistorialMedico}")
	public ResponseEntity<?>eliminar(@PathVariable Integer IdHistorialMedico){
		HistorialMedicoEntity historialDb=historialservice.findById(IdHistorialMedico);
		if(historialDb!=null) {
			historialservice.delete(IdHistorialMedico);
			return new ResponseEntity<>("Historial eliminado",HttpStatus.OK);
		}
		return new ResponseEntity<>("Historial no encontrado",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/buscar/{IdHistorialMedico}")
	public ResponseEntity<?>buscar(@PathVariable Integer IdHistorialMedico){
		HistorialMedicoEntity historialDb=historialservice.findById(IdHistorialMedico);
		if(historialDb!=null) {
		return new ResponseEntity<>(historialDb,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("historial no encontrado",HttpStatus.NOT_FOUND);
		}
	
}
