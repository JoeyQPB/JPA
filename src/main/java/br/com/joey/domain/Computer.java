package br.com.joey.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.joey.interfaces.IPersistence;

@Entity
@Table(name = "tb_computer")
public class Computer implements IPersistence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computer_seq")
	@SequenceGenerator(name = "computer_seq", sequenceName = "sq_computer", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToMany(mappedBy = "computers")
	private Set<Student> students;
	
	public Computer(Long id, String code, String description) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.students = new HashSet<>();
	}
	
	public Computer() {
		this.students = new HashSet<>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	};
	
	public void addStudents(Student student) {
		students.add(student);
	}
	public void removeStudents(Student student) {
		students.remove(student);
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
		Computer other = (Computer) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", code=" + code + ", description=" + description + ", students=" + students
				+ "]";
	}
}
