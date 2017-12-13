package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.OrganismeService;
import tn.ministere.dao.facade.ProjetService;
import tn.ministere.entity.Organisme;
import tn.ministere.entity.Projet;

@ManagedBean
@Component
@URLMapping(id="projet",pattern="/edit_projets.xhtml",viewId="/edit/edit_projets.xhtml")

public class ProjetManagedBean {
	private List<Projet> listProjets;
	private Projet newProjet;
	private Projet selectedProjet;

	@Autowired
	private ProjetService projetService;
	@Autowired
	private OrganismeService organismeService;

	@PostConstruct
	public void init() {
		newProjet = new Projet();
		newProjet.setOrganisme(new Organisme());
		selectedProjet = new Projet();
		listProjets = projetService.findAll();
	}

	public void add() {
		System.out.println(newProjet.getOrganisme().getCodeOrg());
		newProjet.setOrganisme(organismeService.findById(newProjet.getOrganisme().getCodeOrg()));
		System.out.println(newProjet.getOrganisme().getCodeOrg());
		projetService.add(newProjet);
		newProjet = new Projet();
		newProjet.setOrganisme(new Organisme());
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("projets.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		projetService.delete(projetService.findById(selectedProjet
				.getCodeProj()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("projets.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_projets.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		projetService.update(selectedProjet);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("projets.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Projet> getListProjets() {
		return projetService.findAll();
	}

	public void setListProjets(List<Projet> listProjets) {
		this.listProjets = listProjets;
	}

	public ProjetService getProjetService() {
		return projetService;
	}

	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

	public Projet getNewProjet() {
		return newProjet;
	}

	public void setNewProjet(Projet newProjet) {
		this.newProjet = newProjet;
	}

	public Projet getSelectedProjet() {
		return selectedProjet;
	}

	public void setSelectedProjet(Projet selectedProjet) {
		this.selectedProjet = selectedProjet;
	}

	public OrganismeService getOrganismeService() {
		return organismeService;
	}

	public void setOrganismeService(OrganismeService organismeService) {
		this.organismeService = organismeService;
	}

}
