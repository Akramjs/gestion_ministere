package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.PaysDestination;

public interface PaysDestinationService {

	void add(PaysDestination p);

	void update(PaysDestination p);

	PaysDestination findById(String id);

	List<PaysDestination> findAll();

	boolean delete(PaysDestination p);

}
