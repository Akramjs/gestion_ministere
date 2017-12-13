package tn.ministere.entity;

// Generated 26 mai 2014 14:49:29 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VilleDestination generated by hbm2java
 */
@Entity
@Table(name = "ville_destination", catalog = "ministere")
public class VilleDestination implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -706882206254953134L;
	private String codeVilleDestination;
	private PaysDestination paysDestination;
	private String libelleVilleDestination;
	private String alibelleVilleDestination;

	public VilleDestination() {
	}

	public VilleDestination(String codeVilleDestination,
			PaysDestination paysDestination) {
		this.codeVilleDestination = codeVilleDestination;
		this.paysDestination = paysDestination;
	}

	public VilleDestination(String codeVilleDestination,
			PaysDestination paysDestination, String libelleVilleDestination,
			String alibelleVilleDestination) {
		this.codeVilleDestination = codeVilleDestination;
		this.paysDestination = paysDestination;
		this.libelleVilleDestination = libelleVilleDestination;
		this.alibelleVilleDestination = alibelleVilleDestination;
	}

	@Id
	@Column(name = "CODE_VILLE_DESTINATION", unique = true, nullable = false, length = 2)
	public String getCodeVilleDestination() {
		return this.codeVilleDestination;
	}

	public void setCodeVilleDestination(String codeVilleDestination) {
		this.codeVilleDestination = codeVilleDestination;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_PAYS_DES", nullable = false)
	public PaysDestination getPaysDestination() {
		return this.paysDestination;
	}

	public void setPaysDestination(PaysDestination paysDestination) {
		this.paysDestination = paysDestination;
	}

	@Column(name = "LIBELLE_VILLE_DESTINATION", length = 15)
	public String getLibelleVilleDestination() {
		return this.libelleVilleDestination;
	}

	public void setLibelleVilleDestination(String libelleVilleDestination) {
		this.libelleVilleDestination = libelleVilleDestination;
	}

	@Column(name = "ALIBELLE_VILLE_DESTINATION", length = 30)
	public String getAlibelleVilleDestination() {
		return this.alibelleVilleDestination;
	}

	public void setAlibelleVilleDestination(String alibelleVilleDestination) {
		this.alibelleVilleDestination = alibelleVilleDestination;
	}

}
