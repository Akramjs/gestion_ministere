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

import tn.ministere.dao.facade.TypeOrganismeService;
import tn.ministere.entity.TypeOrganisme;

@ManagedBean
@Component
@URLMapping(id="typeOrganisme",pattern="/edit_typeOrganisme.xhtml",viewId="/edit/edit_typeOrganisme.xhtml")

public class TypeOrganismeManagedBean implements Serializable {
	private List<TypeOrganisme> listTypeOrganismes;
	private TypeOrganisme newTypeOrganisme;
	private TypeOrganisme selectedTypeOrganisme;

	@Autowired
	private TypeOrganismeService typeOrganismeService;

	@PostConstruct
	public void init() {
		newTypeOrganisme = new TypeOrganisme();
		selectedTypeOrganisme = new TypeOrganisme();
		listTypeOrganismes = typeOrganismeService.findAll();
	}

	public String add() {
		System.out.println(newTypeOrganisme.getLibelleTypeOrganisme());
		typeOrganismeService.add(newTypeOrganisme);
		newTypeOrganisme = new TypeOrganisme();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("typeOrganisme.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_typeOrganisme.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		typeOrganismeService.update(selectedTypeOrganisme);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("categorie.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void delete() {
		typeOrganismeService.delete(typeOrganismeService
				.findById(selectedTypeOrganisme.getCodeTypeOrganisme()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("typeOrganisme.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<TypeOrganisme> getListTypeOrganismes() {
		return typeOrganismeService.findAll();
	}

	public void setListTypeOrganismes(List<TypeOrganisme> listTypeOrganismes) {
		this.listTypeOrganismes = listTypeOrganismes;
	}

	public TypeOrganisme getNewTypeOrganisme() {
		return newTypeOrganisme;
	}

	public void setNewTypeOrganisme(TypeOrganisme newTypeOrganisme) {
		this.newTypeOrganisme = newTypeOrganisme;
	}

	public TypeOrganismeService getTypeOrganismeService() {
		return typeOrganismeService;
	}

	public void setTypeOrganismeService(
			TypeOrganismeService TypeOrganismeService) {
		this.typeOrganismeService = TypeOrganismeService;
	}

	public TypeOrganisme getSelectedTypeOrganisme() {
		return selectedTypeOrganisme;
	}

	public void setSelectedTypeOrganisme(TypeOrganisme selectedTypeOrganisme) {
		this.selectedTypeOrganisme = selectedTypeOrganisme;
	}

}
