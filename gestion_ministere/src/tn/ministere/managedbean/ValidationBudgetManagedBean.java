package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.AvoirBudOrgService;
import tn.ministere.dao.facade.AvoirBudProjService;
import tn.ministere.entity.AvoirBudorg;
import tn.ministere.entity.AvoirBudproj;

@ManagedBean
@Component
public class ValidationBudgetManagedBean {
	private List<AvoirBudorg> listAvoirBudorgs;
	private AvoirBudorg selectedAvoirBudorg;
	private List<AvoirBudproj> listAvoirBudprojs;
	private AvoirBudproj selectedAvoirBudProj;

	@Autowired
	private AvoirBudProjService budProjService;
	@Autowired
	private AvoirBudOrgService budOrgService;

	public void accept() {
		budOrgService.delete(selectedAvoirBudorg);
		selectedAvoirBudorg.getId().setCodeUtil("V");
		budOrgService.add(selectedAvoirBudorg);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("validation_budget.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reject() {
		budOrgService.delete(selectedAvoirBudorg);
		selectedAvoirBudorg.getId().setCodeUtil("R");
		budOrgService.add(selectedAvoirBudorg);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("validation_budget.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void acceptP() {
		budProjService.delete(selectedAvoirBudProj);
		selectedAvoirBudProj.getId().setCodeUtil("V");
		budProjService.add(selectedAvoirBudProj);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("validation_budget.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void rejectP() {
		budProjService.delete(selectedAvoirBudProj);
		selectedAvoirBudProj.getId().setCodeUtil("R");
		budProjService.add(selectedAvoirBudProj);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("validation_budget.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		listAvoirBudorgs = budOrgService.findAllNotValidated();
		listAvoirBudprojs = budProjService.findAllNotValidated();
	}

	public List<AvoirBudorg> getListAvoirBudorgs() {
		return listAvoirBudorgs = budOrgService.findAllNotValidated();
	}

	public void setListAvoirBudorgs(List<AvoirBudorg> listAvoirBudorgs) {
		this.listAvoirBudorgs = listAvoirBudorgs;
	}

	public AvoirBudorg getSelectedAvoirBudorg() {
		return selectedAvoirBudorg;
	}

	public void setSelectedAvoirBudorg(AvoirBudorg selectedAvoirBudorg) {
		this.selectedAvoirBudorg = selectedAvoirBudorg;
	}

	public List<AvoirBudproj> getListAvoirBudprojs() {
		return budProjService.findAllNotValidated();
	}

	public void setListAvoirBudprojs(List<AvoirBudproj> listAvoirBudprojs) {
		this.listAvoirBudprojs = listAvoirBudprojs;
	}

	public AvoirBudproj getSelectedAvoirBudProj() {
		return selectedAvoirBudProj;
	}

	public void setSelectedAvoirBudProj(AvoirBudproj selectedAvoirBudProj) {
		this.selectedAvoirBudProj = selectedAvoirBudProj;
	}

	public AvoirBudProjService getBudProjService() {
		return budProjService;
	}

	public void setBudProjService(AvoirBudProjService budProjService) {
		this.budProjService = budProjService;
	}

	public AvoirBudOrgService getBudOrgService() {
		return budOrgService;
	}

	public void setBudOrgService(AvoirBudOrgService budOrgService) {
		this.budOrgService = budOrgService;
	}

}
