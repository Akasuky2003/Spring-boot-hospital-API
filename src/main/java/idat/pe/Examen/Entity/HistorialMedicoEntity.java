package idat.pe.Examen.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name="HistorialMedico")
public class HistorialMedicoEntity {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdHistorialMedico;
	@Column
	private String DiagnosticoAnterior;
	@Column
	private String ResetaMedicaAnterior;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaDiagnostico;
	
	@ManyToOne
	@JoinColumn(name = "IdPaciente")
	private PacienteEntity paciente;
	

	public HistorialMedicoEntity() {
	}
	public HistorialMedicoEntity(Integer idHistorialMedico, String diagnosticoAnterior, String resetaMedicaAnterior,
			LocalDate fechaDiagnostico, PacienteEntity paciente) {
		super();
		IdHistorialMedico = idHistorialMedico;
		DiagnosticoAnterior = diagnosticoAnterior;
		ResetaMedicaAnterior = resetaMedicaAnterior;
		this.fechaDiagnostico = fechaDiagnostico;
		this.paciente = paciente;
	}
	public PacienteEntity getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public Integer getIdHistorialMedico() {
		return IdHistorialMedico;
	}

	public void setIdHistorialMedico(Integer idHistorialMedico) {
		IdHistorialMedico = idHistorialMedico;
	}

	public String getDiagnosticoAnterior() {
		return DiagnosticoAnterior;
	}

	public void setDiagnosticoAnterior(String diagnosticoAnterior) {
		DiagnosticoAnterior = diagnosticoAnterior;
	}

	public String getResetaMedicaAnterior() {
		return ResetaMedicaAnterior;
	}

	public void setResetaMedicaAnterior(String resetaMedicaAnterior) {
		ResetaMedicaAnterior = resetaMedicaAnterior;
	}

	public LocalDate getFechaDiagnostico() {
		return fechaDiagnostico;
	}

	public void setFechaDiagnostico(LocalDate fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}
	
	

}
