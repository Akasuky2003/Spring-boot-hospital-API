package idat.pe.Examen.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.Examen.Entity.PacienteEntity;
import idat.pe.Examen.Repository.PacienteRepositorio;
@Service
public class PacienteImpl implements PacienteService {
	@Autowired
	private PacienteRepositorio repositorio;

	@Override
	@Transactional
	public void insert(PacienteEntity paciente) {
		repositorio.save(paciente);
		
	}

	@Override
	@Transactional
	public void update(PacienteEntity paciente) {
		repositorio.save(paciente);
		
	}

	@Override
	@Transactional
	public void delete(Integer IdPaciente) {
		repositorio.deleteById(IdPaciente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public PacienteEntity findById(Integer IdPaciente) {
		return repositorio.findById(IdPaciente).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<PacienteEntity> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	

}
