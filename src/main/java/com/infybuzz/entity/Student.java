package com.infybuzz.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node(labels = {"Student"})
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String country;

	@Property(name = "birth_year")
	private Integer birthYear;

	@Relationship(type = "belongs_to",direction = Relationship.Direction.OUTGOING)
	private Department department;

	@Relationship(type = "Learning",direction = Relationship.Direction.OUTGOING)
	private List<IsLearning> isLearningList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<IsLearning> getIsLearningList() {
		return isLearningList;
	}

	public void setIsLearningList(List<IsLearning> isLearningList) {
		this.isLearningList = isLearningList;
	}
}
