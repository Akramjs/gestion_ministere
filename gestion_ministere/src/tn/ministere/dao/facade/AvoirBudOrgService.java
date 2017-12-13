package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.AvoirBudorg;
import tn.ministere.entity.AvoirBudorgId;

public interface AvoirBudOrgService {

	void add(AvoirBudorg g);

	void update(AvoirBudorg g);

	AvoirBudorg findById(AvoirBudorgId id);

	List<AvoirBudorg> findAll();

	public List<AvoirBudorg> findAllNotValidated();

	boolean delete(AvoirBudorg g);

}
