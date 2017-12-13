package tn.ministere.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.FonctionService;
import tn.ministere.entity.Fonction;

@ManagedBean
@Component
@URLMapping(id="fonction",pattern="/edit_fonctions.xhtml",viewId="/edit/edit_fonctions.xhtml")
public class FonctionManagedBean implements Serializable{
	private List<Fonction> listFonctions;
	private Fonction newFonction;
	private Fonction selectedFonction;

	@Autowired
	private FonctionService fonctionService;

	@PostConstruct
	public void init() {
		newFonction = new Fonction();
		selectedFonction = new Fonction();
		listFonctions = fonctionService.findAll();
	}

	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_fonctions.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add() {
		System.out.println(newFonction.getCodeFonction());
		fonctionService.add(newFonction);
		newFonction = new Fonction();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("fonctions.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		System.out.println(selectedFonction.getArespValidationFonc());
		fonctionService.update(selectedFonction);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("fonctions.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		fonctionService.delete(fonctionService.findById(selectedFonction
				.getCodeFonction()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("fonctions.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Fonction> getListFonctions() {
		return fonctionService.findAll();
	}

	public void setListFonctions(List<Fonction> listFonctions) {
		this.listFonctions = listFonctions;
	}

	public FonctionService getFonctionService() {
		return fonctionService;
	}

	public void setFonctionService(FonctionService fonctionService) {
		this.fonctionService = fonctionService;
	}

	public Fonction getNewFonction() {
		return newFonction;
	}

	public void setNewFonction(Fonction newFonction) {
		this.newFonction = newFonction;
	}

	public Fonction getSelectedFonction() {
		return selectedFonction;
	}

	public void setSelectedFonction(Fonction selectedFonction) {
		this.selectedFonction = selectedFonction;
	}

}
