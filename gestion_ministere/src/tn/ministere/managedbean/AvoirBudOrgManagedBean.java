package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.AnneeService;
import tn.ministere.dao.facade.AvoirBudOrgService;
import tn.ministere.dao.facade.OrganismeService;
import tn.ministere.entity.Annee;
import tn.ministere.entity.AvoirBudorg;
import tn.ministere.entity.AvoirBudorgId;
import tn.ministere.entity.Organisme;

@ManagedBean
@Component
@URLMapping(id = "budjets", pattern = "/edit_avoirBudOrg.xhtml", viewId = "/edit/edit_avoirBudOrg.xhtml")
public class AvoirBudOrgManagedBean {
	private List<AvoirBudorg> listAvoirBudorgs;
	private AvoirBudorg newAvoirBudorg;
	private AvoirBudorg selectedAvoirBudorg;
	private List<Organisme> listOrganismes;
	private List<Annee> listAnnees;
	private double sumMission;
	private double sumTransport;

	@Autowired
	private AvoirBudOrgService budOrgService;
	@Autowired
	private OrganismeService organismeService;
	@Autowired
	private AnneeService anneeService;

	@PostConstruct
	public void init() {
		newAvoirBudorg = new AvoirBudorg();
		newAvoirBudorg.setId(new AvoirBudorgId());
		newAvoirBudorg.setOrganisme(new Organisme());
		selectedAvoirBudorg = new AvoirBudorg();
		listAvoirBudorgs = budOrgService.findAll();
		listOrganismes = organismeService.findAll();
		listAnnees = anneeService.findAll();
		for (AvoirBudorg a : listAvoirBudorgs) {
			sumTransport += a.getValBudTrans();
			sumMission += a.getValBudMis();
		}
	}

	public void add() {
		System.out.println(newAvoirBudorg.getOrganisme().getCodeOrg());
		newAvoirBudorg.getId().setCodeUtil("I");
		newAvoirBudorg.setOrganisme(organismeService.findById(newAvoirBudorg
				.getOrganisme().getCodeOrg()));
		newAvoirBudorg.getId().setCodeOrg(
				newAvoirBudorg.getOrganisme().getCodeOrg());
		System.out.println(newAvoirBudorg.getOrganisme().getCodeOrg());
		budOrgService.add(newAvoirBudorg);
		newAvoirBudorg = new AvoirBudorg();
		newAvoirBudorg.setId(new AvoirBudorgId());
		newAvoirBudorg.setOrganisme(new Organisme());
		sumTransport = sumMission = 0;
		for (AvoirBudorg a : getListAvoirBudorgs()) {
			sumTransport += a.getValBudTrans();
			sumMission += a.getValBudMis();
		}

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("avoirBudOrg.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		System.out.println(selectedAvoirBudorg.getId());
		budOrgService
				.delete(budOrgService.findById(selectedAvoirBudorg.getId()));
		sumTransport = sumMission = 0;
		for (AvoirBudorg a : getListAvoirBudorgs()) {
			sumTransport += a.getValBudTrans();
			sumMission += a.getValBudMis();
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("avoirBudOrg.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_avoirBudOrg.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {

		budOrgService.update(selectedAvoirBudorg);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("grades.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<AvoirBudorg> getListAvoirBudorgs() {
		return budOrgService.findAll();
	}

	public void setListAvoirBudorgs(List<AvoirBudorg> listAvoirBudorgs) {
		this.listAvoirBudorgs = listAvoirBudorgs;
	}

	public AvoirBudorg getNewAvoirBudorg() {
		return newAvoirBudorg;
	}

	public void setNewAvoirBudorg(AvoirBudorg newAvoirBudorg) {
		this.newAvoirBudorg = newAvoirBudorg;
	}

	public AvoirBudorg getSelectedAvoirBudorg() {
		return selectedAvoirBudorg;
	}

	public void setSelectedAvoirBudorg(AvoirBudorg selectedAvoirBudorg) {
		this.selectedAvoirBudorg = selectedAvoirBudorg;
	}

	public AvoirBudOrgService getBudOrgService() {
		return budOrgService;
	}

	public void setBudOrgService(AvoirBudOrgService budOrgService) {
		this.budOrgService = budOrgService;
	}

	public List<Organisme> getListOrganismes() {
		return listOrganismes;
	}

	public void setListOrganismes(List<Organisme> listOrganismes) {
		this.listOrganismes = listOrganismes;
	}

	public OrganismeService getOrganismeService() {
		return organismeService;
	}

	public void setOrganismeService(OrganismeService organismeService) {
		this.organismeService = organismeService;
	}

	public List<Annee> getListAnnees() {
		return listAnnees;
	}

	public void setListAnnees(List<Annee> listAnnees) {
		this.listAnnees = listAnnees;
	}

	public AnneeService getAnneeService() {
		return anneeService;
	}

	public void setAnneeService(AnneeService anneeService) {
		this.anneeService = anneeService;
	}

	public double getSumMission() {
		return sumMission;
	}

	public void setSumMission(double sumMission) {
		this.sumMission = sumMission;
	}

	public double getSumTransport() {
		return sumTransport;
	}

	public void setSumTransport(double sumTransport) {
		this.sumTransport = sumTransport;
	}

}
