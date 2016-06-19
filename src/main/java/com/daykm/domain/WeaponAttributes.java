package com.daykm.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="weapon_attributes")
public class WeaponAttributes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="damage")
	private int damage;
	@Column(name="magic_damage")
	private int magicDamage;
	@Column(name="weight")
	private int weight;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
	private Set<WeaponUpgradeReqs> reqs;
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getMagicDamage() {
		return magicDamage;
	}
	public void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Set<WeaponUpgradeReqs> getReqs() {
		return reqs;
	}
	public void setReqs(Set<WeaponUpgradeReqs> reqs) {
		this.reqs = reqs;
	}
	
	
}
