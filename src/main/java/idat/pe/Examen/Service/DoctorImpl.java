package idat.pe.Examen.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.Examen.Entity.DoctoresEntity;
import idat.pe.Examen.Repository.DoctoresRepositorio;
@Service
public class DoctorImpl implements DoctorService{
	
	@Autowired
	private DoctoresRepositorio repositorio;

	@Override
	@Transactional
	public void insert(DoctoresEntity doctor) {
		repositorio.save(doctor);
	}

	@Override
	@Transactional
	public void update(DoctoresEntity doctor) {
		repositorio.save(doctor);
		
	}

	@Override
	@Transactional
	public void delete(Integer IdDoctor) {
		repositorio.deleteById(IdDoctor);
		
	}

	@Override
	@Transactional(readOnly = true)
	public DoctoresEntity findById(Integer IdDoctor) {
		return repositorio.findById(IdDoctor).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<DoctoresEntity> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}
