package idat.pe.Examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import idat.pe.Examen.Entity.PacienteEntity;

public interface PacienteRepositorio extends JpaRepository<PacienteEntity, Integer> {

}
