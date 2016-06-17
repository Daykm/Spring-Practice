package com.daykm.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="weapon")
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
