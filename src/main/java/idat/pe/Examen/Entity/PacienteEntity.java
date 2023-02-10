package idat.pe.Examen.Entity;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.lang.NonNull;
@Entity
@Table(name="Paciente")
public class PacienteEntity {
	//table
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPaciente;
	
	@Column(nullable = false)
	private String NombresP;
	
	@Column(nullable = false)
	private String ApellidoP;
	
	@NonNull
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fechanacimiento;
	
	@Column
	private Integer años;
	
	@Column(nullable = false)
	private String DNI;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "PacieneDoctor", 
        joinColumns = @JoinColumn(name = "paciente_id", referencedColumnName = "IdPaciente"), 
        inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "IdDoctor")
    )
    private List<DoctoresEntity> doctors;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<ExamenesEntity> examenes;
	
	

	//Contructor
	public PacienteEntity() {

	}
	
	public PacienteEntity(Integer idPaciente, String nombresP, String apellidoP, LocalDate fechanacimiento,
			Integer años, String dNI, List<DoctoresEntity> doctors, List<ExamenesEntity> examenes) {
		super();
		IdPaciente = idPaciente;
		NombresP = nombresP;
		ApellidoP = apellidoP;
		this.fechanacimiento = fechanacimiento;
		this.años = años;
		DNI = dNI;
		this.doctors = doctors;
		this.examenes = examenes;
	}

	//get set
	public Integer getIdPaciente() {
		return IdPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		IdPaciente = idPaciente;
	}
	public String getNombresP() {
		return NombresP;
	}
	public void setNombresP(String nombresP) {
		NombresP = nombresP;
	}
	public String getApellidoP() {
		return ApellidoP;
	}
	public void setApellidoP(String apellidoP) {
		ApellidoP = apellidoP;
	}
	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public Integer getAños() {
		return años;
	}
	public void setAños(Integer años) {
		this.años = años;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public List<DoctoresEntity> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<DoctoresEntity> doctors) {
		this.doctors = doctors;
	}
	public List<ExamenesEntity> getExamenes() {
		return examenes;
	}
	public void setExamenes(List<ExamenesEntity> examenes) {
		this.examenes = examenes;
	}
	
	

}
