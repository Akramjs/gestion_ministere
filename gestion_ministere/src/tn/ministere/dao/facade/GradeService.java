package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Grade;

public interface GradeService {

	void add(Grade g);

	void update(Grade g);

	Grade findById(String id);

	List<Grade> findAll();

	boolean delete(Grade g);

}
