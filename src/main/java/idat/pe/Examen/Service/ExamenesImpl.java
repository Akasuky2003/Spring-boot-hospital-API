package idat.pe.Examen.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.Examen.Entity.ExamenesEntity;
import idat.pe.Examen.Repository.ExamenesRepositorio;
@Service
public class ExamenesImpl implements ExamenesService {
	@Autowired
	private ExamenesRepositorio repositorio;

	@Override
	@Transactional
	public void insert(ExamenesEntity examenes) {
		repositorio.save(examenes);
	}

	@Override
	@Transactional
	public void update(ExamenesEntity examenes) {
		repositorio.save(examenes);
	}

	@Override
	@Transactional
	public void delete(Integer IdExamenMedico) {
		repositorio.deleteById(IdExamenMedico);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ExamenesEntity findById(Integer IdExamenMedico) {
		return repositorio.findById(IdExamenMedico).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ExamenesEntity> findAll() {
		return repositorio.findAll();
	}
	

}
