package tn.ministere.entity;

// Generated 26 mai 2014 14:49:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DateAvoirBudproj generated by hbm2java
 */
@Entity
@Table(name = "date_avoir_budproj", catalog = "ministere")
public class DateAvoirBudproj implements java.io.Serializable {

	private Date dateAvoirBudproj;
	private Set<AvoirBudproj> avoirBudprojs = new HashSet<AvoirBudproj>(0);

	public DateAvoirBudproj() {
	}

	public DateAvoirBudproj(Date dateAvoirBudproj) {
		this.dateAvoirBudproj = dateAvoirBudproj;
	}

	public DateAvoirBudproj(Date dateAvoirBudproj,
			Set<AvoirBudproj> avoirBudprojs) {
		this.dateAvoirBudproj = dateAvoirBudproj;
		this.avoirBudprojs = avoirBudprojs;
	}

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_AVOIR_BUDPROJ", unique = true, nullable = false, length = 10)
	public Date getDateAvoirBudproj() {
		return this.dateAvoirBudproj;
	}

	public void setDateAvoirBudproj(Date dateAvoirBudproj) {
		this.dateAvoirBudproj = dateAvoirBudproj;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dateAvoirBudproj")
	public Set<AvoirBudproj> getAvoirBudprojs() {
		return this.avoirBudprojs;
	}

	public void setAvoirBudprojs(Set<AvoirBudproj> avoirBudprojs) {
		this.avoirBudprojs = avoirBudprojs;
	}

}