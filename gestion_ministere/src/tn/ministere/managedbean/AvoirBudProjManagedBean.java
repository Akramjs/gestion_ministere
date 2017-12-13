package tn.ministere.managedbean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.AvoirBudProjService;
import tn.ministere.dao.facade.OrganismeService;
import tn.ministere.dao.facade.ProjetService;
import tn.ministere.entity.AvoirBudproj;
import tn.ministere.entity.AvoirBudprojId;
import tn.ministere.entity.DateAvoirBudproj;
import tn.ministere.entity.Projet;

@ManagedBean
@Component

public class AvoirBudProjManagedBean {
	private List<AvoirBudproj> listAvoirBudprojs;
	private AvoirBudproj newAvoirBudProj;
	private AvoirBudproj selectedAvoirBudProj;
	private List<Projet> listProjets;
	private Projet selectedProjet;
	private double sum;
	private Date curDate = new Date();

	@Autowired
	private AvoirBudProjService budProjService;
	@Autowired
	private OrganismeService organismeService;
	@Autowired
	private ProjetService projetService;

	@PostConstruct
	public void init() {
		newAvoirBudProj = new AvoirBudproj();
		newAvoirBudProj.setId(new AvoirBudprojId());
		listAvoirBudprojs = budProjService.findAll();
		listProjets = projetService.findAll();
		selectedProjet = new Projet();
	}

	public void refresh() {
		sum = 0;
		for (AvoirBudproj a : selectedProjet.getAvoirBudprojs()) {
			sum += a.getMontant();
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("avoirBudProj.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add() {
		DateAvoirBudproj d = new DateAvoirBudproj();
		d.setDateAvoirBudproj(curDate);
		try {
			budProjService.add(d);
		} catch (Exception e) {
			d = budProjService.findById(curDate);
		}
		newAvoirBudProj.setDateAvoirBudproj(d);
		newAvoirBudProj.getId().setDateAvoirBudproj(curDate);
		newAvoirBudProj.getId().setCodeUtil("I");
		newAvoirBudProj.setProjet(selectedProjet);
		newAvoirBudProj.getId().setCodeProj(selectedProjet.getCodeProj());
		budProjService.add(newAvoirBudProj);

		selectedProjet = projetService.findById(selectedProjet.getCodeProj());
		
		sum = 0;
		for (AvoirBudproj a : selectedProjet.getAvoirBudprojs()) {
			sum += a.getMontant();
		}
		
		newAvoirBudProj = new AvoirBudproj();
		newAvoirBudProj.setId(new AvoirBudprojId());
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("avoirBudProj.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		budProjService.delete(budProjService.findById(selectedAvoirBudProj
				.getId()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("avoirBudOrg.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OrganismeService getOrganismeService() {
		return organismeService;
	}

	public void setOrganismeService(OrganismeService organismeService) {
		this.organismeService = organismeService;
	}

	public List<AvoirBudproj> getListAvoirBudprojs() {
		return listAvoirBudprojs;
	}

	public void setListAvoirBudprojs(List<AvoirBudproj> listAvoirBudprojs) {
		this.listAvoirBudprojs = listAvoirBudprojs;
	}

	public AvoirBudproj getNewAvoirBudProj() {
		return newAvoirBudProj;
	}

	public void setNewAvoirBudProj(AvoirBudproj newAvoirBudProj) {
		this.newAvoirBudProj = newAvoirBudProj;
	}

	public AvoirBudproj getSelectedAvoirBudProj() {
		return selectedAvoirBudProj;
	}

	public void setSelectedAvoirBudProj(AvoirBudproj selectedAvoirBudProj) {
		this.selectedAvoirBudProj = selectedAvoirBudProj;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public AvoirBudProjService getBudProjService() {
		return budProjService;
	}

	public void setBudProjService(AvoirBudProjService budProjService) {
		this.budProjService = budProjService;
	}

	public ProjetService getProjetService() {
		return projetService;
	}

	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

	public List<Projet> getListProjets() {
		return projetService.findAll();
	}

	public void setListProjets(List<Projet> listProjets) {
		this.listProjets = listProjets;
	}

	public Projet getSelectedProjet() {
		return selectedProjet;
	}

	public void setSelectedProjet(Projet selectedProjet) {
		this.selectedProjet = selectedProjet;
	}

	public Date getCurDate() {
		return curDate;
	}

	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}

}
