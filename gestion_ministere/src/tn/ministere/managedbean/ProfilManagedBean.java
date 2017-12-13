package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.ProfilService;
import tn.ministere.entity.Profil;



@ManagedBean
@Component
public class ProfilManagedBean {
	private List<Profil> listProfils;

	private Profil newProfil;
	private Profil selectedProfil;
	@Autowired
	private ProfilService ProfilService;
	
	@PostConstruct
	public void init() {
		newProfil = new Profil();
		
		selectedProfil = new Profil();
		listProfils = ProfilService.findAll();
	}
	public void add() {
		System.out.println(newProfil.getCodeProfil());
		ProfilService.add(newProfil);
		newProfil = new Profil();
		
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Profil.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete() {
		ProfilService.delete(ProfilService
				.findById(selectedProfil.getCodeProfil()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("utilisateurs.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Profil> getListProfils() {
		return listProfils;
	}
	public void setListProfils(List<Profil> listProfils) {
		this.listProfils = listProfils;
	}
	public Profil getNewProfil() {
		return newProfil;
	}
	public void setNewProfil(Profil newProfil) {
		this.newProfil = newProfil;
	}
	public Profil getSelectedProfil() {
		return selectedProfil;
	}
	public void setSelectedProfil(Profil selectedProfil) {
		this.selectedProfil = selectedProfil;
	}
	
}
