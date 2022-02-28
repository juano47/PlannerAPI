package com.delaiglesia.plannerapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Setter @Getter @NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="userId")
@DiscriminatorValue("professor")
public class Professor extends User{
	private String subject;

	public Professor(String name, String username, String email, String password, List<Planner> planner, String subject) {
		super(name, username, email, password, planner);
		this.subject = subject;
	}
}
