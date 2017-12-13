package tn.ministere.entity;

// Generated 26 mai 2014 14:49:29 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Fonction generated by hbm2java
 */
@Entity
@Table(name = "fonction", catalog = "ministere")
public class Fonction implements java.io.Serializable {

	private String codeFonction;
	private Organisme organisme;
	private String libelleFonction;
	private String alibelleFonction;
	private String respValidationFonc;
	private String arespValidationFonc;
	private Set<Missionnaire> missionnaires = new HashSet<Missionnaire>(0);

	public Fonction() {
	}

	public Fonction(String codeFonction) {
		this.codeFonction = codeFonction;
	}

	public Fonction(String codeFonction, Organisme organisme,
			String libelleFonction, String alibelleFonction,
			String respValidationFonc, String arespValidationFonc,
			Set<Missionnaire> missionnaires) {
		this.codeFonction = codeFonction;
		this.organisme = organisme;
		this.libelleFonction = libelleFonction;
		this.alibelleFonction = alibelleFonction;
		this.respValidationFonc = respValidationFonc;
		this.arespValidationFonc = arespValidationFonc;
		this.missionnaires = missionnaires;
	}

	@Id
	@Column(name = "CODE_FONCTION", unique = true, nullable = false, length = 2)
	public String getCodeFonction() {
		return this.codeFonction;
	}

	public void setCodeFonction(String codeFonction) {
		this.codeFonction = codeFonction;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_ORG")
	public Organisme getOrganisme() {
		return this.organisme;
	}

	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

	@Column(name = "LIBELLE_FONCTION", length = 60)
	public String getLibelleFonction() {
		return this.libelleFonction;
	}

	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}

	@Column(name = "ALIBELLE_FONCTION", length = 120)
	public String getAlibelleFonction() {
		return this.alibelleFonction;
	}

	public void setAlibelleFonction(String alibelleFonction) {
		this.alibelleFonction = alibelleFonction;
	}

	@Column(name = "RESP_VALIDATION_FONC", length = 40)
	public String getRespValidationFonc() {
		return this.respValidationFonc;
	}

	public void setRespValidationFonc(String respValidationFonc) {
		this.respValidationFonc = respValidationFonc;
	}

	@Column(name = "ARESP_VALIDATION_FONC", length = 80)
	public String getArespValidationFonc() {
		return this.arespValidationFonc;
	}

	public void setArespValidationFonc(String arespValidationFonc) {
		this.arespValidationFonc = arespValidationFonc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fonction")
	public Set<Missionnaire> getMissionnaires() {
		return this.missionnaires;
	}

	public void setMissionnaires(Set<Missionnaire> missionnaires) {
		this.missionnaires = missionnaires;
	}

}