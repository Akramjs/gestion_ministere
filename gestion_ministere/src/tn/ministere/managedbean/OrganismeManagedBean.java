package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.OrganismeService;
import tn.ministere.dao.facade.TypeOrganismeService;
import tn.ministere.entity.Organisme;
import tn.ministere.entity.TypeOrganisme;

@ManagedBean
@Component
public class OrganismeManagedBean {
	private List<Organisme> listOrganismes;
	private Organisme newOrganisme;

	@Autowired
	private OrganismeService organismeService;
	@Autowired
	private TypeOrganismeService typeOrganismeService;

	@PostConstruct
	public void init() {
		newOrganisme = new Organisme();
		newOrganisme.setTypeOrganisme(new TypeOrganisme());
		listOrganismes = organismeService.findAll();
	}

	public void add() {
		newOrganisme.setCodeOrg(organismeService.findMaxId());
		newOrganisme.setTypeOrganisme(typeOrganismeService
				.findById(newOrganisme.getTypeOrganisme()
						.getCodeTypeOrganisme()));
		organismeService.add(newOrganisme);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("organismes.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reinit() {
		newOrganisme = new Organisme();
		newOrganisme.setTypeOrganisme(new TypeOrganisme());
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("organismes.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Organisme> getListOrganismes() {
		return organismeService.findAll();
	}

	public void setListOrganismes(List<Organisme> listOrganismes) {
		this.listOrganismes = listOrganismes;
	}

	public Organisme getNewOrganisme() {
		return newOrganisme;
	}

	public void setNewOrganisme(Organisme newOrganisme) {
		this.newOrganisme = newOrganisme;
	}

	public OrganismeService getOrganismeService() {
		return organismeService;
	}

	public void setOrganismeService(OrganismeService OrganismeService) {
		this.organismeService = OrganismeService;
	}

	public TypeOrganismeService getTypeOrganismeService() {
		return typeOrganismeService;
	}

	public void setTypeOrganismeService(
			TypeOrganismeService typeOrganismeService) {
		this.typeOrganismeService = typeOrganismeService;
	}

}
