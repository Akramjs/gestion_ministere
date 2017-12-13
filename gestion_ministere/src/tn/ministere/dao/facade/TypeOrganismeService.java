package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.TypeOrganisme;

public interface TypeOrganismeService {

	void add(TypeOrganisme g);

	void update(TypeOrganisme g);

	TypeOrganisme findById(String id);

	List<TypeOrganisme> findAll();

	boolean delete(TypeOrganisme g);

}
