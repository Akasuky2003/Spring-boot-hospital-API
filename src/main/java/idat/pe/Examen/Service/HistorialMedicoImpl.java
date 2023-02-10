package idat.pe.Examen.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.Examen.Entity.HistorialMedicoEntity;
import idat.pe.Examen.Repository.HistorialMedicoRepositorio;
@Service
public class HistorialMedicoImpl implements HistorialMedicoService{
	@Autowired
	private HistorialMedicoRepositorio repositorio;
	

	@Override
	@Transactional
	public void insert(HistorialMedicoEntity historialmedico) {
		repositorio.save(historialmedico);
		
	}

	@Override
	@Transactional
	public void update(HistorialMedicoEntity historialmedico) {
		repositorio.save(historialmedico);
		
	}

	@Override
	@Transactional
	public void delete(Integer IdHistorialMedico) {
		repositorio.deleteById(IdHistorialMedico);
		
	}

	@Override
	@Transactional(readOnly = true)
	public HistorialMedicoEntity findById(Integer IdHistorialMedico) {
		return repositorio.findById(IdHistorialMedico).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<HistorialMedicoEntity> findAll() {
		return repositorio.findAll();
	}

}
