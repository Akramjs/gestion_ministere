package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Organisme;

public interface OrganismeService {

	void add(Organisme g);

	void update(Organisme g);

	Organisme findById(String id);
	
	String findMaxId();

	List<Organisme> findAll();

	boolean delete(Organisme g);

}
