package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Groupe;

public interface GroupeService {

	void add(Groupe g);

	void update(Groupe g);

	Groupe findById(String id);

	List<Groupe> findAll();

	boolean delete(Groupe g);

}
