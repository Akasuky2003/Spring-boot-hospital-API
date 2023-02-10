package idat.pe.Examen.Service;

import java.util.Collection;

import idat.pe.Examen.Entity.ExamenesEntity;

public interface ExamenesService {
	public abstract void insert(ExamenesEntity examenes);
	public abstract void update(ExamenesEntity examenes);
	public abstract void delete(Integer IdExamenMedico);
	public abstract ExamenesEntity findById(Integer IdExamenMedico);
	public abstract Collection<ExamenesEntity>findAll();

}
