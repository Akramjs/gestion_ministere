package tn.ministere.entity;

// Generated 26 mai 2014 14:49:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mission generated by hbm2java
 */
@Entity
@Table(name = "mission", catalog = "ministere")
public class Mission implements java.io.Serializable {

	private MissionId id;
	private Organisme organisme;
	private Theme theme;
	private String objetMission;
	private String aobjetMission;
	private Date dateDepProvMission;
	private Date dateArrProvMission;

	public Mission() {
	}

	public Mission(MissionId id, Organisme organisme, Theme theme) {
		this.id = id;
		this.organisme = organisme;
		this.theme = theme;
	}

	public Mission(MissionId id, Organisme organisme, Theme theme,
			String objetMission, String aobjetMission, Date dateDepProvMission,
			Date dateArrProvMission) {
		this.id = id;
		this.organisme = organisme;
		this.theme = theme;
		this.objetMission = objetMission;
		this.aobjetMission = aobjetMission;
		this.dateDepProvMission = dateDepProvMission;
		this.dateArrProvMission = dateArrProvMission;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numMission", column = @Column(name = "NUM_MISSION", nullable = false, length = 6)),
			@AttributeOverride(name = "codeOrg", column = @Column(name = "CODE_ORG", nullable = false, length = 6)) })
	public MissionId getId() {
		return this.id;
	}

	public void setId(MissionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_ORG", nullable = false, insertable = false, updatable = false)
	public Organisme getOrganisme() {
		return this.organisme;
	}

	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_THEME", nullable = false)
	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Column(name = "OBJET_MISSION", length = 60)
	public String getObjetMission() {
		return this.objetMission;
	}

	public void setObjetMission(String objetMission) {
		this.objetMission = objetMission;
	}

	@Column(name = "AOBJET_MISSION", length = 120)
	public String getAobjetMission() {
		return this.aobjetMission;
	}

	public void setAobjetMission(String aobjetMission) {
		this.aobjetMission = aobjetMission;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DEP_PROV_MISSION", length = 10)
	public Date getDateDepProvMission() {
		return this.dateDepProvMission;
	}

	public void setDateDepProvMission(Date dateDepProvMission) {
		this.dateDepProvMission = dateDepProvMission;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ARR_PROV_MISSION", length = 10)
	public Date getDateArrProvMission() {
		return this.dateArrProvMission;
	}

	public void setDateArrProvMission(Date dateArrProvMission) {
		this.dateArrProvMission = dateArrProvMission;
	}

}