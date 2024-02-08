package br.com.joey.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Student {
	
	private Long id;
	private String code;
	private String name;
	private Registration registration;
	private Set<Computer> computers;
	
	public Student(Long id, String code, String name, Registration registration) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.registration = registration;
		this.computers = new HashSet<>();
	}
	
	public Student() {}

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
