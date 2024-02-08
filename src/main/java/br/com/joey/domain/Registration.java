package br.com.joey.domain;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_registration")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_seq")
	@SequenceGenerator(name = "registration_seq", sequenceName = "sq_registration", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "registrationDate", nullable = false)
	private Instant registrationDate;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_course_fk",
				foreignKey = @ForeignKey(name = "fk_course_registration"),
				referencedColumnName = "id", nullable = false)
	private Course course;
	
	@OneToOne
	@JoinColumn(name = "id_student_fk",
				foreignKey = @ForeignKey(name = "fk_student_registration"),
				referencedColumnName = "id", nullable = false)
	private Student student;
	
	public Registration(Long id, String code, Instant registrationDate, Double price, String status, Course course, Student student) {
		this.id = id;
		this.code = code;
		this.registrationDate = registrationDate;
		this.price = price;
		this.status = status;
		this.course = course;
		this.student = student;
	}
	
	public Registration() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Instant getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Instant registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", code=" + code + ", registrationDate=" + registrationDate + ", price="
				+ price + ", status=" + status + ", course=" + course + ", student=" + student + "]";
	}
	
}
