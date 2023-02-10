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

import idat.pe.Examen.Entity.CitasEntity;
import idat.pe.Examen.Service.CitasService;

@RestController
@RequestMapping("/Citas")
public class CitasController {
	@Autowired
	private CitasService citasservice;
	public CitasController() {}
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
		Collection<CitasEntity>citasDb=citasservice.findAll();
		if(citasDb.isEmpty()) {
			return new ResponseEntity<>(citasDb,HttpStatus.OK);
		}
		return new ResponseEntity<>(citasDb,HttpStatus.OK);
	}
	@PostMapping("/agregar")
	public ResponseEntity<?>agregar(@RequestBody CitasEntity citas){
		citasservice.insert(citas);
		return new ResponseEntity<>("Cita Registrada",HttpStatus.CREATED);
	}
	@PutMapping("/editar/{IdCita}")
	public ResponseEntity<?>editar_cita(@RequestBody CitasEntity citas,@PathVariable Integer IdCita){
		CitasEntity citasDb=citasservice.findById(IdCita);
		if(citas!=null) {
			citasDb.setDoctor(citas.getDoctor());
			citasDb.setPaciente(citas.getPaciente());
			citasDb.setFechaCita(citas.getFechaCita());
			citasDb.setHoraCita(citas.getHoraCita());
			citasservice.update(citasDb);
			return new ResponseEntity<>("Cita actualizada",HttpStatus.OK);
		}
		return new ResponseEntity<>("Cita no encontrada",HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{IdCita}")
	public ResponseEntity<?>borrarCita(@PathVariable Integer IdCita){
		CitasEntity citasDb=citasservice.findById(IdCita);
		if(citasDb!=null) {
			citasservice.delete(IdCita);
			return new ResponseEntity<>("Cita eliminada",HttpStatus.OK);
		}
		return new ResponseEntity<>("Cita no encontrada",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/buscar/{IdCita}")
	public ResponseEntity<?>buscarcita(@PathVariable Integer Idcita){
		CitasEntity citaDb=citasservice.findById(Idcita);
		if(citaDb!=null) {
			return new ResponseEntity<>(citaDb,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("cita no encontrada",HttpStatus.NOT_FOUND);
	}

}
