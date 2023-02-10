package idat.pe.Examen.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Doctor")
public class DoctoresEntity {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdDoctor;
	
	@Column(nullable = false)
	private String nombresM;
	
	@Column(nullable = false)
	private String apellidosM;
	
	@Column(nullable = false)
	private String especialidadM;
	
	@Column(nullable = false)
	private String DNI;

	//contrustor
	public DoctoresEntity() {
	}

	public DoctoresEntity(Integer idDoctor, String nombresM, String apellidosM, String especialidadM, String dNI) {
		super();
		IdDoctor = idDoctor;
		this.nombresM = nombresM;
		this.apellidosM = apellidosM;
		this.especialidadM = especialidadM;
		DNI = dNI;
	}
	//GET SET

	public Integer getIdDoctor() {
		return IdDoctor;
	}

	public void setIdDoctor(Integer idDoctor) {
		IdDoctor = idDoctor;
	}

	public String getNombresM() {
		return nombresM;
	}

	public void setNombresM(String nombresM) {
		this.nombresM = nombresM;
	}

	public String getApellidosM() {
		return apellidosM;
	}

	public void setApellidosM(String apellidosM) {
		this.apellidosM = apellidosM;
	}

	public String getEspecialidadM() {
		return especialidadM;
	}

	public void setEspecialidadM(String especialidadM) {
		this.especialidadM = especialidadM;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	
	

}
