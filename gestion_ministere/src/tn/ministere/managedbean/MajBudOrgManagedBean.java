package tn.ministere.managedbean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.AvoirBudOrgService;
import tn.ministere.dao.facade.OrganismeService;
import tn.ministere.dao.facade.ProjetService;
import tn.ministere.entity.AvoirBudorg;
import tn.ministere.entity.AvoirBudproj;
import tn.ministere.entity.Organisme;

@ManagedBean
@Component
public class MajBudOrgManagedBean {
	private AvoirBudproj selectedAvoirBudProj;
	private List<Organisme> listOrganismes;
	private Organisme selectedOrganisme;
	private double sum;
	private double newsum;
	private double majsum;

	private double sumT;
	private double newsumT;
	private double majsumT;
	private Date curDate = new Date();

	@Autowired
	private AvoirBudOrgService budOrgService;
	@Autowired
	private OrganismeService organismeService;
	@Autowired
	private ProjetService projetService;

	@PostConstruct
	public void init() {
		selectedOrganisme = new Organisme();
		listOrganismes = organismeService.findAll();
	}

	public void refresh() {
		majsum = majsumT = 0;
		sum = 0;
		for (AvoirBudorg a : selectedOrganisme.getAvoirBudorgs()) {
			sum += a.getValBudMis();
		}
		newsum = sum;

		sumT = 0;
		for (AvoirBudorg a : selectedOrganisme.getAvoirBudorgs()) {
			sumT += a.getValBudTrans();
		}
		newsumT = sumT;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budorganisme.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save() {
		if (selectedOrganisme.getAvoirBudorgs() != null
				&& selectedOrganisme.getAvoirBudorgs().size() > 0) {
			AvoirBudorg a = selectedOrganisme.getAvoirBudorgs().get(0);
			if (sum > newsum)
				a.setValBudMis(a.getValBudMis() - majsum);
			else
				a.setValBudMis(a.getValBudMis() + majsum);

			if (sumT > newsumT)
				a.setValBudTrans(a.getValBudTrans() - majsumT);
			else
				a.setValBudTrans(a.getValBudTrans() + majsumT);

			budOrgService.update(a);
			selectedOrganisme = organismeService.findById(selectedOrganisme
					.getCodeOrg());
		}

		sum = 0;
		for (AvoirBudorg a : selectedOrganisme.getAvoirBudorgs()) {
			sum += a.getValBudMis();
		}
		newsum = sum;
		majsum = 0;
		sumT = 0;
		for (AvoirBudorg a : selectedOrganisme.getAvoirBudorgs()) {
			sumT += a.getValBudTrans();
		}
		newsumT = sumT;
		majsumT = 0;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budorganisme.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMnt() {
		newsum = sum + majsum;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budorganisme.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeMnt() {
		newsum = sum - majsum;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budorganisme.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMntT() {
		newsumT = sumT + majsumT;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budorganisme.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeMntT() {
		newsumT = sumT - majsumT;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("maj_budorganisme.xhtml");
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

	public AvoirBudproj getSelectedAvoirBudProj() {
		return selectedAvoirBudProj;
	}

	public void setSelectedAvoirBudProj(AvoirBudproj selectedAvoirBudProj) {
		this.selectedAvoirBudProj = selectedAvoirBudProj;
	}

	public List<Organisme> getListOrganismes() {
		return organismeService.findAll();
	}

	public void setListOrganismes(List<Organisme> listOrganismes) {
		this.listOrganismes = listOrganismes;
	}

	public Organisme getSelectedOrganisme() {
		return selectedOrganisme;
	}

	public void setSelectedOrganisme(Organisme selectedOrganisme) {
		this.selectedOrganisme = selectedOrganisme;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
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

	public double getSumT() {
		return sumT;
	}

	public void setSumT(double sumT) {
		this.sumT = sumT;
	}

	public double getNewsumT() {
		return newsumT;
	}

	public void setNewsumT(double newsumT) {
		this.newsumT = newsumT;
	}

	public double getMajsumT() {
		return majsumT;
	}

	public void setMajsumT(double majsumT) {
		this.majsumT = majsumT;
	}

	public Date getCurDate() {
		return curDate;
	}

	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}

	public AvoirBudOrgService getBudOrgService() {
		return budOrgService;
	}

	public void setBudOrgService(AvoirBudOrgService budOrgService) {
		this.budOrgService = budOrgService;
	}

	public ProjetService getProjetService() {
		return projetService;
	}

	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

}
