package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Projet;

public interface ProjetService {

	void add(Projet f);

	void update(Projet f);

	Projet findById(String id);

	List<Projet> findAll();

	boolean delete(Projet f);

}
