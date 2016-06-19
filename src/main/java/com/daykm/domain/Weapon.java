package com.daykm.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Weapon")
public class Weapon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="id")
	private Set<WeaponAttributes> attr;
	@Column(name="name")
	private String name;
	public Set<WeaponAttributes> getAttr() {
		return attr;
	}
	public void setAttr(Set<WeaponAttributes> attr) {
		this.attr = attr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
