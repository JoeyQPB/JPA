package br.com.joey.domain;

import java.util.Objects;
import java.util.Set;

public class Computer {
	
	private Long id;
	private String code;
	private String description;
	private Set<Student> students;
	
	public Computer(Long id, String code, String description, Set<Student> students) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.students = students;
	}
	
	public Computer() {}

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
