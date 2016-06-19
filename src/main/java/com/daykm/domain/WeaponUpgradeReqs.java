package com.daykm.domain;

import javax.persistence.*;

@Entity
@Table(name="weapon_upgrade_requirements")
public class WeaponUpgradeReqs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne(fetch = FetchType.EAGER)
	private Material material;
	@Column(name="damage")
	private int quantity;
	
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
