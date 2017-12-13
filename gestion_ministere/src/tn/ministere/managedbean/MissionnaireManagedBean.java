package tn.ministere.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.CategorieService;
import tn.ministere.dao.facade.FonctionService;
import tn.ministere.dao.facade.GradeService;
import tn.ministere.dao.facade.GroupeService;
import tn.ministere.dao.facade.MissionnaireService;
import tn.ministere.entity.Categorie;
import tn.ministere.entity.Fonction;
import tn.ministere.entity.Grade;
import tn.ministere.entity.Groupe;
import tn.ministere.entity.Missionnaire;

@ManagedBean
@Component
public class MissionnaireManagedBean {
	private List<Grade> grades;
	private Grade grade;
	private List<Fonction> fonctions;
	private Fonction fonction;
	private List<Groupe> groupes;
	private Groupe groupe;
	private Missionnaire missionnaire;
	private List<Categorie> categories;
	private Categorie categorie;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private FonctionService fonctionService;
	@Autowired
	private GroupeService groupeService;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private MissionnaireService missionnaireService;

	@PostConstruct
	public void init() {
		missionnaire = new Missionnaire();
		missionnaire.setGrade(new Grade());
		missionnaire.setGroupe(new Groupe());
		missionnaire.setFonction(new Fonction());
		missionnaire.setCategorie(new Categorie());
		grade = new Grade();
		grades = gradeService.findAll();
		fonction = new Fonction();
		fonctions = fonctionService.findAll();
		groupe = new Groupe();
		groupes = groupeService.findAll();
		categorie = new Categorie();
		categories = categorieService.findAll();

	}

	public void add() {

		System.out.println(missionnaire.getCinMissionnaire());

		Categorie c1 = categorieService.findById(categorie.getCodeCategorie());
		Fonction f1 = fonctionService.findById(fonction.getCodeFonction());
		Groupe gr = groupeService.findById(groupe.getCodeGroupe());
		Grade gd = gradeService.findById(grade.getCodeGrade());
		missionnaire.setCategorie(c1);
		missionnaire.setFonction(f1);
		missionnaire.setGrade(gd);
		missionnaire.setGroupe(gr);
		missionnaireService.add(missionnaire);
		missionnaire = new Missionnaire();
		missionnaire.setGrade(new Grade());
		missionnaire.setGroupe(new Groupe());
		missionnaire.setFonction(new Fonction());
		missionnaire.setCategorie(new Categorie());

		groupe = new Groupe();
		categorie = new Categorie();
		grade = new Grade();
		fonction = new Fonction();

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"missionnaire ajoutÃ© avec succÃ©e", null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public Missionnaire getMissionnaire() {
		return missionnaire;
	}

	public void setMissionnaire(Missionnaire missionnaire) {
		this.missionnaire = missionnaire;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Fonction> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}