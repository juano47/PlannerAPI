package com.delaiglesia.plannerapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="userId")
@DiscriminatorValue("student")
public class Student extends User {
	private int studentNumber;

	public Student(String name, String username, String email, String password, List<Planner> planner, int studentNumber) {
		super(name, username, email, password, planner);
		this.studentNumber = studentNumber;
	}
}
