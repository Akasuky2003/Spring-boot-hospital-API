package idat.pe.Examen.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.Examen.Entity.CitasEntity;
import idat.pe.Examen.Repository.CitasRepositorio;
@Service
public class CitasImpl implements CitasService {
	@Autowired
	private CitasRepositorio repositorio;

	@Override
	@Transactional
	public void insert(CitasEntity citas) {
		repositorio.save(citas);
		
	}

	@Override
	@Transactional
	public void update(CitasEntity citas) {
		repositorio.save(citas);
		
	}

	@Override
	@Transactional
	public void delete(Integer IdCita) {
		repositorio.deleteById(IdCita);
		
	}

	@Override
	@Transactional(readOnly = true)
	public CitasEntity findById(Integer IdCita) {
		return repositorio.findById(IdCita).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CitasEntity> findAll() {
		return repositorio.findAll();
	}

}
