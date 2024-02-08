package br.com.joey.domain;

import java.time.Instant;
import java.util.Objects;

public class Registration {

	private Long id;
	private String code;
	private Instant registrationDate;
	private Double price;
	private String status;
	private Course course;
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
