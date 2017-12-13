package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.CategorieService;
import tn.ministere.entity.Categorie;

@ManagedBean
@Component
@URLMapping(id="categorie",pattern="/edit_categorie.xhtml",viewId="/edit/edit_categorie.xhtml")

public class CategorieManagedBean {
	private List<Categorie> listCategories;
	private Categorie newCategorie;
	private Categorie selectedCategorie;

	@Autowired
	private CategorieService categorieService;

	@PostConstruct
	public void init() {
		newCategorie = new Categorie();
		selectedCategorie = new Categorie();
		listCategories = categorieService.findAll();
	}

	public void add() {
		categorieService.add(newCategorie);
		newCategorie = new Categorie();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("categorie.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_categorie.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		categorieService.update(selectedCategorie);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("categorie.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		System.out.println(selectedCategorie.getCodeCategorie());
		categorieService.delete(categorieService.findById(selectedCategorie
				.getCodeCategorie()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("categorie.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Categorie> getListCategories() {
		return categorieService.findAll();
	}

	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	public Categorie getNewCategorie() {
		return newCategorie;
	}

	public void setNewCategorie(Categorie newCategorie) {
		this.newCategorie = newCategorie;
	}

	public CategorieService getCategorieService() {
		return categorieService;
	}

	public void setCategorieService(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

}
