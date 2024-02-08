package br.com.joey.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "sq_student", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne(mappedBy = "student")
	private Registration registration;
	
	@ManyToMany( cascade = {CascadeType.ALL})
	@JoinTable(
			name = "tb_student_computer",
			joinColumns = {@JoinColumn(name = "id_student_fk")},
			inverseJoinColumns = {@JoinColumn(name = "id_computer_fk")}
			)
	private Set<Computer> computers;
	
	public Student(Long id, String code, String name, Registration registration) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.registration = registration;
		this.computers = new HashSet<>();
	}
	
	public Student() {
		this.computers = new HashSet<>();
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Set<Computer> getComputers() {
		return computers;
	}

	public void setComputers(Set<Computer> computers) {
		this.computers = computers;
	};
	
	public void addComputer(Computer computer) {
		this.computers.add(computer);
	}
	
	public void removeComputer(Computer computer) {
		this.computers.remove(computer);
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
		Student other = (Student) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", code=" + code + ", name=" + name + ", registration=" + registration
				+ ", computers=" + computers.toString() + "]";
	}
}
