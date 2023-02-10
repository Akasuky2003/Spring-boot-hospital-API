package idat.pe.Examen.Service;

import java.util.Collection;

import idat.pe.Examen.Entity.DoctoresEntity;

public interface DoctorService {
	public abstract void insert(DoctoresEntity doctor);
	public abstract void update(DoctoresEntity doctor);
	public abstract void delete(Integer IdDoctor);
	public abstract DoctoresEntity findById(Integer IdDoctor);
	public abstract Collection<DoctoresEntity>findAll();

}
