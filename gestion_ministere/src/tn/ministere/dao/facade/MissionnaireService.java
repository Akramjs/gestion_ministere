package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Missionnaire;

public interface MissionnaireService {
	void add(Missionnaire m);

	void update(Missionnaire m);

	Missionnaire findById(String cinMissionnaire);

	List<Missionnaire> findAll();

	boolean delete(Missionnaire m);


}
