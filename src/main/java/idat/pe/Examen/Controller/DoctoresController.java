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

import idat.pe.Examen.Entity.DoctoresEntity;
import idat.pe.Examen.Service.DoctorService;

@RestController
@RequestMapping("/Doctores")
public class DoctoresController {
	@Autowired
	private DoctorService doctoresservice;
	public DoctoresController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?>listardoctor(){
		Collection<DoctoresEntity>doctorDb=doctoresservice.findAll();
		if(doctorDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(doctorDb,HttpStatus.OK);
		
	}
	@PostMapping("/registrar")
	public ResponseEntity<?>registar(@RequestBody DoctoresEntity doctor){
		doctoresservice.insert(doctor);
		return new ResponseEntity<>("Doctor Registrado",HttpStatus.CREATED);
	}
	@PutMapping("/editar/{IdDoctor}")
	public ResponseEntity<?>editarDoctor(@RequestBody DoctoresEntity doctor,@PathVariable Integer IdDoctor){
		DoctoresEntity DoctorDb=doctoresservice.findById(IdDoctor);
		if(DoctorDb!=null) {
			DoctorDb.setNombresM(doctor.getNombresM());
			DoctorDb.setApellidosM(doctor.getApellidosM());
			DoctorDb.setDNI(doctor.getDNI());
			DoctorDb.setEspecialidadM(doctor.getEspecialidadM());
			doctoresservice.update(DoctorDb);
			return new ResponseEntity<>("Doctor Actualizado Corectamente",HttpStatus.OK);
		}
		return new ResponseEntity<>("Doctor Editado",HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{IdDoctor}")
	public ResponseEntity<?>eliminarDoctor(@PathVariable Integer IdDoctor){
		DoctoresEntity DoctorDb=doctoresservice.findById(IdDoctor);
		if(DoctorDb!=null) {
			doctoresservice.delete(IdDoctor);
			return new ResponseEntity<>("Doctor Eliminado",HttpStatus.OK);
		}
		return new ResponseEntity<>("Doctor no encontrado",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/buscar/{IdDoctor}")
	public ResponseEntity<?>buscardoctor(@PathVariable Integer IdDoctor){
		DoctoresEntity doctorDb=doctoresservice.findById(IdDoctor);
		if(doctorDb!=null) {
			return new ResponseEntity<>(doctorDb,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("Doctor no encontrado",HttpStatus.NOT_FOUND);
		
	}
	

}
