
package org.celllife.idart.database.hibernate;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity (name ="linhat")
public class LinhaT {
	
	@Id
	private int linhaid;
	private String linhanome;
	private boolean active;
	@OneToMany(mappedBy = "linhaT")
	@Cascade( { org.hibernate.annotations.CascadeType.ALL,
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	private Set<RegimeTerapeutico> regimes;
	
	public LinhaT(int linhaid, String linhanome, boolean active) {
		super();
		this.linhaid = linhaid;
		this.linhanome = linhanome;
		this.active = active;
	}

	public int getLinhaid() {
		return linhaid;
	}

	public void setLinhaid(int linhaid) {
		this.linhaid = linhaid;
	}

	public String getLinhanome() {
		return linhanome;
	}

	public void setLinhanome(String linhanome) {
		this.linhanome = linhanome;
	}

	public LinhaT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
