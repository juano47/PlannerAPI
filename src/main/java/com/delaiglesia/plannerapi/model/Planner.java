package com.delaiglesia.plannerapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Planner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plannerId;
	private String name;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	@OneToMany
	@JoinColumn(name = "itemId")
	private List<Item> item;
}
