package tn.ministere.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.FonctionService;
import tn.ministere.dao.facade.ThemeService;
import tn.ministere.entity.Theme;

@ManagedBean
@Component
public class MissionsManagedBean {

	private List<Theme> themes;
	private Theme theme;

	@Autowired
	private ThemeService themeService;
	@Autowired
	private FonctionService fonctionService;

	@PostConstruct
	public void init() {
		theme = new Theme();
		themes = themeService.findAll();
	}

	public void add() {

		Theme th = themeService.findById(theme.getCodeTheme());

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"missionnaire ajouté avec succée", null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}