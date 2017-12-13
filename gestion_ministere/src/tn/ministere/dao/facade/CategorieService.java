package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Categorie;

public interface CategorieService {

	void add(Categorie g);

	void update(Categorie g);

	Categorie findById(String id);

	List<Categorie> findAll();

	boolean delete(Categorie g);

}
