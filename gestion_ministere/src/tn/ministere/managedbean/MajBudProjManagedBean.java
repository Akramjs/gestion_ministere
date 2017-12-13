package tn.ministere.managedbean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.AvoirBudProjService;
import tn.ministere.dao.facade.OrganismeService;
import tn.ministere.dao.facade.ProjetService;
import tn.ministere.entity.AvoirBudproj;
import tn.ministere.entity.AvoirBudprojId;
import tn.ministere.entity.DateAvoirBudproj;
import tn.ministere.entity.Projet;

@ManagedBean
@Component
public class MajBudProjManagedBean {
	private List<AvoirBudproj> listAvoirBudprojs;
	private AvoirBudproj newAvoirBudProj;
	private AvoirBudproj selectedAvoirBudProj;
	private List<Projet> listProjets;
	private Projet selectedProjet;
	private double sum;
	private double newsum;
	private double majsum;
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
		newsum = sum;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budprojet.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save() {
		if (selectedProjet.getAvoirBudprojs() != null
				&& selectedProjet.getAvoirBudprojs().size() > 0) {
			AvoirBudproj a = selectedProjet.getAvoirBudprojs().get(0);
			if (sum > newsum)
				a.setMontant(a.getMontant() - majsum);
			else
				a.setMontant(a.getMontant() + majsum);

			budProjService.update(a);
			selectedProjet = projetService.findById(selectedProjet
					.getCodeProj());
		}

		sum = 0;
		for (AvoirBudproj a : selectedProjet.getAvoirBudprojs()) {
			sum += a.getMontant();
		}
		newsum = sum;
		majsum = 0;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budprojet.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMnt() {
		newsum = sum + majsum;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budprojet.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeMnt() {
		newsum = sum - majsum;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budprojet.xhtml");
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

	public double getNewsum() {
		return newsum;
	}

	public void setNewsum(double newsum) {
		this.newsum = newsum;
	}

	public double getMajsum() {
		return majsum;
	}

	public void setMajsum(double majsum) {
		this.majsum = majsum;
	}

}
