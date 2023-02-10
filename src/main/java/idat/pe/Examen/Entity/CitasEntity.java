package idat.pe.Examen.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Entity
@Table(name="Citas")
public class CitasEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdCita;
	@ManyToOne
	@JoinColumn(name = "IdDoctor")
	private DoctoresEntity doctor;

	@ManyToOne
	@JoinColumn(name = "IdPaciente")
	private PacienteEntity paciente;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaCita;
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horaCita;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechaCreacionCita;

	@PrePersist
	public void prePersist() {
		fechaCreacionCita=LocalDate.now();
	}
	
	public CitasEntity() {

	}

	public CitasEntity(Integer idCita, DoctoresEntity doctor, PacienteEntity paciente, LocalDate fechaCita,
			LocalTime horaCita, LocalDate fechaCreacionCita) {
		super();
		IdCita = idCita;
		this.doctor = doctor;
		this.paciente = paciente;
		this.fechaCita = fechaCita;
		this.horaCita = horaCita;
		this.fechaCreacionCita = fechaCreacionCita;
	}

	public Integer getIdCita() {
		return IdCita;
	}

	public void setIdCita(Integer idCita) {
		IdCita = idCita;
	}

	public DoctoresEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctoresEntity doctor) {
		this.doctor = doctor;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public LocalDate getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}

	public LocalTime getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(LocalTime horaCita) {
		this.horaCita = horaCita;
	}

	public LocalDate getFechaCreacionCita() {
		return fechaCreacionCita;
	}

	public void setFechaCreacionCita(LocalDate fechaCreacionCita) {
		this.fechaCreacionCita = fechaCreacionCita;
	}
	
	

}
