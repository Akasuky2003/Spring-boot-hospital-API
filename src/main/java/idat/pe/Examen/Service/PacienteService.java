package idat.pe.Examen.Service;

import java.util.Collection;

import idat.pe.Examen.Entity.PacienteEntity;

public interface PacienteService {
	public abstract void insert(PacienteEntity paciente);
	public abstract void update(PacienteEntity paciente);
	public abstract void delete(Integer IdPaciente);
	public abstract PacienteEntity findById(Integer IdPaciente);
	public abstract Collection<PacienteEntity>findAll();

}
