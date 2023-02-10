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

import idat.pe.Examen.Entity.PacienteEntity;
import idat.pe.Examen.Service.PacienteService;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {
	@Autowired
	private PacienteService pacienteservice;
	private PacienteController() {}
	@GetMapping("/listar")
	public ResponseEntity<?>listar(){
		Collection<PacienteEntity>pacienteDb=pacienteservice.findAll();
		if(pacienteDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(pacienteDb,HttpStatus.OK);
	}
	@PostMapping("/registrar")
	public ResponseEntity<?>registar(@RequestBody PacienteEntity paciente){
		pacienteservice.insert(paciente);
		return new ResponseEntity<>("Paciente registrado",HttpStatus.CREATED);
	}
	@PutMapping("/editar/{IdPaciente}")
	public ResponseEntity<?>editar(@RequestBody PacienteEntity paciente,@PathVariable Integer IdPaciente){
		PacienteEntity pacienteDb=pacienteservice.findById(IdPaciente);
		if(pacienteDb!=null) {
			pacienteDb.setNombresP(paciente.getNombresP());
			pacienteDb.setApellidoP(paciente.getApellidoP());
			pacienteDb.setFechanacimiento(paciente.getFechanacimiento());
			pacienteDb.setAños(paciente.getAños());
			pacienteDb.setDNI(paciente.getDNI());
			pacienteDb.setDoctors(paciente.getDoctors());
			pacienteDb.setExamenes(paciente.getExamenes());
			return new ResponseEntity<>("Paciente Actualizado",HttpStatus.OK);
		}
		return new ResponseEntity<>("Paciente no encontrado",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/eliminar/{IdPaciente}")
	public ResponseEntity<?>eliminar(@PathVariable Integer IdPaciente){
		PacienteEntity pacienteDb=pacienteservice.findById(IdPaciente);
		if(pacienteDb!=null) {
			return new ResponseEntity<>("Paciente Eliminado",HttpStatus.FOUND);
		}
		return new ResponseEntity<>("Paciente no encontrado",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/buscar/{IdPaciente}")
	public ResponseEntity<?>buscar(@PathVariable Integer IdPaciente){
		PacienteEntity pacienteDb=pacienteservice.findById(IdPaciente);
		if(pacienteDb!=null) {
			return new ResponseEntity<>(pacienteDb,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("Paciente no encontrado",HttpStatus.NOT_FOUND);
	}

}
