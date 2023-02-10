package idat.pe.Examen.Service;

import java.util.Collection;

import idat.pe.Examen.Entity.CitasEntity;



public interface CitasService {
	public abstract void insert(CitasEntity citas);
	public abstract void update(CitasEntity citas);
	public abstract void delete(Integer IdCita);
	public abstract CitasEntity findById(Integer IdCita);
	public abstract Collection<CitasEntity>findAll();

}
