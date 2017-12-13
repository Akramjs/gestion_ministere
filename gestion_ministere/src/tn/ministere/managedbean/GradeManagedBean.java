package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.GradeService;
import tn.ministere.entity.Grade;

@ManagedBean
@Component
@URLMapping(id="grade",pattern="/edit_grade.xhtml",viewId="/edit/edit_grade.xhtml")

public class GradeManagedBean {
	private List<Grade> listGrades;
	private Grade newGrade;
	private Grade selectedGrade;

	@Autowired
	private GradeService gradeService;

	@PostConstruct
	public void init() {
		newGrade = new Grade();
		selectedGrade = new Grade();
		listGrades = gradeService.findAll();
	}

	public void add() {
		gradeService.add(newGrade);
		newGrade = new Grade();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("grades.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_grade.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(){
		gradeService.delete(gradeService.findById(selectedGrade.getCodeGrade()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("grades.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update() {
		
		gradeService.update(selectedGrade);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("grades.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Grade> getListGrades() {
		return gradeService.findAll();
	}

	public void setListGrades(List<Grade> listGrades) {
		this.listGrades = listGrades;
	}

	public Grade getNewGrade() {
		return newGrade;
	}

	public void setNewGrade(Grade newGrade) {
		this.newGrade = newGrade;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public Grade getSelectedGrade() {
		return selectedGrade;
	}

	public void setSelectedGrade(Grade selectedGrade) {
		this.selectedGrade = selectedGrade;
	}

}
