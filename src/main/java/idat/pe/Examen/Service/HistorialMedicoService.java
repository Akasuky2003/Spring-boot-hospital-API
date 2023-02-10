package idat.pe.Examen.Service;

import java.util.Collection;

import idat.pe.Examen.Entity.HistorialMedicoEntity;

public interface HistorialMedicoService {
	public abstract void insert(HistorialMedicoEntity historialmedico);
	public abstract void update(HistorialMedicoEntity historialmedico);
	public abstract void delete(Integer IdHistorialMedico);
	public abstract HistorialMedicoEntity findById(Integer IdHistorialMedico);
	public abstract Collection<HistorialMedicoEntity>findAll();

}
