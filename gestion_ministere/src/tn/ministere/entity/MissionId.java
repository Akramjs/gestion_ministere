package tn.ministere.entity;

// Generated 26 mai 2014 14:49:29 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MissionId generated by hbm2java
 */
@Embeddable
public class MissionId implements java.io.Serializable {

	private String numMission;
	private String codeOrg;

	public MissionId() {
	}

	public MissionId(String numMission, String codeOrg) {
		this.numMission = numMission;
		this.codeOrg = codeOrg;
	}

	@Column(name = "NUM_MISSION", nullable = false, length = 6)
	public String getNumMission() {
		return this.numMission;
	}

	public void setNumMission(String numMission) {
		this.numMission = numMission;
	}

	@Column(name = "CODE_ORG", nullable = false, length = 6)
	public String getCodeOrg() {
		return this.codeOrg;
	}

	public void setCodeOrg(String codeOrg) {
		this.codeOrg = codeOrg;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MissionId))
			return false;
		MissionId castOther = (MissionId) other;

		return ((this.getNumMission() == castOther.getNumMission()) || (this
				.getNumMission() != null && castOther.getNumMission() != null && this
				.getNumMission().equals(castOther.getNumMission())))
				&& ((this.getCodeOrg() == castOther.getCodeOrg()) || (this
						.getCodeOrg() != null && castOther.getCodeOrg() != null && this
						.getCodeOrg().equals(castOther.getCodeOrg())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNumMission() == null ? 0 : this.getNumMission()
						.hashCode());
		result = 37 * result
				+ (getCodeOrg() == null ? 0 : this.getCodeOrg().hashCode());
		return result;
	}

}
