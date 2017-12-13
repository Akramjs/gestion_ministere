package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Annee;

public interface AnneeService {
	Annee findById(int id);

	List<Annee> findAll();

}
