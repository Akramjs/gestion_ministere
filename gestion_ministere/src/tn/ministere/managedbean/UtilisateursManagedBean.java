package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.UtilisateurService;
import tn.ministere.entity.Profil;
import tn.ministere.entity.Utilisateur;

@ManagedBean
@Component
@URLMapping(id="utilisateurs",pattern="/edit_utilisateurs.xhtml",viewId="/edit/edit_utilisateurs.xhtml")

public class UtilisateursManagedBean {
	private List<Utilisateur> listUtilisateurs;
	private List<Profil> listProfils;
	private Utilisateur newUtilisateur;
	private Utilisateur selectedUtilisateur;

	@Autowired
	private UtilisateurService utilisateurService;

	@PostConstruct
	public void init() {
		newUtilisateur = new Utilisateur();
		newUtilisateur.setProfil(new Profil());
		selectedUtilisateur = new Utilisateur();
		listUtilisateurs = utilisateurService.findAll();
	}

	public void add() {
		newUtilisateur.setProfil(utilisateurService
				.findProfilById(newUtilisateur.getProfil().getCodeProfil()));
		utilisateurService.add(newUtilisateur);
		newUtilisateur = new Utilisateur();
		newUtilisateur.setProfil(new Profil());
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("utilisateurs.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_utilisateurs.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		utilisateurService.update(selectedUtilisateur);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("utilisateurs.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void delete() {
		utilisateurService.delete(utilisateurService
				.findById(selectedUtilisateur.getCinUtilisateur()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("utilisateurs.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Utilisateur> getListUtilisateurs() {
		return utilisateurService.findAll();
	}

	public void setListUtilisateurs(List<Utilisateur> listUtilisateurs) {
		this.listUtilisateurs = listUtilisateurs;
	}

	public Utilisateur getNewUtilisateur() {
		return newUtilisateur;
	}

	public void setNewUtilisateur(Utilisateur newUtilisateur) {
		this.newUtilisateur = newUtilisateur;
	}

	public Utilisateur getSelectedUtilisateur() {
		return selectedUtilisateur;
	}

	public void setSelectedUtilisateur(Utilisateur selectedUtilisateur) {
		this.selectedUtilisateur = selectedUtilisateur;
	}

	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public List<Profil> getListProfils() {
		return utilisateurService.findAllProfil();
	}

	public void setListProfils(List<Profil> listProfils) {
		this.listProfils = listProfils;
	}

}
