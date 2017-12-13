package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.GroupeService;
import tn.ministere.entity.Groupe;

@ManagedBean
@Component
@URLMapping(id="groupe",pattern="/edit_groupes.xhtml",viewId="/edit/edit_groupes.xhtml")

public class GroupeManagedBean {
	private List<Groupe> listGroupes;
	private Groupe newGroupe;
	private Groupe selectedGroupe;

	@Autowired
	private GroupeService groupeService;

	@PostConstruct
	public void init() {
		newGroupe = new Groupe();
		selectedGroupe = new Groupe();
		listGroupes = groupeService.findAll();
	}

	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_groupes.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add() {
		groupeService.add(newGroupe);
		newGroupe = new Groupe();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("groupes.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		groupeService.update(selectedGroupe);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("groupes.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		groupeService.delete(groupeService.findById(selectedGroupe
				.getCodeGroupe()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("groupes.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Groupe> getListGroupes() {
		return groupeService.findAll();
	}

	public void setListGroupes(List<Groupe> listGroupes) {
		this.listGroupes = listGroupes;
	}

	public Groupe getNewGroupe() {
		return newGroupe;
	}

	public void setNewGroupe(Groupe newGroupe) {
		this.newGroupe = newGroupe;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public Groupe getSelectedGroupe() {
		return selectedGroupe;
	}

	public void setSelectedGroupe(Groupe selectedGroupe) {
		this.selectedGroupe = selectedGroupe;
	}

}
