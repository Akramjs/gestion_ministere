package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Fonction;

public interface FonctionService {

	void add(Fonction f);

	void update(Fonction f);

	Fonction findById(String id);

	List<Fonction> findAll();

	boolean delete(Fonction f);

}
