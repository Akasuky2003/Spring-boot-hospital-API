package idat.pe.Examen.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.lang.NonNull;
@Entity
@Table(name="ExamenMedico")
public class ExamenesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdExamenMedico;
	@ManyToOne
	@JoinColumn(name = "IdPaciente")
	private PacienteEntity paciente;
	
	@Column(nullable = false)
	private String Resultado;
	
	@Column(nullable = false)
	private String Descripcion;
	
	@NonNull
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechadeRealizacion;
	@PrePersist
	public void prePersist() {
		fechadeRealizacion=LocalDate.now();
	}

	public ExamenesEntity() {
	}

	public ExamenesEntity(Integer idExamenMedico, PacienteEntity paciente, String resultado, String descripcion,
			LocalDate fechadeRealizacion) {
		super();
		IdExamenMedico = idExamenMedico;
		this.paciente = paciente;
		Resultado = resultado;
		Descripcion = descripcion;
		this.fechadeRealizacion = fechadeRealizacion;
	}

	public Integer getIdExamenMedico() {
		return IdExamenMedico;
	}

	public void setIdExamenMedico(Integer idExamenMedico) {
		IdExamenMedico = idExamenMedico;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public String getResultado() {
		return Resultado;
	}

	public void setResultado(String resultado) {
		Resultado = resultado;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public LocalDate getFechadeRealizacion() {
		return fechadeRealizacion;
	}

	public void setFechadeRealizacion(LocalDate fechadeRealizacion) {
		this.fechadeRealizacion = fechadeRealizacion;
	}
	
	
}
